/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.User;
import sec.project.repository.UserRepository;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loadLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String submitForm(@RequestParam String username, @RequestParam String password) {
        
        List<User> users = userRepository.findAll();
        
        for(User u:users) {
            
            if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
                
                if(username.equals("admin")) {
                    return "redirect:/admin";
                }
                
                long id = u.getId();
                return "redirect:/main/" + String.valueOf(id);
            }
        }

        return "login";
    }
}