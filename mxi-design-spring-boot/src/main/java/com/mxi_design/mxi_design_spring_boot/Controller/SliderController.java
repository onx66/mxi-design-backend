package com.mxi_design.mxi_design_spring_boot.Controller;


import com.mxi_design.mxi_design_spring_boot.Dto.SliderCreateRequest;
import com.mxi_design.mxi_design_spring_boot.Dto.SliderResponseDto;
import com.mxi_design.mxi_design_spring_boot.Service.SliderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/sliders")
@CrossOrigin
public class SliderController {

    private final SliderService sliderService;

    public SliderController(SliderService sliderService) {
        this.sliderService = sliderService;
    }

    // ✅ GET ALL
    @GetMapping
    public List<SliderResponseDto> getAll() {
        return sliderService.getAll();
    }

    // ✅ CREATE
    @PostMapping(consumes = "multipart/form-data")
    public SliderResponseDto create(
            @RequestPart("image") MultipartFile image,
            @RequestPart("data") SliderCreateRequest request
    ) {
        return sliderService.create(image, request);
    }

    // ✅ UPDATE
    @PutMapping(
            value = "/{id}",
            consumes = "multipart/form-data"
    )
    public SliderResponseDto update(
            @PathVariable Long id,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart("data") SliderCreateRequest request
    ) {
        return sliderService.update(id, image, request);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sliderService.delete(id);
    }
}