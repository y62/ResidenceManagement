package com.example.bas.Repository.Role;

import com.example.bas.Service.Model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository("RoleRepositoryImpl")
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createRole(Role role) {
        return jdbcTemplate.update(
                "insert into user_roles (user_role_id, username, role) values(?,?,?)",
                role.getUserRoleId(), role.getUsername(), role.getRole());
    }

    @Override
    public List<Role> getAllRoles() {
        return jdbcTemplate.query(
                "select * from basdb.user_roles",
                (resultSet, rowNum) ->
                        new Role(
                                resultSet.getInt("user_role_id"),
                                resultSet.getString("username"),
                                resultSet.getString("role")
                        )
        );
    }

    @Override
    public int updateRole(Role role) {
        return jdbcTemplate.update(
                "update user_roles set username = ?, role = ? where user_role_id = ?",
              role.getUsername(), role.getRole(), role.getUserRoleId());
    }

    @Override
    public int deleteRole(int userRoleId) {
        return jdbcTemplate.update(
                "delete FROM user_roles where user_role_id = ?",
                userRoleId);
    }

    @Override
    public Optional<Role> findUserRoleById(int userRoleId) {
        return jdbcTemplate.queryForObject(
                "select * from user_roles where user_role_id = ?",
                new Object[]{userRoleId},
                (resultSet, rowNum) ->
                        Optional.of(new Role(
                                resultSet.getInt("user_role_id"),
                                resultSet.getString("username"),
                                resultSet.getString("role")
                        ))
        );
    }


}
