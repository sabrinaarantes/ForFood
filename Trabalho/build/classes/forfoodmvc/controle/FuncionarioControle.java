/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Funcionario;
import forfoodmvc.modelo.FuncionarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class FuncionarioControle {

     public ArrayList<Funcionario> listarSenhaCpfFuncionario() {
        FuncionarioDAO fdao = new FuncionarioDAO();
        return fdao.listarSenhaCpfCodigo();
    }
    
    public boolean adiciona(Funcionario f) {
        FuncionarioDAO fdao = new FuncionarioDAO();
        return fdao.adiciona(f);
    }

    public ArrayList<Funcionario> listarFuncionario() {
        FuncionarioDAO fdao = new FuncionarioDAO();
        return fdao.listarFuncionario();
    }
    
     public ArrayList listarFuncionarioCodigo() {
         FuncionarioDAO fd = new FuncionarioDAO();
         return fd.listarFuncionarioCodigo();
     }
     
     public void alterar(Funcionario f){
        FuncionarioDAO cDAO = new FuncionarioDAO();
        cDAO.atualizar(f);
    }
    
     public void exclui(Funcionario c) {
        FuncionarioDAO cdao = new FuncionarioDAO();
        cdao.deleta(c.getCpf());
    }
    
}
