package Springboot.Myspringboot.Restcontroller;


import Springboot.Myspringboot.Model.modelclass1;
import Springboot.Myspringboot.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class controller {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<modelclass1> getAllusers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public modelclass1 createuser(@RequestBody modelclass1 modelclass1) {
        return userRepository.save(modelclass1);
    }

    @GetMapping("/users/{id}")
    public Optional<modelclass1> getUserById(@PathVariable(value = "id") int userId) {
        return userRepository.findById(userId);
    }

    @PutMapping("/users/{id}")
    public modelclass1 updateuser(@PathVariable(value = "id") int userId,
                           @Valid @RequestBody modelclass1 modeldetails) {
        modelclass1 updatedNote =null;
        Optional<modelclass1> modelclass = userRepository.findById(userId);
        if(modelclass.isPresent()){
            updatedNote=modelclass.get();
            updatedNote.setName(modeldetails.getName());
            updatedNote.setEmail(modeldetails.getEmail());
            userRepository.save(updatedNote);
        }
        return updatedNote;
    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteuser(@PathVariable(value = "id")int userId)
    {
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
