package sk.fei.stuba.oop.zadanie3.mvcupdate.controlers;

import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.fei.stuba.oop.zadanie3.mvcupdate.Service.ServiceLayer;
import sk.fei.stuba.oop.zadanie3.mvcupdate.user.User;

import javax.validation.Valid;
import java.util.Optional;


@Controller
public class UserController {

    private final ServiceLayer userservice;
    private final ServiceLayer agreementservice;

    @Autowired
    public UserController(ServiceLayer userservice,ServiceLayer agreementservice) {
        this.userservice = userservice;
        this.agreementservice = agreementservice;
    }


    @GetMapping("/update/{id}")
    public String update(@PathVariable int id, Model model) {
        Optional<User> UserById = userservice.findUserById(id);
        if (UserById.isPresent()) {
            User user = UserById.get();
            model.addAttribute("user", user);
        }
        return "user/update_user";
    }

    @GetMapping("/")
    public String index(@NotNull Model model){
        model.addAttribute("users",userservice.findAllUsers());
        return "user/all_users";
    }

    @GetMapping("/userdetail/{id}")
    public String userdetail(@PathVariable int id,@NotNull Model model){
        //System.out.println(id);
        Optional<User> UserById = userservice.findUserById(id);
        if (UserById.isPresent()) {
            User user = UserById.get();
            model.addAttribute("user", user);
        }
        //System.out.println(agreementservice.findLifeByInsurerID(id));
        model.addAttribute("agreements1",agreementservice.findLifeByInsurerID(id));
        model.addAttribute("agreements2",agreementservice.findTravelByInsurerID(id));
        model.addAttribute("agreements3",agreementservice.findHouseByInsurerID(id));
        model.addAttribute("agreements4",agreementservice.findHomeByInsurerID(id));
        return "user/userdetail";
    }

    @GetMapping("/add_user")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user/add_user";
    }

    @PostMapping("/")
    public String addSubmit(@ModelAttribute @Valid User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "user/add_user";
        }
        userservice.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/update_user")
    public String updateSubmit(@ModelAttribute User user) {
        userservice.addUser(user);
        return "redirect:/";
    }

   /* @PostMapping("/add_user")
    public String submit(@ModelAttribute User user) {
        userservice.addUser(user);
        return "redirect:/";
    }*/
}
