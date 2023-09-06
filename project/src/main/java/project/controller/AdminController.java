package project.controller;

import org.hibernate.Session;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.domain.ChangePass;
import project.domain.User;
import project.dto.EmployeeDto;
import project.dto.UserDto;
import project.service.AdminService;
import project.service.CustomerService;
import project.service.EmployeeService;
import project.service.UserService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin")


public class AdminController {

    private UserService userService;
    private AdminService adminService;
    private CustomerService customerService;
    private EmployeeService employeeService;

    public AdminController(UserService userService,AdminService adminService,CustomerService customerService,EmployeeService employeeService) {

        this.adminService=adminService;
        this.userService = userService;
        this.customerService=customerService;
        this.employeeService=employeeService;
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

    @RequestMapping("/adminDashboard")
    public String dashBoard(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("loggedInUser", loggedInUser);
        return "admin/adminDashboard";
    }
    @RequestMapping("/edit")
    public String edit(Model model) throws SQLException {
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = loggedInUser;
        model.addAttribute("user", userService.get2(username));
        return "admin/edit";
    }
    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) throws SQLException {

        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        userService.update(user);
        return "redirect:/admin/adminDashboard";
    }

    @RequestMapping("/changePassword")
    public String edit2( Model model) throws SQLException {
        //System.out.println("Received username parameter: " + username);
        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = loggedInUser;
        model.addAttribute("user", userService.get(username));
        return "admin/changePassword";
    }



    @RequestMapping("/updatePassword")
    public String updatePassword(@Valid @ModelAttribute("user")User user, BindingResult bindingResult) throws SQLException {

        userService.updatePassword(user);
        return "redirect:/admin/adminDashboard";
    }


    @RequestMapping("/employee-dto")
    public String createDto(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "admin/employee-dto";
    }

    @RequestMapping("/storeEmp_dto")
    public String store(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/employee-dto";
        }
        userService.createEmp(employeeDto);
        return "redirect:/admin/adminDashboard";
    }

    @RequestMapping({"/list"})
    public String list(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("users", this.userService.list());
        //model.addAttribute("loggedInUser", loggedInUser);
        return "admin/list";
    }

    @RequestMapping({"/edit2"})
    public String edit(@RequestParam("userId") Long userId, Model model) throws SQLException {
        model.addAttribute("user", this.userService.get(userId));
        return "admin/edit2";
    }

    @RequestMapping({"/customerList"})
    public String customerList(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("customer", this.customerService.list());
        //model.addAttribute("loggedInUser", loggedInUser);
        return "admin/customerList";
    }

    @RequestMapping({"/employeeList"})
    public String employeeList(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("employee", this.employeeService.list());
        //model.addAttribute("loggedInUser", loggedInUser);
        return "admin/employeeList";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") Long userId) {
        userService.delete(userId);
        return "redirect:/admin/list";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmp(Model model) {
        model.addAttribute("employeeDto", new EmployeeDto());
        return "admin/updateEmployee";
    }

   /* @RequestMapping("/storeEmp_dto2")
    public String store2(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/employee-dto";
        }
        adminService.update(employeeDto);
        return "redirect:/admin/adminDashboard";
    }*/

}