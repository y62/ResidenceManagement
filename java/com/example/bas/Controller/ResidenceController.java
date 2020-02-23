package com.example.bas.Controller;

import com.example.bas.Service.Model.Residence;
import com.example.bas.Service.Residence.ResidenceServiceImpl;
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
public class ResidenceController {
    @Autowired
    ResidenceServiceImpl residenceService;

    @GetMapping("/residence")
    public String residence(Model model) {
        List<Residence> residences = residenceService.getAllResidences();
        model.addAttribute("residences", residences);
        return "residence";
    }

    @GetMapping("/residenceCreate")
    public String createResidence(Model model) {
        model.addAttribute("residence", new Residence());
        return "residenceCreate";
    }

    @PostMapping("/residenceCreate")
    public String createResidence(@ModelAttribute Residence residence) {
        residenceService.createResidence(residence);
        return "redirect:/residence";
    }

    @GetMapping("/residenceUpdate/{residenceId}")
    public String updateResidence(@PathVariable Integer residenceId, Model model) {
        model.addAttribute("residence", residenceService.findResidenceById(residenceId).get());
        return "residenceUpdate";
    }

    @PostMapping("/residenceUpdate")
    public String updateResidence(@ModelAttribute Residence residence) {
        residenceService.updateResidence(residence);
        return "redirect:/residence";
    }

    @GetMapping("/residenceDelete/{residenceId}")
    public String deleteResidence(@PathVariable("residenceId") int residenceId, Model model) {
        Optional<Residence> residence = residenceService.findResidenceById(residenceId);
        model.addAttribute("residence", residence.get());
        return "residenceDelete";
    }

    @PostMapping("/residenceDelete")
    public String deleteResidence(@ModelAttribute Residence residence) {
        residenceService.deleteResidence(residence.getResidenceId());
        return "redirect:/residence";
    }
}
