package br.com.chronicles.api.security.interfaces;

import br.com.chronicles.api.dto.ReaderRegisterDTO;
import br.com.chronicles.api.security.entity.User;

public interface IUserService {

	User createUserWithReader(ReaderRegisterDTO dto);
}
