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
public class CargoDAO {
    
     public void cadastrar(Cargo cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.save(cli);
        s.getTransaction().commit();
    }

    public void alterar(Cargo cli) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        s.saveOrUpdate(cli);
        s.getTransaction().commit();
    }

    public void deletar(int cpf) {
        for (Cargo car : listar()) {
            if (cpf == car.getCarCodigo()) {
                Cargo t1 = car;
                Session s = HibernateUtil.getSessionFactory().getCurrentSession();
                s.beginTransaction();
                s.delete(t1);
                s.getTransaction().commit();
            }
        }
    }

    public ArrayList<Cargo> listar() {
        String hql = "select * from cargo;";
        ArrayList<Cargo> arrayAni = new ArrayList();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        s.beginTransaction();
        Query query = s.createSQLQuery(hql);
        query.setResultTransformer(Transformers.aliasToBean(Cargo.class));//Sem isso aqui impossível de retornar
        List<Cargo> clientes = query.list();
        s.getTransaction().commit();
        arrayAni = (ArrayList<Cargo>) clientes;
        return arrayAni;
    }    
    
    
}
