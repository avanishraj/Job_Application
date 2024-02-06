package com.avanish.firstJobApplication.company;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServicesImpl implements CompanyServices{

    public CompanyServicesImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    CompanyRepository companyRepository;

    @Override
    public void addCompany(CompanyEntity company) {
        companyRepository.save(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public List<CompanyEntity> getAllCompanies() {
        return companyRepository.findAll();
    }
}
