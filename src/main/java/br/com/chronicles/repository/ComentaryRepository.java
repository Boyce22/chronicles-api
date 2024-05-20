package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.Comentary;

@Repository
public interface ComentaryRepository extends JpaRepository<Comentary, Long> {

}
