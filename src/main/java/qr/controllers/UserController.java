package qr.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import qr.dtos.UserDto;
import qr.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> findById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findByIdDto(userId));
    }


    @PostMapping("/save")
   public ResponseEntity<UserDto> save(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
   }

   @PutMapping("/update")
   public ResponseEntity<Void> update(@RequestBody UserDto userDto){

        userService.update(userDto);
        return ResponseEntity.ok().build();
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
   }

   @PutMapping("/disable/{userId}")
   public ResponseEntity<String> deactivateUser(@PathVariable Long userId) {
        try{
            userService.deactivateUser(userId);
            return ResponseEntity.ok("Usuario desactivado exitosamente");
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build(); // manejo de exepción cuando no se encuentra al user
        }
   }

   @GetMapping("/all")
   public List<UserDto> getAllUsers(){
        List<UserDto> userDtos = userService.FindAll();
        return userDtos;
   }

}
