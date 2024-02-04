package com.avanish.firstJobApplication.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }

    CompanyServices companyServices;

    @PostMapping()
    public ResponseEntity<String> addCompany(@RequestBody CompanyEntity company){
        companyServices.addCompany(company);
        return ResponseEntity.ok("Company added successfully");
    }
}
