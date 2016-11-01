/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Funcionario;
import forfoodmvc.modelo.FuncionarioDAO;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class FuncionarioControle {

    public void cadastrarControle(Funcionario f) {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.cadastrar(f);
    }

    public void removerControle(Funcionario f) {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.remover(f);
    }

    public List<Funcionario> listarControle() {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return fDAO.listar();
    }

    public void alterarControle(Funcionario f) {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.alterar(f);
    }

}
