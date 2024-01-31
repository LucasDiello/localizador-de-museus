package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Objeto de transferência de dados (DTO) representando informações sobre um museu.
 * Esta classe é usada para transferir dados entre camadas da aplicação.
 */

public record MuseumDto(
    Long id,
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {

}
