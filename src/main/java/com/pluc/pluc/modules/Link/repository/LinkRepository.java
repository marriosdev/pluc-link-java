package com.pluc.pluc.modules.Link.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pluc.pluc.modules.Link.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {

    public Optional<Link> findByShortenedLink(String shortened_link);
}
