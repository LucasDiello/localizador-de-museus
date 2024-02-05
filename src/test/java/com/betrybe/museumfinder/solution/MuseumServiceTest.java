package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.model.Coordinate;
import com.betrybe.museumfinder.model.Museum;
import com.betrybe.museumfinder.service.MuseumService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MuseumServiceTest {

  @Autowired
  private MuseumService museumService;

  @Test
  public void getMuseumTest() {
    Museum result = museumService.getMuseum(1L);
    assertThat(result).isNotNull();
    assertThat(result.getId()).isEqualTo(1L);
    assertThat(result.getName()).isEqualTo("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial");
    assertThat(result.getDescription()).isEqualTo("Preservação da memória dos ex-combatentes da Segunda Guerra.");
    assertThat(result.getAddress()).isEqualTo("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF");
    assertThat(result.getCollectionType()).isEqualTo("História");
    assertThat(result.getSubject()).isEqualTo("História");
    assertThat(result.getUrl()).isEqualTo("");
    assertThat(result.getCoordinate())
        .isEqualTo(new Coordinate(-15.75063, -47.9001824));
    assertThat(result.getLegacyId()).isEqualTo(1000);
  }

}
