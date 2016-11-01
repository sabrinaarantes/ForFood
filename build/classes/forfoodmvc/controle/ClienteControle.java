/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cliente;
import forfoodmvc.modelo.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class ClienteControle {

    public void adicionaControle(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.cadastrar(c);
    }

    public List<Cliente> listarControle() {
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.listar();
    }

    public void atualizarControle(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.alterar(c);
    }

    public void deletarControle(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.remover(c);
    }

    
    

}
