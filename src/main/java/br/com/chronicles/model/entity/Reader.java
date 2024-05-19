package br.com.chronicles.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import br.com.chronicles.model.request.ReaderRegisterDTO;
import br.com.chronicles.model.request.ReaderUpdateDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "reader")
@Table(name = "reader")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reader_cd_id")
	private Long id;

	@Column(name = "reader_tx_name")
	private String name;

	@Column(name = "reader_tx_lastName")
	private String lastName;

	@Column(name = "reader_tx_email")
	private String email;

	@Column(name = "reader_dt_birth_date")
	private LocalDate birthDate;

	@Column(name = "reader_dt_createAt")
	private LocalDate createdAt;

	@Column(name = "reader_dt_updateAt")
	private LocalDateTime updatedAt;

	@Column(name = "reader_dt_disabledAt")
	private LocalDateTime disabledAt;

	@Column(name = "reader_dt_deletedAt")
	private LocalDateTime deletedAt;

	@Column(name = "reader_bl_is_active", columnDefinition = "boolean default true")
	private Boolean isActive;

	@PrePersist
	void prePersist() {
		this.isActive = true;
	}

	private static Reader create() {
		return new Reader();
	}

	public static Reader registrar(ReaderRegisterDTO dto) {
		Reader reader = create();
		reader.name = dto.name();
		reader.lastName = dto.lastName();
		reader.birthDate = dto.birthDate();
		reader.createdAt = LocalDate.now();
		return reader;
	}

	public Reader atualizar(ReaderUpdateDTO dto) {
		this.name = dto.name();
		this.lastName = dto.lastName();
		this.birthDate = dto.birthDate();
		return this;
	}

	public Reader disable() {
		this.disabledAt = LocalDateTime.now();
		this.isActive = false;
		return this;
	}

	public Reader active() {
		this.isActive = true;
		this.updatedAt = LocalDateTime.now();
		this.disabledAt = null;
		return this;
	}

}
