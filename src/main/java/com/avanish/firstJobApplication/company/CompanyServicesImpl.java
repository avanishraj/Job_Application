package com.avanish.firstJobApplication.company;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public boolean updateCompanyById(Long id, CompanyEntity updateCompany) {
        Optional<CompanyEntity> company = companyRepository.findById(id);
        if (company.isPresent()){
            CompanyEntity companyEntity = company.get();
            companyEntity.setDescription(updateCompany.getDescription());
            companyEntity.setName(updateCompany.getName());
            companyRepository.save(companyEntity);
            return true;
        }
        return  false;
    }


}
