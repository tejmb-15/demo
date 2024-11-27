package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.stereotype.Service;

import com.example.demo.Feign.AddressClient;
import com.example.demo.Feign.EmployeeWithAddress;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long empId) {
        return employeeRepository.findById(empId);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long empId, Employee employee) {
        employee.setEmpId(empId);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }
    @Autowired
    private AddressClient addressClient;
    public Optional<EmployeeWithAddress> getEmployeeWithAddress(Long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
    
        if (employeeOptional.isEmpty()) {
            return Optional.empty(); 
        }
    
        Employee employee = employeeOptional.get();
        List<Address> addresses = addressClient.getAddressesByEmpId(empId);
    
        EmployeeWithAddress employeeWithAddress = new EmployeeWithAddress(employee, addresses);
        return Optional.of(employeeWithAddress);
    }
    
}
