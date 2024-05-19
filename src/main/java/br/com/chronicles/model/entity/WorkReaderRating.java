package br.com.chronicles.model.entity;

import br.com.chronicles.model.request.WorkRatingDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_reader_rating")
@Entity(name = "work_reader_rating")
public class WorkReaderRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "work_reader_rating_id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
	private Reader reader;

	@ManyToOne
	@JoinColumn(name = "fk_work_cd_id", referencedColumnName = "work_cd_id")
	private Work work;

	@Column(name = "work_rating")
	private Double rating;

	private static WorkReaderRating create() {
		return new WorkReaderRating();
	}

	public static WorkReaderRating create(WorkRatingDTO dto, Reader reader, Work work) {
		WorkReaderRating workReaderRating = create();
		workReaderRating.rating = dto.rating();
		workReaderRating.reader = reader;
		workReaderRating.work = work;
		return workReaderRating;
	}

	public WorkReaderRating update(WorkRatingDTO dto, Reader reader, Work work) {
		this.rating = dto.rating();
		this.reader = reader;
		this.work = work;
		return this;
	}

}
