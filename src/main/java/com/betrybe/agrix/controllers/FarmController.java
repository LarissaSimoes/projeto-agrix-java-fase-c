package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.CropDto;
import com.betrybe.agrix.dtos.FarmDto;
import com.betrybe.agrix.dtos.FarmResponseDto;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.services.CropService;
import com.betrybe.agrix.services.FarmService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class represents a farm controller.
 */
@RestController
@RequestMapping("/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  private final CropService cropService;

  public FarmController(FarmService farmService, CropService cropService) {
    this.farmService = farmService;
    this.cropService = cropService;
  }

  /**
   * This method creates a farm.
   */
  @PostMapping
  public ResponseEntity<FarmResponseDto> create(@RequestBody FarmDto farmDto) {
    Farm newFarm = farmService.create(farmDto.toFarm());
    FarmResponseDto farmResponseDto = FarmResponseDto.fromFarm(newFarm);
    return ResponseEntity.status(201).body(farmResponseDto);
  }

  /**
   * This method finds all farms.
   */
  @GetMapping
  public List<Farm> findAll() {
    return farmService.findAll();
  }

  /**
   * This method finds a farm by id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
    Optional<Farm> farmOptional = farmService.findById(id);
    if (farmOptional.isPresent()) {
      Farm farm = farmOptional.get();
      FarmResponseDto farmResponseDto = FarmResponseDto.fromFarm(farm);
      return ResponseEntity.ok(farmResponseDto);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("Fazenda não encontrada!");
    }
  }

  /**
   * This method creates a crop.
   */
  @PostMapping("/{farmId}/crops")
  public ResponseEntity<Object> createCrop(@PathVariable("farmId") Integer farmId,
      @RequestBody CropDto cropDto) {
    CropDto savedCrop;
    try {
      savedCrop = cropService.createCrop(farmId, cropDto);
      Crop crop = new Crop();
      crop.setName(cropDto.name());
      crop.setPlantedArea(cropDto.plantedArea());
      crop.setPlantedDate(cropDto.plantedDate());
      crop.setHarvestDate(cropDto.harvestDate());
      return ResponseEntity.status(201).body(savedCrop);
    } catch (RuntimeException e) {
      return ResponseEntity.status(404).body(e.getMessage());
    }
  }

  /**
   * This method gets all crops that belongs to one farm.
   */
  @GetMapping("/{farmId}/crops")
  public ResponseEntity<Object> getCropsByFarmId(@PathVariable("farmId") Integer farmId) {
    List<CropDto> crops;
    try {
      crops = cropService.getCropsByFarmId(farmId);
      return ResponseEntity.ok(crops);
    } catch (RuntimeException e) {
      return ResponseEntity.status(404).body(e.getMessage());
    }
  }

}
