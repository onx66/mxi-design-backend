package com.mxi_design.mxi_design_spring_boot.Config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(Map.of(
                "cloud_name", "doxtucpsz",
                "api_key", "237429911964674",
                "api_secret", "ZE3Z6qvLXh_6HqCCrwwdNii9TVs"
        ));
    }
}