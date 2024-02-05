package com.betrybe.museumfinder.solution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class MuseumControllerTest {

  @Autowired
  private MockMvc mockMvn;

  @Test
  public void getMuseumTest() throws Exception {
    mockMvn.perform(get("/museums/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Museu Casa Memória dos Ex-Combatentes da Segunda Guerra Mundial"))
        .andExpect(jsonPath("$.description").value("Preservação da memória dos ex-combatentes da Segunda Guerra."))
        .andExpect(jsonPath("$.address").value("SGAN 913, s/n, conjunto F , Asa Norte, 70790-130, Brasília, DF"))
        .andExpect(jsonPath("$.collectionType").value("História"))
        .andExpect(jsonPath("$.subject").value("História"))
        .andExpect(jsonPath("$.url").isEmpty())
        .andExpect(jsonPath("$.coordinate.latitude").value(-15.75063))
        .andExpect(jsonPath("$.coordinate.longitude").value(-47.9001824))
        .andExpect(jsonPath("$.legacyId").value(1000));
  }
}
