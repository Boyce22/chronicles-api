package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.model.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long>{

}
