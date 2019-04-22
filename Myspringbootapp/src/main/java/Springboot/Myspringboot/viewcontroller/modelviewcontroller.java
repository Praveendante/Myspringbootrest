package Springboot.Myspringboot.viewcontroller;

import Springboot.Myspringboot.Model.User;
import Springboot.Myspringboot.Model.UserProfile;
import Springboot.Myspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import java.util.List;
//<form:hidden path="id"/>

@RestController
@RequestMapping("/")
public class modelviewcontroller {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView getAllusers() {
        ModelAndView model=new ModelAndView("userList");
        List<User> userList=userService.getAllusers();
        model.addObject("userList",userList);
        return model;
    }

    @GetMapping("/adduser/")
    public ModelAndView adduser() {
        ModelAndView model=new ModelAndView();
        User modelclass =new User();
        model.addObject("Userform", modelclass);
        model.setViewName("user_form");
        return model;
    }
    @GetMapping("/updateuser/{id}")
    public ModelAndView updateuser(@PathVariable(value = "id") int userId) {
        ModelAndView model=new ModelAndView();

        User modelclass=userService.getUserById(userId);


        model.addObject("Userform", modelclass);
        model.setViewName("user_form");
       return model;
    }
    @RequestMapping(value="/saveUser", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("Userform") User modelclass) {
        userService.createuser(modelclass);

        return new ModelAndView("redirect:/adddetails/" + modelclass.getId());
    }
    @GetMapping("/deleteuser/{id}")
    public ModelAndView deleteuser(@PathVariable(value = "id")int userId)
    {
            userService.deleteuser(userId);
            return  new ModelAndView("redirect:/users");
    }


    //table 2 details
    @GetMapping("/adddetails/{id}")
    public ModelAndView adddetails(@PathVariable(value = "id") int userId) {
        ModelAndView model=new ModelAndView();
       UserProfile modelclass =new UserProfile();
       // UserProfile modelclass =userService.getdetailsById(userId);
        modelclass.setId(userId);
//        modelclass.setUser(userService.getUserById(userId));
        model.addObject("profileform", modelclass);
        model.addObject("userId", String.valueOf(userId));
        model.setViewName("profile_form");
        return model;
    }
    @RequestMapping(value="/saveDetails/{id}", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("profileform") UserProfile modelclass, @PathVariable(value = "id") int userId) {
        User user = userService.getUserById(userId);
        modelclass.setUser(user);
        UserProfile userProfile = userService.createprofile(modelclass);
        user.setUserProfile(userProfile);
        userService.updateuser(userId, user);

        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/getdetails/{id}")
    public ModelAndView getdetails(@PathVariable(value = "id") int userId) {
       ModelAndView model=new ModelAndView("ProfileList");
        List<User> ProfileList = userService.getdetails(userId);
        model.addObject("ProfileList",ProfileList);
        return model;
    }



}
