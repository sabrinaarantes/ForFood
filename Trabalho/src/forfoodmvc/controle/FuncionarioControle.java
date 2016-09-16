/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cargo;
import forfoodmvc.modelo.Funcionario;
import forfoodmvc.modelo.FuncionarioDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class FuncionarioControle {

     
    public boolean entrarConta(String cpf, String senha){
        return new FuncionarioDAO().verificaConta(cpf, senha);
    }
    
    public void adiciona(int cpf, String senha, String nome, String endereco, int telefone,Cargo cargo) {
        Funcionario f = new Funcionario();
        f.setFunCpf(cpf);
        f.setFunSenha(Criptografia.criptografar(senha));
        f.setFunFone(telefone);
        f.setFunNome(nome);
        f.setFunEndereco(endereco);
        f.setCargo(cargo);
        FuncionarioDAO fdao = new FuncionarioDAO();
        fdao.cadastrar(f);
    }

    public ArrayList<Funcionario> listarFuncionario() {
        FuncionarioDAO fdao = new FuncionarioDAO();
        return fdao.listar();
    }
     public void alterar(Funcionario f){
        FuncionarioDAO cDAO = new FuncionarioDAO();
        cDAO.alterar(f);
    }
    
     public void exclui(Funcionario c) {
        FuncionarioDAO cdao = new FuncionarioDAO();
        cdao.deletar(c.getFunCpf());
    }
    
}
