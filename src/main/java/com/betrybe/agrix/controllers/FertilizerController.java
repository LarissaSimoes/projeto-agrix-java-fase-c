package com.betrybe.agrix.controllers;

import com.betrybe.agrix.dtos.FertilizerDto;
import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.services.FertilizerService;
import java.util.List;
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
 * This class represents a fertilizer controller.
 */
@RestController
@RequestMapping("/fertilizers")
public class FertilizerController {

  private final FertilizerService fertilizerService;

  @Autowired
  public FertilizerController(FertilizerService fertilizerService) {
    this.fertilizerService = fertilizerService;
  }

  @PostMapping()
  public ResponseEntity<Fertilizer> create(@RequestBody FertilizerDto fertilizerDto) {
    Fertilizer newFertilizer = fertilizerService.create(fertilizerDto.toEntity());
    return ResponseEntity.status(201).body(newFertilizer);
  }

  @GetMapping()
  public List<Fertilizer> findAll() {
    return fertilizerService.findAll();
  }

  /**
   * This method finds a fertilizer by id.
   */
  @GetMapping("/{id}")
  public ResponseEntity<Object> findById(@PathVariable Integer id) {
    try {
      Fertilizer fertilizer = fertilizerService.findById(id);
      return ResponseEntity.ok(fertilizer);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Fertilizante não encontrado!");
    }

  }

}
