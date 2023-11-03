package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Crop;
import java.time.LocalDate;

/**
 * This class represents a crop dto.
 */
public record CropDto(Integer id, String name, Double plantedArea, Integer farmId,
                      LocalDate plantedDate, LocalDate harvestDate) {
  public static CropDto fromCrop(Crop crop) {
    return new CropDto(crop.getId(), crop.getName(), crop.getPlantedArea(), crop.getFarm().getId(),
        crop.getPlantedDate(), crop.getHarvestDate());
  }

}
