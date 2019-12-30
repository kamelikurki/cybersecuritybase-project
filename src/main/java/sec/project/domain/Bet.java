/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.OneToOne;

@Entity
public class Bet extends AbstractPersistable<Long>{
    
    private long amount;

    @OneToOne
    private User bettor;

    @OneToOne
    private Pig target;

    public Bet() {
        super();
    }

    public Bet(long amount, User bettor, Pig target) {
        this();
        this.amount = amount;
        this.bettor = bettor;
        this.target = target;
    }
    
    
    public long getAmount() {
        return this.amount;
    }
    
    public User getBettor() {
        return this.bettor;
    }
    
    public void setBettor(User newBettor) {
        this.bettor = newBettor;
    }
    
    public Pig getTarget() {
        return this.target;
    }
    
    public void setTarget(Pig newTarget) {
        this.target = newTarget;
    }
  
}