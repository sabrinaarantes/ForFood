/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Alunos
 */
public class CargoDAO {

    public void cadastrar(Cargo c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(c);
        tx.commit();

    }

    public List<Cargo> listar() {
        List<Cargo> al = null;
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        al = manager.createQuery("from Cargo").getResultList();
        return al;
    }

    public void remover(Cargo c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cargo c1 = manager.find(Cargo.class, c.getCarCodigo());
        manager.remove(c1);
        tx.commit();

    }

    public void alterar(Cargo c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cargo c1 = manager.find(Cargo.class, c.getCarCodigo());
        c1.setCarDescricao(c.getCarDescricao());
        c1.setCarNome(c.getCarNome());
        c1.setCarSalario(c.getCarSalario());
        manager.merge(c1);
        tx.commit();

    }

}
