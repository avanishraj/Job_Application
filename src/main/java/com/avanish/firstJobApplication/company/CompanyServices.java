package com.avanish.firstJobApplication.company;


import java.util.List;

public interface CompanyServices {
    void addCompany(CompanyEntity company);

    void deleteCompanyById(Long id);

    List<CompanyEntity> getAllCompanies();

    boolean updateCompanyById(Long id, CompanyEntity updateCompany);
}
