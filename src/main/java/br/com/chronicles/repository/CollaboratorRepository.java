package br.com.chronicles.repository;

import br.com.chronicles.model.entity.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    @Query(value = "SELECT col FROM collaborator col WHERE col.isActive = true")
    List<Collaborator> findAllActive();

    @Query(value = "SELECT col FROM collaborator col WHERE col.reference LIKE %:reference%")
    List<Collaborator> findByReference(@Param("reference") String reference);

}
