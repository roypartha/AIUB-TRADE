package project.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.domain.Order;
import project.service.CustomerService;
import project.service.OrderService;
import project.service.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private CustomerService customerService;
    private OrderService orderService;

    public OrderController (OrderService orderService, CustomerService customerService) {
        this.orderService=orderService;
        this.customerService = customerService;
    }
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


}
