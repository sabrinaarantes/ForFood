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
public class FuncionarioDAO {
    
     public void cadastrar(Funcionario cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(cli);
        s.getTransaction().commit();
    }

    public void alterar(Funcionario cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(cli);
        s.getTransaction().commit();
    }

    public void deletar(int cpf) {
        for (Funcionario cli : listar()) {
            if (cpf == cli.getFunCodigo()) {
                Funcionario t1 = cli;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(t1);
                s.getTransaction().commit();
            }
        }
    }

    public ArrayList<Funcionario> listar() {
        String hql = "select * from funcionario;";
        ArrayList<Funcionario> arrayAni = new ArrayList();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Funcionario.class));//Sem isso aqui impossível de retornar
        List<Funcionario> clientes = query.list();
        s.getTransaction().commit();
        arrayAni = (ArrayList<Funcionario>) clientes;
        return arrayAni;
    }    
    
    
}
