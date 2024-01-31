package com.betrybe.museumfinder.service;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.util.CoordinateUtil;
import org.springframework.stereotype.Service;

/**
 * * Esta classe representa o serviço de gestão de museus.
 */
@Service
public class MuseumService implements MuseumServiceInterface {

  private final MuseumFakeDatabase fakedb;

  public MuseumService(MuseumFakeDatabase fakedb) {
    this.fakedb = fakedb;
  }

  @Override
  public Museum getClosestMuseum(Coordinate coordinate, Double maxDistance) {
    return null;
  }

  @Override
  public Museum createMuseum(Museum museum) {
    boolean validateCoordinate = CoordinateUtil.isCoordinateValid(museum.getCoordinate());
    if (!validateCoordinate) {
      throw new InvalidCoordinateException();
    }
    return fakedb.saveMuseum(museum);
  }

  @Override
  public Museum getMuseum(Long id) {
    return null;
  }
}
