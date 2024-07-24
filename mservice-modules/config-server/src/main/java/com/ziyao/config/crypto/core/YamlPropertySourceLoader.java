package com.ziyao.config.crypto.core;


import com.ziyao.config.core.OriginTrackedYamlProcessor;
import com.ziyao.crypto.Property;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ziyao zhang
 */
public class YamlPropertySourceLoader implements PropertySourceLoader {

    @Override
    public String[] getFileExtensions() {
        return new String[]{"yml", "yaml"};
    }

    @Override
    public List<Property> load(InputStream inputStream) {

        List<Map<String, Object>> loaded = new OriginTrackedYamlProcessor(inputStream).load();
        if (loaded.isEmpty()) {
            return Collections.emptyList();
        }
        List<Property> propertySources = new ArrayList<>(loaded.size());
        for (Map<String, Object> map : loaded) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                propertySources.add(new Property(entry.getKey(), entry.getValue()));

            }
        }
        return propertySources;
    }
}
