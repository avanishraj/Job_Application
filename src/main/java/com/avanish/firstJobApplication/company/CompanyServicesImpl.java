package com.avanish.firstJobApplication.company;

public class CompanyServicesImpl implements CompanyServices{

    public CompanyServicesImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    CompanyRepository companyRepository;

    @Override
    public void addCompany(CompanyEntity company) {
        companyRepository.save(company);
    }
}
