package br.com.chronicles.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.chronicles.model.request.WorkCreateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
@Entity(name = "work")
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

	@Column(name = "work_dt_releasedAt")
	private LocalDateTime releasedAt;

	@Column(name = "work_nm_rating")
	private Double rating;

	@Column(name = "work_dt_createdAt")
	private LocalDate createdAt;

	@Column(name = "work_dt_updatedAt")
	private LocalDateTime updatedAt;

	@Column(name = "work_bl_is_active")
	private Boolean isActive;

	@Column(name = "work_bl_is_mature_content")
	private Boolean isMature;

	@OneToMany(mappedBy = "work")
	private List<Comentary> comments;

	@OneToOne
	@JoinColumn(name = "fk_file_cd_id", referencedColumnName = "file_cd_id")
	private FileWork file;

	@ManyToOne
	@JoinColumn(name = "fk_author_cd_id", referencedColumnName = "author_cd_id")
	private Author author;

	@PrePersist
	void prePersist() {
		this.isActive = true;
		this.releasedAt = LocalDateTime.now();
		this.updatedAt = LocalDateTime.now();
		this.createdAt = LocalDate.now();
	}

	public static Work create() {
		return new Work();
	}

	public Work register(WorkCreateDTO dto, Author author, FileWork file, boolean isMature) {
		this.title = dto.title();
		this.genre = dto.genre();
		this.description = dto.description();
		this.author = author;
		this.isMature = isMature;
		this.file = file;
		return this;
	}

	public Work rating(Double rating) {
		this.rating = rating + rating;
		return this;
	}

}
