package com.pluc.pluc.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pluc.pluc.dto.LinkDTO;
import com.pluc.pluc.entities.Link;
import com.pluc.pluc.repository.LinkRepository;
import com.pluc.pluc.services.exceptions.ResourceEntityNotFoundException;
import com.pluc.pluc.utils.Shortened;

import lombok.AllArgsConstructor;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class LinkService {

    private LinkRepository linkRepository;
    
    @Transactional(readOnly = true)
    public List<LinkDTO> findAll() {
        List<Link> listLink = linkRepository.findAll(); 
        return listLink.stream().map(e-> new LinkDTO(e)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public LinkDTO getById(Long id) {
        try {
            Link entity = linkRepository.getById(id);
            return new LinkDTO(entity);
        }catch(EmptyResultDataAccessException e) {
            throw new ResourceEntityNotFoundException("Id not found: "+ id);
        }
    }

    @Transactional(readOnly = true)
    public LinkDTO insert(LinkDTO dto){
        Link entity = new Link();
        entity.setShortenedLink(Shortened.generate());
        entity.setOriginalLink(dto.getOriginalLink());
        entity.setCreatedAt(Instant.now());
        entity.setUpdatedAt(Instant.now());
        entity.setDeletedAt(false);
        entity = linkRepository.save(entity);
        return new LinkDTO(entity);
    }   
    
    @Transactional(readOnly = true)
    public void delete(Long id) {
        try {
            linkRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceEntityNotFoundException("Id not found: "+ id);
        }
    }

    @Transactional(readOnly = true)
    public LinkDTO findByShortened(String shortened) {
        Optional<Link> obj = linkRepository.findByShortenedLink(shortened);
        Link entity = obj.orElseThrow(()-> new ResourceEntityNotFoundException("Link Not Found: "+shortened));
        return new LinkDTO(entity);
    }
}
