/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.domain;

import javax.persistence.Entity;
import org.springframework.data.jpa.domain.AbstractPersistable;
import sec.project.domain.User;


@Entity
public class Pig extends AbstractPersistable<Long>{
    
    private String name;
    private String description;
    private User bettor;


    public Pig() {
        super();
    }

    public Pig(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }   
}