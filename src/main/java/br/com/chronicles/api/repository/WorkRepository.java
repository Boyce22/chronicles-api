package br.com.chronicles.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.chronicles.api.entity.Work;

public interface WorkRepository extends JpaRepository<Work, Long>{

}
