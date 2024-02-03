package br.com.chronicles.api.security.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.security.entity.User;
import br.com.chronicles.api.security.interfaces.IUserService;
import br.com.chronicles.api.security.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UserAuthService implements IUserService {
	
	private final UserRepository userRepository;
	
	public UserAuthService(UserRepository userRepository,PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
	}
	
	public User createUserWithReader(ReaderRegisterDTO dto) {
		return userRepository.save(new User().createUserWithReader(dto));
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(
				() -> new EntityNotFoundException("Não foi possível encontrar o usuário com o email: " + email));
	}

}
