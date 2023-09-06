package project.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import project.domain.Customer;
import project.domain.Order;
import project.domain.Product;
import project.domain.User;
import project.dto.OrderDto;
import project.repository.OrderRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class OrderService {
    private Logger logger = Logger.getLogger(ProductService.class.getName());


    private final CustomerService customerService;


    private OrderRepository orderRepository;
    private ProductService productService;
    private UserService userService;

    public  OrderService(OrderRepository orderRepository,CustomerService customerService,ProductService productService, UserService userService){
        this.orderRepository=orderRepository;

        this.productService=productService;

        this.userService= userService;
        this.customerService = customerService;

    }

    public List<Order> list() {
        return orderRepository.list();
    }
    public List<Order> postList() {
        Object loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        String username = String.valueOf(loggedInUser);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            Long userId = ((Customer) authentication.getPrincipal()).getId();
        }

        return orderRepository.list(username);
    }

    public Order get(Long id) {
        return orderRepository.get(id);
    }

   public boolean create(OrderDto orderDto) {
       Order order =new Order();
       order.setProductId(orderDto.getProductId());
       order.setCustomerId(orderDto.getCustomerId());
       return orderRepository.create(order);
    }

    public boolean update(Order order) {
        return orderRepository.update(order);
    }

   // public boolean delete(Long id) {
       // return orderRepository.delete(get(id));
    //}
}
