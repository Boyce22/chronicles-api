package br.com.chronicles.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.api.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
