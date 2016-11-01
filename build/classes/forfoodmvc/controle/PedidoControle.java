/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Pedido;
import forfoodmvc.modelo.PedidoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class PedidoControle {

    public List<Pedido> listarControle() {
        PedidoDAO pDAO = new PedidoDAO();
        return pDAO.listar();

    }

    public void cadastrarControle(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.cadastrar(p);
    }

    public void alterarControle(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.alterar(p);
    }

    public void removerControle(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.remover(p);
    }

}
