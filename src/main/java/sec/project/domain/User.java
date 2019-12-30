/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;


import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 *
 * @author pumpkin
 */
@Entity
public class User extends AbstractPersistable<Long>{
    //@Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    //private long Id;
    
    private String username;
    private String creditcard;
    private String password;
    private String role;
    private long balance;
    
    @OneToOne
    private Bet placedBet;

    public User() {
        super();
    }

    public User(String username, String password, String creditcard, String role) {
        this();
        this.password = password;
        this.username = username;
        this.creditcard = creditcard;
        this.balance = 100; // Initial balance
        this.role = role;
    }

    // Getters and setters
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }

    public String getCredit() {
        return creditcard;
    }

    public void setCredit(String credit) {
        this.creditcard = credit;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public long getBalance() {
        return balance;
    }

    public void setBalance(long newBalance) {
        this.balance = newBalance;
    } 
    
    public String getRole() {
        return role;
    }
    
    public void setPlacedBet(Bet newBet) {
        this.placedBet = newBet;
    }
    
}
