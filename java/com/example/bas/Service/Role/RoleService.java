package com.example.bas.Service.Role;

import com.example.bas.Service.Model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleService {

    List<Role> getAllRoles();
    void createRole(Role role);
    void updateRole(Role role);
    void deleteRole(int userRoleId);
    Optional<Role> findUserRoleById(int userRoleId);
}
