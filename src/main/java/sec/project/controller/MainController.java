package sec.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import sec.project.repository.PigRepository;
import sec.project.repository.UserRepository;
import sec.project.repository.BetRepository;
import sec.project.repository.RaceRepository;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import sec.project.domain.Pig;
import sec.project.domain.Bet;
import sec.project.domain.User;

@Controller
public class MainController {

    @Autowired
    private PigRepository pigs;
    
    @Autowired
    private UserRepository users;
    
    @Autowired
    private BetRepository bets;
    
    @Autowired
    private RaceRepository races;
      
    
    @RequestMapping(value = "/main/{userId}", method = RequestMethod.GET)
    public String loadMain(@PathVariable Long userId, Model model) {
        model.addAttribute("pigs",pigs.findAll());
        model.addAttribute("bets", bets.findAll());
        model.addAttribute("user", users.findOne(userId));
        model.addAttribute("races", races.findAll());
        return "main";
    }
    
    @RequestMapping(value = "/bet/{userId}", method = RequestMethod.POST)
    public String placeBet(@PathVariable Long userId, @RequestParam String name, @RequestParam String amount, Model model) {

        Pig targetPig = pigs.findByName(name);
        
        long amountToBet = Long.valueOf(amount);
        User bettor = users.findOne(userId);
        
        if(amountToBet <= bettor.getBalance() && amountToBet > 0) {
            bettor.setBalance(bettor.getBalance() - amountToBet);
            
            Bet newBet = new Bet(amountToBet, bettor , targetPig);          
            bettor.setPlacedBet(newBet);
            bets.save(newBet);     
        }
        
        return "redirect:/main/" + String.valueOf(userId);
    }
    
}