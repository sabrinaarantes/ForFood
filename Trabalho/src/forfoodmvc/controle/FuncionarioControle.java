/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modeloAntigo.Funcionario;
import forfoodmvc.modeloAntigo.FuncionarioDAO;
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
     
    public boolean entrarConta(String cpf, String senha){
        return new FuncionarioDAO().verificaConta(cpf, senha);
    }
    
    public boolean adiciona(String cpf, String senha, String nome, String endereco, int telefone, int carcod, String carnome) {
        Funcionario f = new Funcionario();
        f.setCpf(cpf);
        f.setSenha(Criptografia.criptografar(senha));
        f.setTelefone(telefone);
        f.setCarCodigo(carcod);
        f.setCarNome(carnome);
        f.setNome(nome);
        f.setEndereco(endereco);
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
