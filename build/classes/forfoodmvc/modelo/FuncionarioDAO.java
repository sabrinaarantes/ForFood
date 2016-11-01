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
public class FuncionarioDAO {

    public void cadastrar(Funcionario c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(c);
        tx.commit();

    }

    public List<Funcionario> listar() {
        List<Funcionario> al = null ;
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        al = (List<Funcionario>) manager.createQuery("from Funcionario").getResultList();
        return al;
    }

    public void remover(Funcionario c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Funcionario c1 = manager.find(Funcionario.class, c.getFunCodigo());
        manager.remove(c1);
        tx.commit();

    }

    public void alterar(Funcionario c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Funcionario c1 = manager.find(Funcionario.class, c.getFunCodigo());
        c1.setFunNome(c.getFunNome());
        c1.setFunCpf(c.getFunCpf());
        c1.setFunSenha(c.getFunSenha());
        c1.setFunEndereco(c.getFunEndereco());
        c1.setCargo(c.getCargo());
        c1.setFunFone(c.getFunFone());
        manager.merge(c1);
        tx.commit();

    }

}
