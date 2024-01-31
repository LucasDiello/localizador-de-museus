package com.betrybe.museumfinder.dto;

import com.betrybe.museumfinder.model.Coordinate;

/**
 * Objeto de transferência de dados (DTO) representando a criação de um museu.
 * Esta classe é usada para transferir dados entre camadas da aplicação.
 */
public record MuseumCreationDto(
    String name,
    String description,
    String address,
    String collectionType,
    String subject,
    String url,
    Coordinate coordinate
) {

}
