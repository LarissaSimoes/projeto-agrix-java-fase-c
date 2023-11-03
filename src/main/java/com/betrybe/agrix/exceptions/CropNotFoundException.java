package com.betrybe.agrix.exceptions;

/**
 * This class represents a crop not found exception.
 */
public class CropNotFoundException extends RuntimeException {
  public CropNotFoundException(String message) {
    super(message);
  }
}
