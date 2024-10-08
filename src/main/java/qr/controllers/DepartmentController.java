package qr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qr.dtos.DepartmentDto;
import qr.dtos.UserDto;
import qr.services.DepartmentService;
import qr.services.UserService;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable Long id){
        DepartmentDto departmentDto = departmentService.findDtoById(id);
        if (departmentDto != null){
            return ResponseEntity.ok(departmentDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/save")
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.save(departmentDto));
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@RequestBody DepartmentDto departmentDto) {

        departmentService.update(departmentDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        departmentService.delete(id);
        return ResponseEntity.ok().build(); // entrega respuesta 200 ok , indica q la operacion se realizo con exito.
    }

}
