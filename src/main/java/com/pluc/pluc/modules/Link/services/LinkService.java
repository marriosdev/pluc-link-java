package com.pluc.pluc.modules.Link.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.pluc.pluc.components.validators.LinkValidator;
import com.pluc.pluc.exceptions.InvalidOriginalLinkException;
import com.pluc.pluc.exceptions.ResourceEntityNotFoundException;
import com.pluc.pluc.modules.Link.dto.LinkDTO;
import com.pluc.pluc.modules.Link.entities.Link;
import com.pluc.pluc.modules.Link.repository.LinkRepository;
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
        if(!LinkValidator.isValid(dto.getOriginalLink())) {
            throw new InvalidOriginalLinkException("Link inválido");
        }

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
