/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc;

import forfoodmvc.modelo.JpaUtil;
import forfoodmvc.visao.LoginGUI;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Alunos
 */
public class principal {
    public static void main(String[] args) {
        
        //EntityManager manager = JpaUtil.getEntityManager();
        Persistence.createEntityManagerFactory("forfood");
        new LoginGUI().setVisible(true);
       
       
    }
}
