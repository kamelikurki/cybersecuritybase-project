/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sec.project.repository;

/**
 *
 * @author pumpkin
 */
import org.springframework.data.jpa.repository.JpaRepository;
import sec.project.domain.Pig;

public interface PigRepository extends JpaRepository<Pig, Long> {
        Pig findByName(String name);
}
