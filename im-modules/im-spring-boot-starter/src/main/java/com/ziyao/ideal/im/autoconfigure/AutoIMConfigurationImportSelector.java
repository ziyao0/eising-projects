package com.ziyao.ideal.im.autoconfigure;

import com.ziyao.ideal.core.Strings;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

/**
 * @author ziyao zhang
 */
@Getter
public class AutoIMConfigurationImportSelector implements DeferredImportSelector,
        BeanFactoryAware, BeanClassLoaderAware, EnvironmentAware {

    private ConfigurableListableBeanFactory beanFactory;
    private Environment environment;
    @Setter
    private ClassLoader classLoader;

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        this.environment = environment;
    }

    @NonNull
    @Override
    public String[] selectImports(@NonNull AnnotationMetadata annotationMetadata) {
        // 加载需要导入的候选bean
        ImportCandidatesLoader importCandidates = ImportCandidatesLoader.load(IMAutoConfiguration.class, getClassLoader());
        return Strings.toStringArray(importCandidates.getCandidates());
    }

    @Override
    public void setBeanFactory(@NonNull BeanFactory beanFactory) throws BeansException {
        Assert.isInstanceOf(ConfigurableListableBeanFactory.class, beanFactory);
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    }

    @Override
    public void setBeanClassLoader(@NonNull ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

}
