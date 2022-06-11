package com.pluc.pluc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pluc.pluc.services.LinkService;

import java.net.URI;
import java.util.List;

import com.pluc.pluc.dto.LinkDTO;
import com.pluc.pluc.entities.Link;

@RestController
@RequestMapping(value="/link")
public class LinkResource {

    @Autowired
    LinkService linkService;

    @GetMapping
    public ResponseEntity<List<LinkDTO>> findAll() {
        List<LinkDTO> list = linkService.findAll();
        return ResponseEntity.ok().body(list);   
    }

    @GetMapping("/{id}")
    public ResponseEntity<LinkDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(linkService.getById(id));
    }
    
    @PostMapping
    public ResponseEntity<LinkDTO> insert(@RequestBody LinkDTO dto) {
        dto = linkService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}")
                    .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<LinkDTO> delete(@PathVariable Long id) {
        linkService.delete(id);
        return ResponseEntity.noContent().build();
    }   
}
