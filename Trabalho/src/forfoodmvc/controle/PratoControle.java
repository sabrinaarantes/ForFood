/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modeloAntigo.Cliente;
import forfoodmvc.modeloAntigo.ClienteDAO;
import forfoodmvc.modeloAntigo.Prato;
import forfoodmvc.modeloAntigo.PratoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class PratoControle {
    
     public boolean adiciona(Prato p) {
        PratoDAO pdao = new PratoDAO();
        return pdao.adiciona(p);
    }

    public ArrayList<Prato> listarPrato() {
        PratoDAO pdao = new PratoDAO();
        return pdao.listarPratos();
    }

    public void atualizar(Prato prato) {
        PratoDAO pdao = new PratoDAO();
        pdao.atualizar(prato);
    }

    public void deletar(Prato p) {
        PratoDAO pdao = new PratoDAO();
        pdao.deleta(p.getCod());
    }
    
    public ArrayList listarPratoCodigo() {
         PratoDAO fd = new PratoDAO();
         return fd.listarPratoCodigo();
     }
    
}
