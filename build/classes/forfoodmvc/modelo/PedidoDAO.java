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
 * @author Alunos
 */
public class PedidoDAO {
    
    public void cadastrar(Pedido c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(c);
        tx.commit();

    }

    public List<Pedido> listar() {
        List<Pedido> al = null;
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        al = (List<Pedido>) manager.createQuery("from Pedido").getResultList();
        return al;
    }

    public void remover(Pedido c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Pedido c1 = manager.find(Pedido.class, c.getPedCodigo());
        manager.remove(c1);
        tx.commit();

    }

    public void alterar(Pedido c) {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        Pedido c1 = manager.find(Pedido.class, c.getPedCodigo());
        c1.setCliente(c.getCliente());
        c1.setFuncionario(c.getFuncionario());
        c1.setPedCodigo(c.getPedCodigo());
        c1.setPedData(c.getPedData());
        c1.setPedMesa(c.getPedMesa());
        c1.setPedQuantidade(c1.getPedQuantidade());
        c1.setPedStatus(c.isPedStatus());
        c1.setPedValorTotal(c1.getPedValorTotal());
        c1.setPratos(c1.getPratos());
        manager.merge(c1);
        tx.commit();

    }
    
}
