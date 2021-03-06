package Springboot.Myspringboot.viewcontroller;

import Springboot.Myspringboot.Model.modelclass1;
import Springboot.Myspringboot.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Optional;
//<form:hidden path="id"/>

@Controller
@RequestMapping("/")
public class modelviewcontroller {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView getAllusers() {
        ModelAndView model=new ModelAndView("userList");
        List<modelclass1> userList=userService.getAllusers();
        model.addObject("userList",userList);
        return model;
    }

    @GetMapping("/adduser/")
    public ModelAndView adduser() {
        ModelAndView model=new ModelAndView();
        modelclass1 modelclass =new modelclass1();
        model.addObject("Userform", modelclass);
        model.setViewName("user_form");
        return model;
    }
    @GetMapping("/updateuser/{id}")
    public ModelAndView updateuser(@PathVariable(value = "id") int userId) {
        ModelAndView model=new ModelAndView();

        modelclass1 modelclass=userService.getUserById(userId);


        model.addObject("Userform", modelclass);
        model.setViewName("user_form");
       return model;
    }
    @RequestMapping(value="/saveUser", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("Userform") modelclass1 modelclass) {
        userService.createuser(modelclass);

        return new ModelAndView("redirect:/users");
    }
    @GetMapping("/deleteuser/{id}")
    public ModelAndView deleteuser(@PathVariable(value = "id")int userId)
    {
            userService.deleteuser(userId);
            return  new ModelAndView("redirect:/users");
    }
}
