package com.betrybe.museumfinder.exception;

/**
 * Uma exceção não verificada que é lançada quando uma coordenada inválida é encontrada.
 * Esta exceção estende RuntimeException.
 */

public class InvalidCoordinateException extends RuntimeException {
  public InvalidCoordinateException(String message) {
    super(message);
  }
}
