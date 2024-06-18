package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.model.Customer;
import vn.codegym.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customerList = customerService.findAll();
        if (customerList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customerList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findByID(@PathVariable("id") Long id){
        Optional<Customer> customer = customerService.findById(id);
        if (!customer.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customer.get(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.save(customer), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        Optional<Customer> customerOptional = customerService.findById(id);
     if (!customerOptional.isPresent()){
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
     }
     customer.setId(customerOptional.get().getId());
     return new ResponseEntity<>(customerService.save(customer),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id){
        Optional<Customer> customerOptional = customerService.findById(id);
        if (!customerOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(),HttpStatus.OK);
    }
}
