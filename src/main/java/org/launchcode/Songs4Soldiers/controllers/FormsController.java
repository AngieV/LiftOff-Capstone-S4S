package org.launchcode.Songs4Soldiers.controllers;

import org.launchcode.Songs4Soldiers.data.UserRepository;
import org.launchcode.Songs4Soldiers.models.Veteran;
import org.launchcode.Songs4Soldiers.models.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("S4S")
public class FormsController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/contact")
    public String displayVetAssistForm(Model model) {
        model.addAttribute("title_vet", "Apply for Assistance");
        model.addAttribute(new Veteran());
        List<String> branchList = Arrays.asList("--Please select--", "US Army", "US Navy", "US Air Force", "US Marines", "US Coast Guard");
        model.addAttribute("branchList", branchList);
        return "S4S/contact";
    }

    @PostMapping("/contact")
    public String processVetAssistRequest(@ModelAttribute @Valid Veteran veteran,
                                          Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Contact Us");
            return "S4S/contact";
        }
        userRepository.save(veteran);
        //return "redirect:contact";
        return "S4S/registered";
    }

    @GetMapping("/volunteer")
    public String displayVolunteerForm(Model model) {
        model.addAttribute("title_vol", "Be a Volunteer");
        model.addAttribute(new Volunteer());
        return "S4S/volunteer";
    }

    //create form names or some other way to process form separately
    @PostMapping("/volunteer")
    public String createVolunteer(@ModelAttribute @Valid Volunteer volunteer,
                                  Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Volunteer");
            return "S4S/volunteer";
        }
        userRepository.save(volunteer);
        //return "S4S/volunteer";
        return "S4S/registered";
    }
}
