/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Alunos
 */
public class ClienteDAO {
    
    
    public void cadastrar(Cliente cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(cli);
        s.getTransaction().commit();
    }

    public void alterar(Cliente cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(cli);
        s.getTransaction().commit();
    }

    public void deletar(int cpf) {
        for (Cliente cli : listar()) {
            if (cpf == cli.getCliCpf()) {
                Cliente t1 = cli;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(t1);
                s.getTransaction().commit();
            }
        }
    }

    public ArrayList<Cliente> listar() {
        String hql = "select * from cliente;";
        ArrayList<Cliente> arrayAni = new ArrayList();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Cliente.class));//Sem isso aqui impossível de retornar
        List<Cliente> clientes = query.list();
        s.getTransaction().commit();
        arrayAni = (ArrayList<Cliente>) clientes;
        return arrayAni;
    }    
    
}
