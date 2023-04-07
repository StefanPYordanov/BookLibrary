package com.example.Library.web;

import com.example.Library.model.dto.RegistrationDto;
import com.example.Library.service.RegisterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class RegisterController {

    private final RegisterService registerService;

    @Autowired
    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @ModelAttribute("registrationDTO")
    public RegistrationDto initForm() {
        return new RegistrationDto();
    }

    @PostMapping("/register")
    public String doRegister(@Valid RegistrationDto registrationDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        System.out.println(registrationDto.toString());

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationDto", registrationDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDto", bindingResult);

            return "redirect:/register";
        }

        this.registerService.register(registrationDto);

        return "redirect:/login";
    }


}
