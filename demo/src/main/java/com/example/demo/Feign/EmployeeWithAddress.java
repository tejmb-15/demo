package com.example.demo.Feign;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.example.demo.model.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeWithAddress {
    private Employee employee;
    private List<Address> addresses;

    // Constructor, getters, and setters
}

