package com.ziyao.config.services.config;

import com.ziyao.config.core.ConfigType;

/**
 * @author ziyao
 * @see <a href="https://blog.zziyao.cn">https://blog.zziyao.cn</a>
 */
public class ConsulConfigManager implements ConfigManager{
    @Override
    public boolean publishing(String dataId, String groupId, String content, ConfigType configType) {
        return false;
    }

    @Override
    public String getConfig(String dataId, String groupId) {
        return "";
    }

    @Override
    public boolean removeConfig(String dataId, String groupId) {
        return false;
    }
}
