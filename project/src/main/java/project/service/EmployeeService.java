package project.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.domain.*;
import project.repository.EmployeeRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class EmployeeService {

    private Logger logger = Logger.getLogger(EmployeeService.class.getName());

    private EmployeeRepository employeeRepository;
    private PasswordEncoder passwordEncoder;



    public EmployeeService(EmployeeRepository employeeRepository, PasswordEncoder passwordEncoder) {
        this.employeeRepository=employeeRepository;
        this.passwordEncoder=passwordEncoder;
    }

    public List<Employee> list() {
        return employeeRepository.list();
    }

    public Employee get(Long id) {
        return employeeRepository.get(id);
    }

    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }


    public boolean update(Employee employee) {



        return employeeRepository.update(employee);
    }


    //public User get(String username) { return employeeRepository.get(username); }
    //public User get2(String username) { return employeeRepository.get(username); }
}