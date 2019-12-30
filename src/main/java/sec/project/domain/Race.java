/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

/**
 *
 * @author pumpkin
 */
import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.OneToOne;
/**
 *
 * @author pumpkin
 */
@Entity
public class Race extends AbstractPersistable<Long>{

    @OneToOne
    public Pig winner;

    public Race() {
        super();
    }

    public Race(Pig winner) {
        this();
        this.winner = winner;
    }
}