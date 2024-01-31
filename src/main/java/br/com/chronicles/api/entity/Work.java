package br.com.chronicles.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.chronicles.api.dto.WorkCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_cd_id")
	private Long id;

	@Column(name = "work_tx_title")
	private String title;

	@Column(name = "work_tx_genre")
	private String[] genre;

	@Column(name = "work_tx_description")
	private String description;

	@Column(name = "work_nm_chapters")
	private Integer numberChapters;

	@Column(name = "work_dt_release_date")
	private LocalDate releaseDate;

	@Column(name = "work_dt_create_date")
	private LocalDate createdDate;

	@Column(name = "work_dt_update_date")
	private LocalDateTime updatedDate;

	@Column(name = "work_bl_is_active")
	private Boolean isActive;

	@ManyToOne
	@JoinColumn(name = "fk_author_cd_id", referencedColumnName  = "author_cd_id")
	private Author author;

	@PrePersist
	void prePersist() {
		this.isActive = true;
		this.createdDate = LocalDate.now();
		this.releaseDate = LocalDate.now();
	}

	public Work create(WorkCreateDTO dto, Author newAuthor) {
		this.title = dto.title();
		this.genre = dto.genre();
		this.description = dto.description();
		this.numberChapters = dto.numberChapters();
		this.author = newAuthor;
		return this;
	}

}
