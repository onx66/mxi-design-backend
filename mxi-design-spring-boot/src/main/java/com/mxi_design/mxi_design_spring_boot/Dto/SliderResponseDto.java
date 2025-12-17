package com.mxi_design.mxi_design_spring_boot.Dto;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class SliderResponseDto {


    private Long id;
    private String imageUrl;
    private String code;
    private String title;
    private String description;
    private String welcomeText;


    {
        this.id = id;
        this.imageUrl = imageUrl;
        this.code = code;
        this.title = title;
        this.description = description;
        this.welcomeText = welcomeText;
    }

    public Long getId() {
        return id;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public String getDescription() {
        return description;
    }


    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
