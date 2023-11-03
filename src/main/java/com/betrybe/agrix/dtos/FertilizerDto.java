package com.betrybe.agrix.dtos;

import com.betrybe.agrix.models.entities.Fertilizer;

/**
 * This class represents a fertilizer DTO.
 */
public record FertilizerDto(
    Integer id,
    String name,
    String brand,
    String composition
) {
  public Fertilizer toEntity() {
    return new Fertilizer(id, name, brand, composition, null);
  }

}
