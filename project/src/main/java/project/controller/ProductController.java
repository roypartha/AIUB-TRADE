package project.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.domain.Product;
import project.domain.User;
import project.service.CustomerService;
import project.service.ProductService;

import javax.validation.Valid;
import java.beans.PropertyEditorSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    private CustomerService customerService;
    public ProductController(ProductService productService, CustomerService customerService) {
        this.productService = productService;
        this.customerService = customerService;
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
        model.addAttribute("products", productService.list());
        return "product/list";
    }
    @RequestMapping("/postList")
    public String postList(Model model) {
        model.addAttribute("products", productService.postList());
        return "product/postList";
    }

    @RequestMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @RequestMapping("/store")
    public String store(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        productService.create(product);
        return "redirect:/products/postList";
    }

    @RequestMapping("/edit")
    public String edit(@RequestParam("productId") Long productId, Model model) throws SQLException {
        model.addAttribute("product", productService.get(productId));
        return "product/edit";
    }
    @RequestMapping("/update")
    public String update(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult) throws SQLException {
        product.setCreatedOn(LocalDate.now());
        if (bindingResult.hasErrors()) {

            return "product/edit";
        }

        productService.update(product);
        return "redirect:/products/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("productId") Long productId) {
        productService.delete(productId);
        return "redirect:/products/postList";
    }


}
