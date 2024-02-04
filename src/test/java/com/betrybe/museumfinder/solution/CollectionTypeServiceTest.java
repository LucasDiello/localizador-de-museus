package com.betrybe.museumfinder.solution;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.betrybe.museumfinder.dto.CollectionTypeCount;
import com.betrybe.museumfinder.service.CollectionTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CollectionTypeServiceTest {

  @Autowired
  private CollectionTypeService collectionTypeService;

  @Test
  void testCountByCollectionTypes() {
    CollectionTypeCount result = collectionTypeService.countByCollectionTypes("história");


    assertEquals(387, result.count());
    assertArrayEquals(new String[]{"história"}, result.collectionTypes());
  }
}