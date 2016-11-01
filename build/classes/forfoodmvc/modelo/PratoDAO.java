/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Usuario
 */
public class PratoDAO {
    public void cadastrar(Prato c){
            EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            manager.persist(c);
            tx.commit();
            
            
        }
        
       public List<Prato> listar(){
           List<Prato> al = null;
           EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            al = (List<Prato>) manager.createQuery("from Prato").getResultList();
            return al;
       } 
       
       public void remover (Prato c){
           EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Prato c1 = manager.find(Prato.class, c.getPraCodigo());
            manager.remove(c1);
            tx.commit();
            
         
           
       }
       
       public void alterar (Prato c){
           EntityManager manager = JpaUtil.getEntityManager();
            EntityTransaction tx = manager.getTransaction();
            tx.begin();
            Prato c1 = manager.find(Prato.class, c.getPraCodigo());
            c1.setPraNome(c.getPraNome());
            c1.setPraPreco(c.getPraPreco());
            c1.setPraTempo(c.getPraTempo());
            c1.setPraDescricao(c.getPraDescricao());
            manager.merge(c1);
            tx.commit();
            
           
       }
    
}
