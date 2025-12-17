package com.mxi_design.mxi_design_spring_boot.Repository;



import com.mxi_design.mxi_design_spring_boot.Entity.SliderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SliderRepository extends JpaRepository<SliderItem, Long> {
}
