package com.ziyao.ideal.config.crypto.core;

import com.ziyao.crypto.Property;

import java.io.InputStream;
import java.util.List;

/**
 * @author ziyao zhang
 */
public interface PropertySourceLoader {

    /**
     * Returns the file extensions that the loader supports (excluding the '.').
     *
     * @return the file extensions
     */
    String[] getFileExtensions();

    /**
     * Load the resource into one or more property sources. Implementations may either
     * return a list containing a single source, or in the case of a multi-document format
     * such as yaml a source for each document in the resource.
     * <p>
     * param name        the root name of the property source. If multiple documents are loaded
     * an additional suffix should be added to the name for each source loaded.
     *
     * @param inputStream the resource to load
     * @return a list property sources
     */
    List<Property> load(InputStream inputStream);
}