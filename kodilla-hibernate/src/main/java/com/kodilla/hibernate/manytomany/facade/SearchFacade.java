package com.kodilla.hibernate.manytomany.facade;


import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchFacade {

    private Company company;
    private Employee employee;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;


    public List<String> searchCompaniesWithNameLike(String letter)  {
        return companyDao.retrieveCompanyWithA(letter).stream()
                .map(t-> t.getName())
                .collect(Collectors.toList());
    }
    public List<Employee> searchEmployeesWithLastnameLike(String letter) throws NoEmployeesException {
        List<Employee> listOfEmployees = employeeDao.retrieveNameWithA(letter);
        if(listOfEmployees.isEmpty()) {
            throw new NoEmployeesException();
        }
        return employeeDao.retrieveNameWithA(letter);
    }
}

