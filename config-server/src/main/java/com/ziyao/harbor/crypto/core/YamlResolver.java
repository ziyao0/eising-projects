package com.ziyao.harbor.crypto.core;

import com.ziyao.eis.core.Collections;
import com.ziyao.eis.core.Strings;
import com.ziyao.crypto.Property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ziyao zhang
 */
public final class YamlResolver {

    public static List<Property> extract(String location) throws IOException {
        File propertiesFile = getPropertiesFile(location);
        return loadYaml(propertiesFile);
    }

    /**
     * 从文件中提取环境变量
     *
     * @param propertiesFile 配置文件
     * @return 返回 {@link Property}
     * @throws IOException 读取配置文件失败后所抛出的流异常
     */
    public static List<Property> loadYaml(File propertiesFile) throws IOException {
        if (propertiesFile == null) {
            return null;
        }
        return loadYaml(new FileInputStream(propertiesFile));
    }

    /**
     * 从文件中提取环境变量
     *
     * @param inputStream 配置文件
     * @return 返回 {@link Property}
     */
    public static List<Property> loadYaml(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        YamlPropertySourceLoader yamlPropertySourceLoader = new YamlPropertySourceLoader();
        return yamlPropertySourceLoader.load(inputStream);
    }


    /**
     * 把配置信息写入指定的配置文件中
     *
     * @param properties     配置信息
     * @param propertiesPath 写入目标路径
     * @throws IOException 读取配置文件失败后所抛出的流异常
     */
    public static void writeYaml(List<Property> properties, String propertiesPath) throws IOException {

        if (propertiesPath == null
                || Collections.isEmpty(properties)) {
            return;
        }
        YamlPropertySourceWriter writer = new YamlPropertySourceWriter();
        writer.write(properties, propertiesPath);
    }

    private static File getPropertiesFile(String configPath) {
        if (Strings.hasText(configPath))
            return getPropertiesFileForConfigPath(configPath);
        else
            return null;
    }

    private static File getPropertiesFileForConfigPath(String configPath) {
        File file = new File(configPath);
        if (file.exists() && file.isFile())
            return file;
        else
            return null;
    }
}
