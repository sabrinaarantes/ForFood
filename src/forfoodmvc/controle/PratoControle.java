/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cliente;
import forfoodmvc.modelo.ClienteDAO;
import forfoodmvc.modelo.Prato;
import forfoodmvc.modelo.PratoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class PratoControle {
    
     public void cadastrarControle(Prato p) {
        PratoDAO pdao = new PratoDAO();
        pdao.cadastrar(p);
    }

    public List<Prato> listarPratoControle() {
        PratoDAO pdao = new PratoDAO();
        return pdao.listar();
    }

    public void alterarControle(Prato prato) {
        PratoDAO pdao = new PratoDAO();
        pdao.alterar(prato);
    }

    public void removerControle(Prato p) {
        PratoDAO pdao = new PratoDAO();
        pdao.remover(p);
    }
    
}
