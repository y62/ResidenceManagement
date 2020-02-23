package com.example.bas.Controller;

import com.example.bas.Service.Model.Consumption;
import com.example.bas.Service.Consumption.ConsumptionServiceImpl;
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
public class ConsumptionController {

    @Autowired
    ConsumptionServiceImpl consumptionService;

    @GetMapping("/consumption")
    public String consumption(Model model) {
        List<Consumption> consumptions = consumptionService.getAllConsumptions();
        model.addAttribute("consumptions", consumptions);
        return "consumption";
    }

    @GetMapping("/consumptionCreate")
    public String createConsumption(Model model) {
        model.addAttribute("consumption", new Consumption());
        return "consumptionCreate";
    }

    @PostMapping("/consumptionCreate")
    public String createConsumption(@ModelAttribute Consumption consumption) {
        consumptionService.create(consumption);
        return "redirect:/consumption";
    }

    @GetMapping("/consumptionUpdate/{consumptionId}")
    public String updateConsumption(@PathVariable Integer consumptionId, Model model) {
        model.addAttribute("consumption", consumptionService.findConsumptionById(consumptionId).get());
        return "consumptionUpdate";
    }

    @PostMapping("/consumptionUpdate")
    public String updateConsumption(@ModelAttribute Consumption consumption) {
        consumptionService.update(consumption);
        return "redirect:/consumption";
    }

    @GetMapping("/consumptionDelete/{consumptionId}")
    public String deleteConsumption(@PathVariable("consumptionId") int consumptionId, Model model) {
        Optional<Consumption> consumption = consumptionService.findConsumptionById(consumptionId);
        model.addAttribute("consumption", consumption.get());
        return "consumptionDelete";
    }

    @PostMapping("/consumptionDelete")
    public String deleteUser(@ModelAttribute Consumption consumption) {
        consumptionService.delete(consumption.getConsumptionId());
        return "redirect:/consumption";
    }
}
