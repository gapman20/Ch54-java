package com.monkys.tower.app.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.monkys.tower.app.model.Role;
import com.monkys.tower.app.repository.RoleRepository;
import com.monkys.tower.app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
		
	RoleRepository roleRepository; 
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role save(Role role) {
		role.setId(null); // forzando a la creación del registro
		Role newRole = roleRepository.save(role);
		return newRole;
	}

	@Override
	public Role update(Long id, Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<String> getUsersWithSpecificRoleId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
