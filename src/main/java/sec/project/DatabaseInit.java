/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sec.project.repository.PigRepository;
import sec.project.repository.UserRepository;
import sec.project.domain.Pig;
import sec.project.domain.User;

@Component
public class DatabaseInit implements CommandLineRunner {
    private PigRepository pigRepo;
    private UserRepository userRepo;

    public DatabaseInit(PigRepository pigRepo, UserRepository userRepo){
        this.pigRepo = pigRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.pigRepo.deleteAll();

        Pig firstOne = new Pig("John", "Just a regular pig");
        Pig secondOne = new Pig("Babe", "The small one.");

        this.pigRepo.save(firstOne);
        this.pigRepo.save(secondOne);
        this.userRepo.save(new User("admin", "admin", "123 123 123", "admin"));
        System.out.println(" -- Database has been initialized");
    }
}