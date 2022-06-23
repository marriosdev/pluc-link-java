package com.pluc.pluc.services;

import java.time.Instant;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pluc.pluc.dto.LinkDTO;
import com.pluc.pluc.entities.Link;
import com.pluc.pluc.services.exceptions.ResourceEntityNotFoundException;

@SpringBootTest
@Transactional
public class LinkServiceTests {
    
    @Autowired
    private LinkService service;

    @Test
    public void insertShouldReturnsDto() {
        Link entity = new Link(1L, "asdfgh", "google.com", Instant.now(), Instant.now(), false);
        LinkDTO dto = new LinkDTO(entity);
        LinkDTO result = service.insert(dto);
        Assertions.assertInstanceOf(LinkDTO.class, result);
    } 

    @Test
    public void deleteShouldTrowsExceptionWhenIdDoesNotExists() {
        Long invalidId = 1000L;
        Assertions.assertThrows(ResourceEntityNotFoundException.class, ()->{
            service.delete(invalidId);
        });
    }

    @Test
    public void findByShortenedShouldReturnsResourceEntityNotFoundExceptionWhenDoesNotShortenedExists() {
        String shortenedInvalid = "aaaaa";
        Assertions.assertThrows(ResourceEntityNotFoundException.class, ()->{
            service.findByShortened(shortenedInvalid);
        });
    }
    
    @Test
    public void getByIdShouldReturnDtoWhenIdExists() {
        Long idExists = 1L;
        Assertions.assertInstanceOf(LinkDTO.class, service.getById(idExists));
    }
}
