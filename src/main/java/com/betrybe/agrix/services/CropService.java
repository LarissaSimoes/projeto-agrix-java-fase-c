package com.betrybe.agrix.services;

import com.betrybe.agrix.dtos.CropDto;
import com.betrybe.agrix.exceptions.CropNotFoundException;
import com.betrybe.agrix.exceptions.FertilizerNotFoundException;
import com.betrybe.agrix.models.entities.Crop;
import com.betrybe.agrix.models.entities.Farm;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.CropRepository;
import com.betrybe.agrix.models.repositories.FarmRepository;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents a crop service.
 */
@Service
public class CropService {

  @Autowired
  private CropRepository cropRepository;

  @Autowired
  private FarmRepository farmRepository;

  @Autowired
  private FarmService farmService;

  @Autowired
  private FertilizerRepository fertilizerRepository;

  /**
   * This method creates a crop.
   */
  public CropDto createCrop(Integer farmId, CropDto cropDto) {
    Optional<Farm> farmOptional = farmRepository.findById(farmId);

    if (farmOptional.isPresent()) {
      Farm farm = farmOptional.get();
      Crop crop = new Crop();
      crop.setName(cropDto.name());
      crop.setPlantedArea(cropDto.plantedArea());
      crop.setFarm(farm);
      crop.setPlantedDate(cropDto.plantedDate());
      crop.setHarvestDate(cropDto.harvestDate());
      Crop savedCrop = cropRepository.save(crop);
      return CropDto.fromCrop(savedCrop);
    } else {
      throw new RuntimeException("Fazenda não encontrada!");
    }
  }

  /**
   * This method gets all crops that belongs to one farm.
   */
  public List<CropDto> getCropsByFarmId(Integer farmId) {
    Optional<Farm> farmOptional = farmService.findById(farmId);

    if (farmOptional.isPresent()) {
      Farm farm = farmOptional.get();
      List<Crop> crops = cropRepository.findByFarmId(farmId);
      return crops.stream()
          .map(crop -> CropDto.fromCrop(crop))
          .collect(Collectors.toList());
    } else {
      throw new RuntimeException("Fazenda não encontrada!");
    }
  }

  /**
   * This method gets all crops.
   */
  public List<CropDto> getAllCrops() {
    List<Crop> crops = cropRepository.findAll();

    return crops.stream()
        .map(crop -> CropDto.fromCrop(crop))
        .collect(Collectors.toList());
  }

  /**
   * This method gets a crop by id.
   */
  public Optional<CropDto> findById(Integer id) {
    Optional<Crop> cropOptional = cropRepository.findById(id);

    if (cropOptional.isPresent()) {
      Crop crop = cropOptional.get();
      return Optional.of(CropDto.fromCrop(crop));
    } else {
      return Optional.empty();
    }
  }

  /**
   * This method finds all crops by harvest date.
   */
  public List<Crop> findCropsByHarvestDate(LocalDate start, LocalDate end) {
    return cropRepository.findByHarvestDateBetween(start, end);
  }

  /**
   * This method associates a crop with a fertilizer.
   */
  public void associateCropWithFertilizer(Integer cropId, Integer fertilizerId) {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));

    Fertilizer fertilizer = fertilizerRepository.findById(fertilizerId)
        .orElseThrow(() -> new FertilizerNotFoundException("Fertilizante não encontrado!"));

    crop.getFertilizer().add(fertilizer);
    cropRepository.save(crop);
  }

  /**
   * This method gets all fertilizers that belongs to a crop.
   */
  public List<Fertilizer> listFertilizersByCropId(Integer cropId) {
    Crop crop = cropRepository.findById(cropId)
        .orElseThrow(() -> new CropNotFoundException("Plantação não encontrada!"));
    return crop.getFertilizer();
  }

}
