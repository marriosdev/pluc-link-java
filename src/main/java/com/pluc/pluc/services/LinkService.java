package com.pluc.pluc.services;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.pluc.pluc.dto.LinkDTO;
import com.pluc.pluc.entities.Link;
import com.pluc.pluc.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LinkService {

    @Autowired
    LinkRepository linkRepository;

    @Transactional(readOnly = true)
    public List<LinkDTO> findAll() {
        List<Link> listLink = linkRepository.findAll(); 
        return listLink.stream().map(e-> new LinkDTO(e)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LinkDTO getById(Long id) {
        return new LinkDTO(linkRepository.getById(id));
    }

    @Transactional(readOnly = true)
    public LinkDTO insert(LinkDTO dto){
        Link entity = new Link();
        copyDtoToEntity(dto, entity);
        entity = linkRepository.save(entity);
        return new LinkDTO(entity);
    }   

    private void copyDtoToEntity(LinkDTO dto, Link entity) {
        entity.setShortened_link(entity.generate_shortened());
        entity.setOriginal_link(dto.getOriginal_link());
        entity.setCreated_at(Instant.now());
        entity.setUpdated_at(Instant.now());
    }
}
