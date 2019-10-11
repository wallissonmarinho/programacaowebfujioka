package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity<User>
    save(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok(user);
    }


    @PutMapping("/user")
    public ResponseEntity update(@Valid @RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user);
    }


    @DeleteMapping("/user")
    public ResponseEntity<String> delete(@Valid @RequestBody User user) {
        userService.delete(user);
       return  ResponseEntity.ok().body("User excluded ID: " + user.getId());
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().body("User excluded ID: " + id);
    }
    
    @GetMapping("/user/name/{firstName}")
    public List<User> getUserListByFirstName(@PathVariable String firstName){
    	return userService.acharUserByFirstName(firstName);
    }
    
    @GetMapping("/user/substring/{string}")
    public List<User> getUserBySubstring(@PathVariable String string){
    	return userService.acharUserBySubstringFirstName(string);
    }
    @GetMapping("/user/lastname/{lastName}")
    public List<User> getProductListByLastName(@PathVariable String lastName){
    	return userService.acharUserByLastName(lastName);
    }
    
    @GetMapping("/user/substringLastname/{string}")
    public List<User> getProductBySubstring(@PathVariable String string){
    	return userService.acharUserBySubstringLastName(string);
    }
    
    @GetMapping("/user/senha/{password}")
    public List<User> getProductByPassword(@PathVariable String password){
    	return userService.acharUserByPassword(password);
    }
    
    @GetMapping("/user/acharLuis")
    public List<User> getLuis(){
    	return userService.acharLuis();
    }


}
