package Springboot.Myspringboot.Service;


import Springboot.Myspringboot.Model.modelclass1;
import Springboot.Myspringboot.Model.modelclass2;
import Springboot.Myspringboot.Repo.UserRepository;
import Springboot.Myspringboot.Repo.Userdetailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    Userdetailrepo userdetailrepo;
    public List<modelclass1> getAllusers() {
        return userRepository.findAll();
    }

    public modelclass1 createuser(@RequestBody modelclass1 modelclass) {
        return userRepository.save(modelclass);
    }

    public modelclass1 getUserById(@PathVariable(value = "id") int userId) {
        return userRepository.findById(userId).get();
    }
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
    public ResponseEntity<Object> deleteuser(@PathVariable(value = "id")int userId)
    {
        userRepository.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //table2

    public modelclass2 createuserdetails(@RequestBody modelclass2 modelclass) {
        return userdetailrepo.save(modelclass);
    }
    public List<modelclass2> getAlldetails() {
        return userdetailrepo.findAll();
    }


}
