package com.mxi_design.mxi_design_spring_boot.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SliderCreateRequest {
    private String code;
    private String title;
    private String description;
    private String welcomeText;
}