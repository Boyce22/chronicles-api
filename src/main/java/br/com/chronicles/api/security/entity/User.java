package br.com.chronicles.api.security.entity;

import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.security.enuns.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity(name = "users")
public class User {
	
    @Id
    @Column(name = "user_cd_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "user_tx_email", nullable = false)
    private String email;

    @Column(name = "user_tx_password", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

	public User createUserWithReader(ReaderRegisterDTO dto) {
		this.email = dto.email();
		this.password = dto.password();
		this.userRole = UserRole.LEITOR;
		return this;
	}


}
