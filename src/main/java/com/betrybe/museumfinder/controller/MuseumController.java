package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.dto.MuseumCreationDto;
import com.betrybe.museumfinder.dto.MuseumDto;
import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumServiceInterface;
import com.betrybe.museumfinder.util.ModelDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controladora para lidar com operações relacionadas ao museu.
 */
@RestController
@RequestMapping("/museums")
public class MuseumController {

  private final MuseumServiceInterface museumService;

  public MuseumController(MuseumServiceInterface museumService) {
    this.museumService = museumService;
  }

  @PostMapping
  public ResponseEntity<Museum> newMuseum(@RequestBody MuseumCreationDto newMuseum) {
    Museum savedMuseum = museumService.createMuseum(ModelDtoConverter.dtoToModel(newMuseum));
    return ResponseEntity.status(HttpStatus.CREATED).body(savedMuseum);
  }

  /**
   * Endpoint para buscar o museu mais próximo com base em coordenadas e distância máxima.
   *
   * @param lat           Latitude da coordenada inicial.
   * @param lng           Longitude da coordenada inicial.
   * @param maxDist   Distância máxima em quilômetros para a busca do museu mais próximo.
   */
  @GetMapping("/closest")
  public ResponseEntity<MuseumDto> searchClosestMuseums(
      @RequestParam double lat,
      @RequestParam double lng,
      @RequestParam("max_dist_km") double maxDist) {
    Coordinate coordinate = new Coordinate(lat, lng);
    Museum closestMuseum = museumService.getClosestMuseum(coordinate, maxDist);
    return ResponseEntity.ok(ModelDtoConverter.modelToDto(closestMuseum));
  }
}
