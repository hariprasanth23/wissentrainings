package com.wissen.hibernatemapping.controller;

import com.wissen.hibernatemapping.entity.unidirectional.onetomany.Product;
import com.wissen.hibernatemapping.entity.unidirectional.onetomany.Review;
import com.wissen.hibernatemapping.entity.unidirectional.onetoone.Address;
import com.wissen.hibernatemapping.entity.unidirectional.onetoone.Employee;
import com.wissen.hibernatemapping.repository.unidirectional.onetomany.ProductRepository;
import com.wissen.hibernatemapping.repository.unidirectional.onetoone.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class UniDirectionalController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(){

        Address address = Address.builder()
                .city("Bangalore")
                .state("Karnataka").build();

        Employee employee = Employee.builder()
                .firstName("Hari")
                .lastName("Prasanth")
                .email("hari@gmail.com")
                .address(address).build();

        employeeRepository.save(employee);

        return "Saved Successfully";
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){

        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            employeeRepository.deleteById(id);
            return "Deleted Successfully";
        }

        return "Could Not find Employee Id";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(){

        Review goodReview = Review.builder().comment("Nice Product").build();
        Review badReview = Review.builder().comment("Bad Product").build();

        Product product = Product.builder().name("PS5").sellerName("Sony").build();
        product.addReview(goodReview);
        product.addReview(badReview);

        productRepository.save(product);

        return "Saved Successfully";
    }


    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){

        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
            return "Deleted Successfully";
        }

        return "Could Not find Employee Id";
    }

}
