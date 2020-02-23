package com.example.bas.Repository.Role;

import com.example.bas.Service.Model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleRepository {

    List<Role> getAllRoles();
    int createRole(Role role);
    int updateRole(Role role);
    int deleteRole(int userRoleId);
    Optional<Role> findUserRoleById(int userRoleId);
}
