package pl.coderslab.charity.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class AdminFundationsController {

    private final InstitutionService institutionService;

    public AdminFundationsController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/admin/fundations")
    public String getFundations(Model model){
        List<Institution> institutionList = institutionService.findAll();
        model.addAttribute("institutionList", institutionList);
        return "admin/fundations/admin-fundations";
    }

    @GetMapping("/admin/fundations/add")
    public String newFundation(Model model){
        Institution newInstitution = new Institution();
        model.addAttribute("Institution", newInstitution);
        return "admin/fundations/fundations-add";
    }

    @PostMapping("/admin/fundations/add")
    public String addFundation(Model model, Institution institution){
        institutionService.saveInstitution(institution);
        return "redirect:/admin/fundations";
    }

    @GetMapping("/admin/fundations/delete/{id}")
    public String institutionDelete(@PathVariable Long id) {
        institutionService.deleteById(id);
        return "redirect:/admin/fundations";
    }

    @GetMapping("/admin/fundations/edit/{id}")
    public String institutionGetEdit(@PathVariable Long id, Model model) {
        Institution institution = institutionService.findInstitutionById(id).orElseThrow(RuntimeException::new);
        model.addAttribute("institution", institution);
        return "admin/fundations/fundations-edit";
    }

    @PostMapping("/admin/fundations/edit")
    public String institutionPostEdit(@ModelAttribute Institution institution) {
        institutionService.updateInstitution(institution);
        return "redirect:/admin/fundations";
    }
}
