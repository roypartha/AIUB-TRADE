package project.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.domain.Employee;
import project.domain.User;
import project.dto.EmployeeDto;
import project.repository.AdminRepository;
import project.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.logging.Logger;

@Service
@Transactional
public class AdminService {
    private Logger logger = Logger.getLogger(AdminService.class.getName());
    private UserService userService;
    private EmployeeService employeeService;
    private AdminRepository adminRepository;
    public AdminService(UserService userService,EmployeeService employeeService, AdminRepository adminRepository) {
        this.userService= userService;
        this.employeeService=employeeService;
        this.adminRepository=adminRepository;

    }

    public boolean update(EmployeeDto employeeDto) {



        User user = new User();

        user.setUsername(employeeDto.getUsername());
        user.setFullName(employeeDto.getFullName());
        //user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setPassword(employeeDto.getPassword());
        user.setEnabled(true);
        user.setCreatedOn(LocalDate.now());
        //System.out.println(".........................................");
        userService.update(user);

        Employee employee = new Employee();
        employee.setGender(employeeDto.getGender());
        employee.setUni_id(employeeDto.getUni_id());
        employee.setDateOfBirth(employeeDto.getDateOfBirth());
        employee.setAddress(employeeDto.getAddress());
        employee.setUser(user);

        //System.out.println(user);


        return  employeeService.create(employee);


    }




}
