package br.com.chronicles.model.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recommendation_manga")
@Entity(name = "recommendation_manga")
public class RecommendationManga {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Set<String> genresManga;

	@OneToOne
	@JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
	private Reader reader;

}
