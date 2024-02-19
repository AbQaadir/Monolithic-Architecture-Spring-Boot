package com.example.ytpractice.company.impl;

import com.example.ytpractice.company.Company;
import com.example.ytpractice.company.CompanyRepository;
import com.example.ytpractice.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCompany(long id) {
        if (companyRepository.existsById(id)) {
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCompany(long id, Company updatedCompany) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {

            Company company = companyOptional.get();
            company.setName(updatedCompany.getName());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());

            companyRepository.save(company);
            return true;
        }
        return false;
    }

}
