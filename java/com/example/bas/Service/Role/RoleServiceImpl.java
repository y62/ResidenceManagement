package com.example.bas.Service.Role;

import com.example.bas.Service.Model.Role;
import com.example.bas.Repository.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired

    @Qualifier("RoleRepositoryImpl")
    RoleRepository RoleRepository;

    @Override
    public List<Role> getAllRoles() {
        return RoleRepository.getAllRoles();
    }

    @Override
    public void createRole(Role role) {
        RoleRepository.createRole(role);
    }

    @Override
    public void updateRole(Role role) {
        RoleRepository.updateRole(role);
    }

    @Override
    public void deleteRole(int userRoleId) {
        RoleRepository.deleteRole(userRoleId);
    }

    @Override
    public Optional<Role> findUserRoleById(int userRoleId) {
        return RoleRepository.findUserRoleById(userRoleId);
    }
}
