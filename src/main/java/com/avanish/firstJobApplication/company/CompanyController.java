package com.avanish.firstJobApplication.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id){
        companyServices.deleteCompanyById(id);
        return ResponseEntity.ok("Successfully Deleted");
    }

    @GetMapping()
    public ResponseEntity<List<CompanyEntity>> getAllCompanies(){
        return ResponseEntity.ok(companyServices.getAllCompanies());
    }
}
