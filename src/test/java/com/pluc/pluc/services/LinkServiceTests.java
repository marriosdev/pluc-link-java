package com.pluc.pluc.services;

import java.time.Instant;

import javax.transaction.Transactional;

import org.apache.logging.log4j.message.ReusableMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.pluc.pluc.dto.LinkDTO;
import com.pluc.pluc.entities.Link;
import com.pluc.pluc.services.LinkService;

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
        
    }
}
