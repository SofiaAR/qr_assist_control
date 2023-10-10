package qr.services;

import qr.dtos.CompanyDto;
import qr.entities.Company;

import java.util.List;

public interface CompanyService {

    CompanyDto findByIdDto(Long id);

    Company findById(Long id);

    List<CompanyDto> FindAll();

    CompanyDto save(CompanyDto companyDto);

    void update(CompanyDto companyDto);

    void delete(Long id);
}
