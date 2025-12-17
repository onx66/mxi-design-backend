package com.mxi_design.mxi_design_spring_boot.Service;

import com.mxi_design.mxi_design_spring_boot.Dto.SliderCreateRequest;
import com.mxi_design.mxi_design_spring_boot.Dto.SliderResponseDto;
import com.mxi_design.mxi_design_spring_boot.Entity.SliderItem;
import com.mxi_design.mxi_design_spring_boot.Repository.SliderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class SliderService {

    private final SliderRepository sliderRepository;
    private final CloudinaryService cloudinaryService;

    public SliderService(SliderRepository sliderRepository,
                         CloudinaryService cloudinaryService) {
        this.sliderRepository = sliderRepository;
        this.cloudinaryService = cloudinaryService;
    }

    // GET ALL
    public List<SliderResponseDto> getAll() {
        return sliderRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    // CREATE
    public SliderResponseDto create(MultipartFile image, SliderCreateRequest req) {
        String imageUrl = cloudinaryService.upload(image, "slider");

        SliderItem item = new SliderItem();
        fillEntity(item, req);
        item.setImageUrl(imageUrl);

        sliderRepository.save(item);
        return mapToDto(item);
    }

    // UPDATE
    public SliderResponseDto update(Long id,
                                    MultipartFile image,
                                    SliderCreateRequest req) {

        SliderItem item = sliderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slider not found"));

        // image geldiyse değiştir
        if (image != null && !image.isEmpty()) {
            String newUrl = cloudinaryService.upload(image, "slider");
            item.setImageUrl(newUrl);
        }

        fillEntity(item, req);

        sliderRepository.save(item);
        return mapToDto(item);
    }

    // DELETE
    public void delete(Long id) {
        SliderItem item = sliderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slider not found"));

        sliderRepository.delete(item);
    }

    // ------------------------

    private void fillEntity(SliderItem item, SliderCreateRequest req) {
        item.setCode(req.getCode());
        item.setTitle(req.getTitle());
        item.setDescription(req.getDescription());
        item.setWelcomeText(req.getWelcomeText());
    }

    private SliderResponseDto mapToDto(SliderItem item) {
        return new SliderResponseDto(
                item.getId(),
                item.getImageUrl(),
                item.getCode(),
                item.getTitle(),
                item.getDescription(),
                item.getWelcomeText()
        );
    }
}
