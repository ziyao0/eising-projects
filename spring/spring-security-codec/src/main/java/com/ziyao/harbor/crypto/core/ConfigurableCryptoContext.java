package com.ziyao.harbor.crypto.core;

import com.ziyao.crypto.PropertyResolver;
import com.ziyao.crypto.TextCipherProvider;
import lombok.Getter;

/**
 * @author ziyao zhang
 */
@Getter
public class ConfigurableCryptoContext implements CryptoContext {

    private CodebookProperties properties;

    private PropertyResolver propertyResolver;

    private TextCipherProvider textCipherProvider;

    private boolean failOnError;

    public void setProperties(CodebookProperties properties) {
        this.properties = properties;
    }

    public void setPropertyResolver(PropertyResolver propertyResolver) {
        this.propertyResolver = propertyResolver;
    }

    public void setTextCipherProvider(TextCipherProvider textCipherProvider) {
        this.textCipherProvider = textCipherProvider;
    }

    public void setFailOnError(boolean failOnError) {
        this.failOnError = failOnError;
    }
}