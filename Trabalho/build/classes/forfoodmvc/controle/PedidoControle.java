/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Pedido;
import forfoodmvc.modelo.PedidoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class PedidoControle {

    public ArrayList listar() {
        PedidoDAO pDAO = new PedidoDAO();
        return pDAO.listarPedidos();

    }

    public void adiciona(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.adicionaPedido(p);
    }

    public void atualizar(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.atualizar(p);
    }

    public void deletar(Pedido p) {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.deletaPedido(p.getPedCodigo());
    }

}
