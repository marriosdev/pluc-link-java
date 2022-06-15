package com.pluc.pluc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluc.pluc.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    public Link findByShortenedLink(String shortened_link); 
}
