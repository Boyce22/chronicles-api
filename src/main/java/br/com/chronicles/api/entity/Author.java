package br.com.chronicles.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.chronicles.api.security.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "author")
@Entity(name = "author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_cd_id")
	private Long id;

	@Column(name = "author_tx_name")
	private String name;

	@Column(name = "author_tx_lastName")
	private String lastName;
	
	@Column(name = "author_tx_cpf")
	private String cpf;

	@Column(name = "author_dt_birth_data")
	private LocalDate birthDate;

	@Column(name = "author_dt_create_data")
	private LocalDate createdDate;

	@Column(name = "author_dt_update_data")
	private LocalDateTime updatedDate;
	
	@Column(name = "author_dt_delete_date")
	private LocalDateTime deleteDate;

	@Column(name = "author_bl_is_active", columnDefinition = "boolean default true")
	private Boolean isActive;
	
	@PrePersist
	void prePersist(){
		this.createdDate = LocalDate.now();
	}

	@OneToOne
	@JoinColumn(name = "author_user_cd_id", referencedColumnName = "user_cd_id")
	private User user;

}
