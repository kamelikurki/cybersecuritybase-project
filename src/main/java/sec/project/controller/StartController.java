/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

/**
 *
 * @author pumpkin
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StartController {

    @RequestMapping("*")
    public String defaultMapping() {
        return "redirect:/start";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String loadStart() {
        return "start";
    }
}