package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Esta classe representa o serviço de gestão de museus.
 *
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase fakedb;


  public MuseumService(MuseumFakeDatabase fakedb) {
    this.fakedb = fakedb;
  }

  /**
   * Lança uma exceção se a validação da coordenada falhar.
   *
   * @param validateCoordinate Se a validação da coordenada falhou.
   */
  public void verifyAndThrowError(boolean validateCoordinate) {
    if (!validateCoordinate) {
      throw new InvalidCoordinateException();
    }
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    boolean coordinateValid = CoordinateUtil.isCoordinateValid(coordinate);
    verifyAndThrowError(coordinateValid);
    Optional<Museum> closestMuseum = fakedb.getClosestMuseum(coordinate, maxDistance);
    if (closestMuseum.isEmpty()) {
      throw new MuseumNotFoundException();
    }
    return closestMuseum.get();
  }

  @Override
  public Museum createMuseum(Museum museum) {
    boolean coordinateValid = CoordinateUtil.isCoordinateValid(museum.getCoordinate());
    verifyAndThrowError(coordinateValid);
    return fakedb.saveMuseum(museum);
  }

  @Override
  public Museum  getMuseum(Long id) {
    Optional<Museum> getMuseum = fakedb.getMuseum(id);
    return getMuseum.orElse(null);
  }
}
