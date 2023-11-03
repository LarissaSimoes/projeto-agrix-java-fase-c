package com.betrybe.agrix.exceptions;

/**
 * This class represents a fertilizer not found exception.
 */
public class FertilizerNotFoundException extends RuntimeException {
  public FertilizerNotFoundException(String message) {
    super(message);
  }
}
