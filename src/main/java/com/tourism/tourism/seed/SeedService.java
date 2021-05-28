package com.tourism.tourism.seed;

import com.tourism.tourism.employee.Employee;
import com.tourism.tourism.employee.EmployeeService;
import com.tourism.tourism.person.PersonType;
import com.tourism.tourism.tourist.Tourist;
import com.tourism.tourism.tourist.TouristService;
import com.tourism.tourism.userlogin.Role;
import com.tourism.tourism.userlogin.UserLogin;
import com.tourism.tourism.userlogin.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SeedService {
    @Autowired
    private TouristService touristService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserLoginService userLoginService;

    public void runAll() {
        runTouristAnonymous();
        runEmployeeAdmin();
    }

    public void runTouristAnonymous() {
        Long userLoginIdExistent = userLoginService.getIdByUsername("anonimo");
        if (Objects.isNull(userLoginIdExistent)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername("anonimo");
            userLogin.setPassword("ingamaps");
            userLogin.setName("Anônimo");
            userLogin.setRole(Role.TOURIST_ANONYMOUS);

            Tourist touristAnonymous = new Tourist();
            touristAnonymous.setName("Anônimo");
            touristAnonymous.setPersonType(PersonType.TOURIST_ANONYMOUS);
            touristAnonymous.setUserLogin(userLoginService.save(userLogin));

            touristService.saveTouristAnonymous(touristAnonymous);
        }
    }

    public void runEmployeeAdmin() {
        Long userLoginIdExistent = userLoginService.getIdByUsername("admin");
        if (Objects.isNull(userLoginIdExistent)) {
            UserLogin userLogin = new UserLogin();
            userLogin.setUsername("admin");
            userLogin.setPassword("123456");
            userLogin.setName("Admin");
            userLogin.setRole(Role.EMPLOYEE);

            Employee employeeAdmin = new Employee();
            employeeAdmin.setName("Admin");
            employeeAdmin.setPersonType(PersonType.EMPLOYEE);
            employeeAdmin.setUserLogin(userLoginService.save(userLogin));

            employeeService.saveEmployeeAdmin(employeeAdmin);
        }
    }
}
