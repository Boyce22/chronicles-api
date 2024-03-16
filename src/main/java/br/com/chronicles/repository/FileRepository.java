package br.com.chronicles.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.chronicles.model.entity.FileWork;

@Repository
public interface FileRepository extends JpaRepository<FileWork, Long> {

}
