package qr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.dtos.CompanyDto;
import qr.entities.Company;
import qr.mapper.MapperDto;
import qr.repositories.CompanyRepository;
import qr.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserRepository userRepository;


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
    public List<CompanyDto> FindAll() {
        return companyRepository.findAll().stream().map(MapperDto::convertCompanyEntityToDto)
                .collect(Collectors.toList());
    }


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
        if (existingCompany.isPresent()) {
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

    @Override
    public void deactivateCompany(Long id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        if (optionalCompany.isPresent()) {
            Company company = optionalCompany.get();
            company.setActive(false);
            companyRepository.save(company);
        } else {
            throw new IllegalArgumentException("Company not found");
        }
    }
}
