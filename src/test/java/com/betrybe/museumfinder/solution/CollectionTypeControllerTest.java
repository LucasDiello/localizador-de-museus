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
public class CollectionTypeControllerTest {
  @Autowired
  private MockMvc mockMvn;
  @Test
  void testCountByCollectionTypesStatusAndBody() throws Exception {
    mockMvn.perform(get("/collections/count/história"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.collectionTypes[0]").value("história"))
        .andExpect(jsonPath("$.count").value(387));
  }
}