package project.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import project.domain.User;
import project.dto.UserDto;
import project.service.UserService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/home")
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        webDataBinder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException
            {
                LocalDate localDate = LocalDate.parse(text, dateFormatter);
                setValue(localDate);
            }
        });
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "home/login";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("user", new User());
        return "home/about";
    }

    @RequestMapping("/create_dto")
    public String createDto(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "home/create-dto";
    }

    @RequestMapping("/store_dto")
    public String store(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/create-project.dto";
        }
        userService.create(userDto);
        return "redirect:/home/login";
    }
}
