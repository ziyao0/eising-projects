package io.ziyao.gradle.project;

import io.ziyao.gradle.ProjectUtils;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.compile.JavaCompile;

/**
 * @author ziyao
 *
 */
public class SpringJavaPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {

        project.getPlugins().apply(CopyPropertyFormRootProjectPlugin.class);

        project.getConfigurations().configureEach(
                configuration -> configuration.setTransitive(true)
        );

//        Configuration compileOnly = project.getConfigurations().create("compileOnly");
//
//        Configuration annotationProcessor = project.getConfigurations().getByName("annotationProcessor");
//        compileOnly.extendsFrom(annotationProcessor);

        // set encoding and sourceCompatibility
        project.getTasks().withType(
                JavaCompile.class, javaCompile -> {
                    javaCompile.setSourceCompatibility(
                            ProjectUtils.findProperty("sourceCompatibilityVersion", project));

                    javaCompile.getOptions().setEncoding(
                            ProjectUtils.findProperty("encoding", project));
                });
    }
}
