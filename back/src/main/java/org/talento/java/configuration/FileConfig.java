package org.talento.java.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;

@Configuration
public class FileConfig implements WebMvcConfigurer {
    private final String dirName;

    public FileConfig(@Value("${file.upload-dir}") String dirName) {
        this.dirName = dirName;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        var uploadPath = Path.of(dirName).toFile().getAbsolutePath();
        String fileLocation = "file:" + uploadPath + "/";

        registry
                .addResourceHandler("/" + dirName +"/private/**")
                .addResourceLocations(fileLocation + "private/");

        registry
                .addResourceHandler("/" + dirName +"/public/**")
                .addResourceLocations(fileLocation + "public/");
    }
}