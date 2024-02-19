package com.example.ytpractice.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

     @GetMapping
     public ResponseEntity<List<Company>> findAllCompanies() {
        return ResponseEntity.ok(companyService.findAllCompanies());
     }

     // Create a new company
    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return ResponseEntity.ok("Company created successfully");
    }

    // Get a company by id

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable long id) {
        if (companyService.getCompanyById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(companyService.getCompanyById(id));
        }
    }

    // Delete a company by id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable long id) {
        if (companyService.getCompanyById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            companyService.deleteCompany(id);
            return ResponseEntity.ok("Company deleted successfully");
        }
    }

    // Update a company by id by ignoring the id by user sent
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable long id, @RequestBody Company company) {
        Optional<Company> companyOptional = Optional.ofNullable(companyService.getCompanyById(id));

        if (companyOptional.isPresent()) {
            companyService.updateCompany(id, company);
            return ResponseEntity.ok("Company updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
