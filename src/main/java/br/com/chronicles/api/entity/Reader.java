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
@Entity(name = "reader")
@Table(name = "reader")
public class Reader {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "reader_tx_name")
	private String name;

	@Column(name = "reader_tx_lastName")
	private String lastName;

	@Column(name = "reader_dt_birth_date")
	private LocalDate birthDate;

	@Column(name = "reader_dt_create_date")
	private LocalDate createdDate;

	@Column(name = "reader_dt_update_date")
	private LocalDateTime updatedDate;

	@Column(name = "reader_dt_delete_date")
	private LocalDateTime deleteDate;

	@Column(name = "reader_bl_is_active", columnDefinition = "boolean default true")
	private Boolean isActive;

	@PrePersist
	void prePersist() {
		this.createdDate = LocalDate.now();
	}

	@OneToOne
	@JoinColumn(name = "reader_user_cd_id", referencedColumnName = "user_cd_id")
	private User user;
}
