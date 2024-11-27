package com.example.demo.Feign;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "address-service", url = "http://localhost:8081/api/addresses")
public interface AddressClient {
    @GetMapping("/employee/{empId}")
    List<Address> getAddressesByEmpId(@PathVariable("empId") Long empId);
}
