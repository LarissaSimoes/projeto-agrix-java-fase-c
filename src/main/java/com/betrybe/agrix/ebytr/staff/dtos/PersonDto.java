package com.betrybe.agrix.ebytr.staff.dtos;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * DTO for a person.
 */
public record PersonDto(String username, String password, Role role) {

  /**
   * Converts this DTO to an entity.
   */
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }

}
