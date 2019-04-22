package Springboot.Myspringboot.Service;


import Springboot.Myspringboot.Model.User;
import Springboot.Myspringboot.Model.UserProfile;
import Springboot.Myspringboot.Repo.UserRepository;
import Springboot.Myspringboot.Repo.Userdetailrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Userdetailrepo userdetailrepo;
    public List<User> getAllusers() {
        return userRepository.findAll();
    }

    public User createuser(@RequestBody User modelclass) {
        return userRepository.save(modelclass);
    }

    public User getUserById(@PathVariable(value = "id") int userId) {
        return userRepository.findById(userId).get();
    }
    public User updateuser(@PathVariable(value = "id") int userId,
                           @Valid @RequestBody User modeldetails) {
        User updatedNote =null;
        Optional<User> modelclass = userRepository.findById(userId);
        userRepository.find(userId);
        if(modelclass.isPresent()){
            updatedNote=modelclass.get();
            updatedNote.setName(modeldetails.getName());
            updatedNote.setEmail(modeldetails.getEmail());
            updatedNote.setUserProfile(modeldetails.getUserProfile());
            userRepository.save(updatedNote);
        }
        return updatedNote;
    }
    public ResponseEntity<Object> deleteuser(@PathVariable(value = "id")int userId)
    {
        userRepository.deleteById(userId);
        userdetailrepo.deleteById(userId);

//        userdetailrepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //table2


    public UserProfile createprofile(@RequestBody UserProfile modelclass) {
        return userdetailrepo.save(modelclass);
    }
    public List<User> getdetails(@PathVariable(value = "id")int userId) {
       return userRepository.find(userId);
    }
    public UserProfile getdetailsById(@PathVariable(value = "id") int userId) {
        return userdetailrepo.findById(userId).get();
    }


}
