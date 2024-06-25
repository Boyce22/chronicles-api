package br.com.chronicles.repository;

import br.com.chronicles.model.entity.Work;
import br.com.chronicles.model.response.WorkNonWithChapters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkRepository extends JpaRepository<Work, Long> {
    @Query(value = """
                   SELECT
                       wk.id as id,
                       wk.title as title,
                       wk.description as description,
                       wk.releasedAt as releasedAt,
                       wk.rating as rating,
                       wk.createdAt as createdAt,
                       wk.updatedAt as updatedAt,
                       wk.isActive as isActive,
                       wk.isMature as isMature,
                       wk.collaborator.name as collaborator
                   FROM
                       work wk
                   LEFT JOIN
                       collaborator col ON wk.collaborator.id = col.id
                   WHERE
                        wk.isActive = true
            """)
    List<WorkNonWithChapters> findAllWithFiles();


}
