package com.example.bas.Controller;

import com.example.bas.Service.Model.Role;
import com.example.bas.Service.Role.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import java.util.Optional;
/**
 * Vi annotere klassen som Controller.
 * Autowirer pga. dependency injection.
 * Mapper HTTP requests til metoder.
 */
@Controller
public class RoleController {

    @Autowired
    RoleServiceImpl roleService;

    @GetMapping("/role")
    public String role(Model model) {
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("roles", roles);
        return "role";
    }

    @GetMapping("/roleCreate")
    public String createRole(Model model) {
        model.addAttribute("role", new Role());
        return "roleCreate";
    }

    @PostMapping("/roleCreate")
    public String createRole(@ModelAttribute Role role) {
        roleService.createRole(role);
        return "redirect:/role";
    }

    @GetMapping("/roleUpdate/{userRoleId}")
    public String updateRole(@PathVariable Integer userRoleId, Model model) {
        model.addAttribute("role", roleService.findUserRoleById(userRoleId).get());
        return "roleUpdate";
    }

    @PostMapping("/roleUpdate")
    public String updateRole(@ModelAttribute Role role) {
        roleService.updateRole(role);
        return "redirect:/role";
    }

    @GetMapping("/roleDelete/{userRoleId}")
    public String deleteUser(@PathVariable("userRoleId") int userRoleId, Model model) {
        Optional<Role> role = roleService.findUserRoleById(userRoleId);
        model.addAttribute("role", role.get());
        return "roleDelete";
    }

    @PostMapping("/roleDelete")
    public String deleteRole(@ModelAttribute Role role) {
        roleService.deleteRole(role.getUserRoleId());
        return "redirect:/role";
    }
}
