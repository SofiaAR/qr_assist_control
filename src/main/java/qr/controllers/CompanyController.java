package qr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qr.dtos.CompanyDto;
import qr.services.CompanyService;

import java.util.List;
@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
        public ResponseEntity<List<CompanyDto>>getAllCompanies(){
            List<CompanyDto> companyDtos = companyService.FindAll();
            return ResponseEntity.ok(companyDtos);
        }

    @GetMapping("/{companyId}")
    public ResponseEntity<CompanyDto>companyById(@PathVariable Long id) {

        CompanyDto companyDto = companyService.findByIdDto(id);
        if (companyDto != null) {
            return ResponseEntity.ok(companyDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<CompanyDto>save(@RequestBody CompanyDto companyDto){
        return ResponseEntity.ok(companyService.save(companyDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Void>update(@RequestBody CompanyDto companyDto){
        companyService.update(companyDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>delete(Long id){
        companyService.delete(id);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/disable/{id}")
    public ResponseEntity<String> deactivateCompany(@PathVariable Long id) {
        try{
            companyService.deactivateCompany(id);
            return ResponseEntity.ok("Compañia desactivada exitosamente");
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build(); // manejo de exepción
        }
    }
}
