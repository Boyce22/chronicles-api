package br.com.chronicles.api.security.service;

import org.springframework.stereotype.Service;

import br.com.chronicles.api.security.entity.Role;
import br.com.chronicles.api.security.interfaces.IRoleService;
import br.com.chronicles.api.security.repository.RoleRepository;

@Service
public class RoleService implements IRoleService {
	
	private RoleRepository roleRepository;
	
	public RoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Override
	public String register(Role role) {
	    roleRepository.save(role);
	    return String.format("Role cadastrada %s", role.getName());
	}

}
