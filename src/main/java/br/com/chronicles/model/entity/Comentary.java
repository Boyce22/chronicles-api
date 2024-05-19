package br.com.chronicles.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "comentary")
@Entity(name = "comentary")
public class Comentary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "com_tx_content")
	private String content;


	@Column(name = "com_dt_createdAt")
	private LocalDateTime createdAt;

	@Column(name = "com_dt_updatedAt")
	private LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "fk_work_cd_id")
	private Work work;

	@OneToOne
	@JoinColumn(name = "fk_reader_cd_id", referencedColumnName = "reader_cd_id")
	private Reader readerId;
}
