package com.ziyao.harbor.crypto;

import lombok.Setter;

/**
 * @author ziyao
 */
@Setter
public class SpiCodecContext implements CodecContext {

    private EncryptCallback encryptCallback;

    private DecryptCallback decryptCallback;

    @Override
    public EncryptCallback getEncryptCallback() {
        return encryptCallback;
    }

    @Override
    public DecryptCallback getDecryptCallback() {
        return decryptCallback;
    }

}
