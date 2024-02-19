package com.example.ytpractice.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAll();

    void createCompany(Company company);

    Company getCompanyById(long id);

    boolean deleteCompany(long id);

    boolean updateCompany(long id, Company updatedCompany);


}
