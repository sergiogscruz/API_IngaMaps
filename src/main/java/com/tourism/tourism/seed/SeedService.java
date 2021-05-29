package com.tourism.tourism.seed;

import com.tourism.tourism.employee.Employee;
import com.tourism.tourism.employee.EmployeeService;
import com.tourism.tourism.person.enums.PersonType;
import com.tourism.tourism.tourist.Tourist;
import com.tourism.tourism.tourist.TouristService;
import com.tourism.tourism.userlogin.enums.Role;
import com.tourism.tourism.userlogin.UserLogin;
import com.tourism.tourism.userlogin.UserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

@Service
@Transactional
public class SeedService {
    private final static Logger log = LoggerFactory.getLogger(SeedService.class);

    @Autowired
    private TouristService touristService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private UserLoginService userLoginService;

    public void runAll() {
        log.info("Started run all: " + new Date());
        runTouristAnonymous();
        runEmployeeAdmin();
        log.info("Finished run all: " + new Date());
    }

    public void runTouristAnonymous() {
        log.info("Started run tourist anonymous: " + new Date());
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
        log.info("Finished run tourist anonymous: " + new Date());
    }

    public void runEmployeeAdmin() {
        log.info("Started run employee admin: " + new Date());
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
        log.info("Finished run employee admin: " + new Date());
    }
}
