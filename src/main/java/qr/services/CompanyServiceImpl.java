package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.CompanyDto;
import qr.entities.Company;
import qr.mapper.MapperDto;
import qr.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto findByIdDto(Long id) {
        Optional<Company> companyEntity = companyRepository.findById(id);
        if (companyEntity.isPresent()) {
            Company company = companyEntity.get();
            return MapperDto.convertCompanyEntityToDto(company);
        } else return null;
    }

    @Override
    public Company findById(Long id) {
        Optional<Company> companyEntity = companyRepository.findById(id);
        if (companyEntity.isPresent()) {
            return companyEntity.get();
        } else {
            return null;
        }
    }

    @Override
    public List<CompanyDto> FindAll() {return null;}


    @Override
    public CompanyDto save(CompanyDto companyDto) {
        Company company = new Company();

        //Asignando valores del DTO a la entidad
        company.setId(companyDto.getId());
        company.setName(companyDto.getName());
        company.setRut(companyDto.getRut());
        company.setTurn(companyDto.getTurn());
        company.setActive(companyDto.isActive());

        // Guarda la entidad en el repositorio
        Company savedCompany = companyRepository.save(company);

        // actualiza la entidad en el repo
        companyDto.setId(savedCompany.getId());

        return companyDto;
    }

    @Override
    public void update(CompanyDto companyDto) {
        Optional<Company> existingCompany = companyRepository.findById(companyDto.getId());
        if (existingCompany.isPresent()){
            Company updatedCompany = existingCompany.get();
            
        }

    }

    @Override
    public void delete(Long id) {
        //se declara variable de tipo optional se carga con los datos que retorna el metodo finbyid
        Optional<Company> optionalUser = companyRepository.findById(id);

        if (optionalUser.isPresent()) {
            Company company = new Company();
            company = optionalUser.get();
            companyRepository.delete(company);
        }
    }

}
