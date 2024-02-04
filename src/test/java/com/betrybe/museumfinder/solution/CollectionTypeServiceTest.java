package com.betrybe.museumfinder.solution;

import com.betrybe.museumfinder.database.MuseumFakeDatabase;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class CollectionTypeServiceTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  RestTemplate restTemplate;
  @MockBean
  private CollectionTypeService collectionTypeService;

  @Test
  public void testcountByCollectionTypes (){

  }
}
