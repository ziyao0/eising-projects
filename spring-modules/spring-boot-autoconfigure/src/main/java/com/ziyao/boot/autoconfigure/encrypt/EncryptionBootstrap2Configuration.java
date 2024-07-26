package com.ziyao.boot.autoconfigure.encrypt;

import com.ziyao.ideal.crypto.EnvironmentDecryptApplicationInitializerDecryptor;
import com.ziyao.ideal.crypto.core.CodebookProperties;
import com.ziyao.ideal.crypto.core.CryptoContextFactory;
import com.ziyao.ideal.crypto.core.DefaultCryptoContextFactory;
import com.ziyao.ideal.crypto.druid.DataSourceBeanPostProcessor;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.bootstrap.encrypt.EncryptionBootstrapConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ziyao zhang
 */
@Configuration
@AutoConfigureBefore(EncryptionBootstrapConfiguration.class)
@EnableConfigurationProperties(CodebookProperties.class)
public class EncryptionBootstrap2Configuration {


    @Bean
    @ConditionalOnClass(name = {
            "com.ziyao.crypto.TextCipher",
            "com.ziyao.ideal.core.codec.StringCodec"
    })
    public CryptoContextFactory cipherContextFactory() {
        return new DefaultCryptoContextFactory();
    }

    @Bean
    public EnvironmentDecryptApplicationInitializerDecryptor codecEnvironmentApplicationInitializer() {
        return new EnvironmentDecryptApplicationInitializerDecryptor(cipherContextFactory());
    }

    @Configuration
    @ConditionalOnClass(name = {
            "org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration",
            "com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure"
    })
    @ConditionalOnBean(CryptoContextFactory.class)
    @Import(DataSourceBeanPostProcessor.Registrar.class)
    public static class DataSourceAutoConfiguration {

    }
}