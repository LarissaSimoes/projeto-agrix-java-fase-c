package com.betrybe.agrix.ebytr.staff.dtos;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * DTO for a person.
 */
public record PersonResponseDto(Long id, String username, Role role) {

  /**
   * Converts an entity to this DTO.
   */
  public static PersonResponseDto fromEntity(Person person) {
    return new PersonResponseDto(
        person.getId(), person.getUsername(), person.getRole()
        );
  }

}
