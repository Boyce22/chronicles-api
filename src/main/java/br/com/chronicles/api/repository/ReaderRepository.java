package br.com.chronicles.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.api.entity.Reader;

public interface ReaderRepository extends JpaRepository<Reader, Long> {

}
