package project.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import project.domain.*;
import project.dto.EmployeeDto;
import project.dto.UserDto;
import org.springframework.stereotype.Service;
import project.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class UserService {

    private Logger logger = Logger.getLogger(UserService.class.getName());

    private UserRepository userRepository;

    private CustomerService customerService;
    private AddressService addressService;
    private PasswordEncoder passwordEncoder;
    private EmployeeService employeeService;



    public UserService(UserRepository userRepository,CustomerService customerService,AddressService addressService,PasswordEncoder passwordEncoder, EmployeeService employeeService) {
        this.userRepository = userRepository;
         this.customerService = customerService;
         this.addressService = addressService;
         this.passwordEncoder=passwordEncoder;
         this.employeeService =employeeService;

    }

    public List<User> list() {
        return userRepository.list();
    }

    public User get(Long id) {
        return userRepository.get(id);
    }

    public boolean create(User user) {
        return userRepository.create(user);
    }

    public boolean create(UserDto userDto) {



        User user = new User();

        user.setUsername(userDto.getUsername());
        user.setFullName(userDto.getFullName());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPassword(userDto.getPassword());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        //System.out.println(".........................................");
        userRepository.create(user);

        Customer customer = new Customer();
        customer.setGender(userDto.getGender());
        customer.setUni_id(userDto.getUni_id());
        customer.setDateOfBirth(userDto.getDateOfBirth());
        customer.setUser(user);

        //System.out.println(user);
        customerService.create(customer);

        Address address = new Address();
        address.setAddress(userDto.getAddress());
        address.setAddressType(userDto.getAddressType());

        address.setCustomer(customer);


        return  addressService.create(address);


    }


    public boolean createEmp(EmployeeDto employeeDto) {



        User user = new User();

        user.setUsername(employeeDto.getUsername());
        user.setFullName(employeeDto.getFullName());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPassword(employeeDto.getPassword());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        //System.out.println(".........................................");
        userRepository.create(user);

        Employee employee = new Employee();
        employee.setGender(employeeDto.getGender());
        employee.setUni_id(employeeDto.getUni_id());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setAddress(employeeDto.getAddress());
        employee.setUser(user);

        //System.out.println(user);


        return  employeeService.create(employee);


    }

    public boolean update(User user) {
        System.out.println("--------------");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());


        return userRepository.update(user);
    }
    public boolean updatePassword(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.updatePassword(user);
    }

    public boolean delete(Long id) {

        return userRepository.delete(get(id));
    }

    public User get(String username) { return userRepository.get(username); }
    public User get2(String username) { return userRepository.get(username); }
}