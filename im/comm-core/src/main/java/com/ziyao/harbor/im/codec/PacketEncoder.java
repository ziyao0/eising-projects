package com.ziyao.harbor.im.codec;

import com.ziyao.harbor.im.api.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

/**
 * @author ziyao zhang
 */
@ChannelHandler.Sharable
public class PacketEncoder extends MessageToByteEncoder<Packet> {

    private static final InternalLogger LOGGER = InternalLoggerFactory.getInstance(PacketEncoder.class);

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf byteBuf) throws Exception {
        if (packet != null) {
            byte[] data = Protostuff.serialize(packet);
            byteBuf.writeInt(data.length);
            byteBuf.writeBytes(data);
        }
    }
}
