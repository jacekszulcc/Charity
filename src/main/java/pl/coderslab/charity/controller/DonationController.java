package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.dto.DonationDto;
import pl.coderslab.charity.entity.Category;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    private final DonationRepository donationRepository;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationRepository donationRepository) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationRepository = donationRepository;
    }

    @GetMapping("/form")
    public String getForm(Model model){
        List<Category> categoryList = categoryService.findAll();
        List<Institution> institutionList = institutionService.findAll();
        DonationDto donationDto = new DonationDto();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("institutionList", institutionList);
        model.addAttribute("DonationDto", donationDto);
        return "form";
    }

    @PostMapping("/update")
    public String getUpdate(Model model, DonationDto donationDto){
        List<Category> categoryList = categoryService.findAll();
        List<Institution> institutionList = institutionService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("institutionList", institutionList);
        model.addAttribute("DonationDto", donationDto);
        return "form";
    }

    @PostMapping("/form-confirm")
    public String postFormConfirm(Model model, DonationDto donationDto){
        model.addAttribute("DonationDto", donationDto);
        return "form-confirm";
    }

    @PostMapping("/confirm")
    public String confirm(Model model, DonationDto donationDto){
        Donation donation = new Donation(donationDto.getQuantity(), donationDto.getCategoryList(), donationDto.getInstitution(),
                donationDto.getStreet(), donationDto.getCity(), donationDto.getZipCode(), donationDto.getPhone(), donationDto.getPickUpDate(), donationDto.getPickUpTime(), donationDto.getPickUpComment());
        donationRepository.save(donation);
        return "confirm";
    }

}
