package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Farm;

/**
 * This class represents a farm response DTO.
 */
public record FarmResponseDto(Integer id, String name, Double size) {
  public static FarmResponseDto fromFarm(Farm farm) {
    return new FarmResponseDto(farm.getId(), farm.getName(), farm.getSize());
  }
}


