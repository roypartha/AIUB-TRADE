package project.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import project.domain.User;
import project.dto.UserDto;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.dto.OrderDto;
import project.service.CustomerService;
import project.service.OrderService;
import project.service.ProductService;
import project.service.UserService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private ProductService productService;
    private CustomerService customerService;

    private OrderService orderService;

    public UserController(UserService userService,ProductService productService,CustomerService customerService,OrderService orderService) {
        this.userService = userService;
        this.productService=productService;
        this.customerService=customerService;
        this.orderService=orderService;
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

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", userService.list());
        return "user/list";
    }

    @RequestMapping("/userDashboard")
    public String dashBoard(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("loggedInUser", loggedInUser);
        return "user/userDashboard";
    }

    @RequestMapping("/sellPage")
    public String sellPage(Model model) {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("loggedInUser", loggedInUser);
        return "user/sellPage";
    }

   /*@RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "user/login";
    }*/


    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

   /* @RequestMapping("/create_dto")
    public String createDto(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "home/create-dto";
    }*/

    @RequestMapping("/store_dto")
    public String store(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/create-project.dto";
        }
        userService.create(userDto);
        return "redirect:/users/login";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/create";
        }
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        /*userService.create(user);*/
        return "redirect:/users/list";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("userId") Long userId, Model model) throws SQLException {
        model.addAttribute("user", userService.get(userId));
        return "user/edit";
    }

    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }

        userService.update(user);
        return "redirect:/users/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("userId") Long userId,Model model) {
        model.addAttribute("user", userService.delete(userId));
        // userService.delete(userId);
        return "redirect:/users/list";
    }

    @RequestMapping("/order_create")
    public String createOrder(Model model) {
        model.addAttribute("orderDto", new OrderDto());
        model.addAttribute("products", productService.list());
        model.addAttribute("customers", customerService.list());
        return "order/order";
    }

    @RequestMapping("/store_order")
    public String store(@Valid @ModelAttribute("orderDto") OrderDto orderDto, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "user/order/create";
        }
        orderService.create(orderDto);
        return "redirect:/products/list";
    }
}
