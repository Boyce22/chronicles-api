package br.com.chronicles.api.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.chronicles.api.dto.AuthorRegisterDTO;
import br.com.chronicles.api.dto.AuthorUpdateDTO;
import br.com.chronicles.api.dto.ReaderChangeRequestDTO;
import br.com.chronicles.api.security.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	
	@Column(name = "author_tx_email")
	private String email;

	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	@Column(name = "author_dt_birth_data")
	private LocalDate birthDate;

	@Column(name = "author_dt_create_data")
	private LocalDate createdDate;

	@Column(name = "author_dt_update_data")
	private LocalDateTime updatedDate;

	@Column(name = "author_dt_disable_date")
	private LocalDateTime disableDate;

	@Column(name = "author_bl_is_active")
	private Boolean isActive;
	
	@OneToMany(mappedBy = "author")
	private List<Work> work;

	@OneToOne
	@JoinColumn(name = "author_user_cd_id", referencedColumnName = "user_cd_id")
	private User user;
	
	@PrePersist
	void prePersist() {
		this.isActive = true;
	}

	public Author registrar(AuthorRegisterDTO dto) {
		this.name = dto.name();
		this.lastName = dto.lastName();
		this.cpf = dto.cpf();
		this.birthDate = dto.birthDate();
		this.createdDate = LocalDate.now();
		return this;
	}

	public Author update(AuthorUpdateDTO dto) {
		this.name = dto.name();
		this.lastName = dto.lastName();
		this.cpf = dto.cpf();
		this.birthDate = dto.birthDate();
		this.updatedDate = LocalDateTime.now();
		return this;
	}

	public Author disable() {
		this.isActive = false;
		this.disableDate = LocalDateTime.now();
		return this;
	}

	public Author active() {
		this.isActive = true;
		this.updatedDate = LocalDateTime.now();
		this.disableDate = null;
		return this;
	}

	public Author grantAuthorAccessToReader(Reader reader, ReaderChangeRequestDTO dto) {
		this.name = reader.getName();
		this.lastName = reader.getLastName();
		this.birthDate = reader.getBirthDate();
		this.createdDate = reader.getCreatedDate();
		this.cpf = dto.cpf();
		return this;
	}

}
