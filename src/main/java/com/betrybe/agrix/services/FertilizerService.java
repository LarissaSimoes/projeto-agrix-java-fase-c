package com.betrybe.agrix.services;

import com.betrybe.agrix.models.entities.Fertilizer;
import com.betrybe.agrix.models.repositories.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class represents a fertilizer service.
 */
@Service
public class FertilizerService {

  @Autowired
  private FertilizerRepository fertilizerRepository;

  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizerRepository.save(fertilizer);
  }

  public List<Fertilizer> findAll() {
    return fertilizerRepository.findAll();
  }

  public Fertilizer findById(Integer id) {
    return fertilizerRepository.findById(id).orElseThrow();
  }

}
