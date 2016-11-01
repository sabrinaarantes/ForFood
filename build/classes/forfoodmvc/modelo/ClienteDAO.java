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
public class ClienteDAO {

    public void cadastrar(Cliente c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(c);
        tx.commit();

    }

    public List<Cliente> listar() {
        List<Cliente> al = null;
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        al = (List<Cliente>) manager.createQuery("from Cliente").getResultList();
        return al;
    }

    public void remover(Cliente c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cliente c1 = manager.find(Cliente.class, c.getCliCpf());
        manager.remove(c1);
        tx.commit();

    }

    public void alterar(Cliente c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Cliente c1 = manager.find(Cliente.class, c.getCliCpf());
        c1.setCliNome(c.getCliNome());
        c1.setCliTelefone(c.getCliTelefone());
        c1.setCliEndereco(c.getCliEndereco());
        manager.merge(c1);
        tx.commit();

    }

}
