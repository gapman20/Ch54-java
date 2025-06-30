package com.monkys.tower.app.service.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.monkys.tower.app.model.Role;
import com.monkys.tower.app.repository.RoleRepository;
import com.monkys.tower.app.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
		
	private final RoleRepository roleRepository; 
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public Iterable<Role> findAll() {
		return roleRepository.findAll();
	}

	
	@Override
	public Role findById(Long id) {
		/*
		 * La clase Optional es un contenedor introducido en Java 8 que puede contener
		 * un valor no nulo o estar vacío. Se utiliza para evitar errores relacionados
		 * con valores nulos, como NullPointerException, y para expresar claramente
		 * que un valor puede estar presente o no.
		 */
		Optional<Role> roleOpt = roleRepository.findById(id);
		if( roleOpt.isEmpty() ) { // no hay objeto, la variable contiene null
			throw new IllegalStateException("Role does not exist with id " + id);
		}
		Role existingRole = roleOpt.get();
		return existingRole;
	}

	@Override
	public Role save(Role role) {
		role.setId(null); // forzando a la creación del registro
		Role newRole = roleRepository.save(role);
		return newRole;
	}

	@Override
	public Role update(Long id, Role role) {
		Role existingRole = findById(id);
		// Solo se modifica los atributos permitidos
		existingRole.setName( role.getName() );
		existingRole.setDescription( role.getDescription() );
		// existingRole.setId( role.getId() ); NO se permite modificar
		Role updatedRole = roleRepository.save( existingRole );
		return updatedRole;
	}

	@Override
	public void deleteById(Long id) {
		Role existingRole = findById(id);
		// existingRole.active(false); // Borrado lógico
		// roleRepository.save( existingRole );
		roleRepository.delete(existingRole);		
	}

	@Override
	public Set<String> getUsersWithSpecificRoleId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
