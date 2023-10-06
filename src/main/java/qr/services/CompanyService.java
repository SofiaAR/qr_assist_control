package qr.services;

import qr.dtos.CompanyDto;
import qr.entities.Company;

public interface CompanyService {

    CompanyDto findByIdDto(Long id);

    Company findById(Long id);

}
