/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.domain.Bet;
import sec.project.domain.User;
import sec.project.domain.Race;
import sec.project.repository.BetRepository;
import java.util.List;
import sec.project.repository.PigRepository;
import sec.project.repository.RaceRepository;
import sec.project.repository.UserRepository;

@Controller
public class AdminController {
    
    @Autowired
    private BetRepository betRepo;
    
    @Autowired
    private PigRepository pigRepo;
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private RaceRepository races;

    @RequestMapping(value = "/resolveBets", method = RequestMethod.POST)
    public String resolveBets(@RequestParam String name, Model model) {
    
        Race race = new Race(pigRepo.findByName(name));
        
        races.save(race);
        
        List<Bet> bets = betRepo.findAll();
        
        long totalMoney = 0;
        long winningBets = 0;
        for(Bet bet:bets) {
            totalMoney += bet.getAmount();
            if(bet.getTarget().getName().equals(name)) {
                winningBets++;
            }
        }
        
        if(winningBets != 0) {
            
            long winShare = totalMoney / winningBets;
            
            // Deal winnings to the winning better
            for(Bet bet:bets) {
                totalMoney += bet.getAmount();
                if(bet.getTarget().getName().equals(name)) {
                    
                    User winner = userRepo.findByUsername(bet.getBettor().getUsername());
           
                    winner.setBalance(bet.getBettor().getBalance() + winShare);
                    
                    userRepo.save(winner);
                    
                }
            }         
        }
        
        model.addAttribute("pigs", pigRepo.findAll());
        return "admin";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String loadAdmin(Model model) {
        model.addAttribute("pigs", pigRepo.findAll());
        return "admin";
    }
    
}
