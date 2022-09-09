package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String indexAction(Model model){
        List<Institution> listInstitution = institutionService.findInstitution();
        int sumAllQuantity = donationService.sumAllQuantity();
        int sumAllDonation = donationService.sumAllDonation();

        model.addAttribute("sumQuantity", sumAllQuantity);
        model.addAttribute("sumDonation", sumAllDonation);
        model.addAttribute("listInstitution", listInstitution);

        return "index";
    }
}
