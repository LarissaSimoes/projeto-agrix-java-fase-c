package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Farm;

/**
 * This class represents a farm dto.
 */
public record FarmDto(Integer id, String name, Double size) {
  public Farm toFarm() {
    return new Farm(id, name, size, null);
  }

}
