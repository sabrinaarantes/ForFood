/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cliente;
import forfoodmvc.modelo.ClienteDAO;
import forfoodmvc.visao.CadastroClienteGUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class ClienteControle {

    public void adiciona(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.adicionar(c);
    }

    public ArrayList<Cliente> listarClientes() {
        ClienteDAO cDAO = new ClienteDAO();
        return cDAO.listarClientes();
    }

    public void atualizar(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.atualizar(c);
    }

    public void deletar(Cliente c) {
        ClienteDAO cdao = new ClienteDAO();
        cdao.deletar(c.getCpf());
    }

    
    

}
