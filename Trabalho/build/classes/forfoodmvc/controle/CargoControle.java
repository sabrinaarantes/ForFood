/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cargo;
import forfoodmvc.modelo.CargoDAO;
import java.util.ArrayList;

/**
 *
 * @author Alunos
 */
public class CargoControle {
     public boolean adiciona(Cargo c) {
        CargoDAO cdao = new CargoDAO();
        return cdao.adiciona(c);
    }

    public ArrayList<Cargo> listarCargo() {
        CargoDAO cDAO = new CargoDAO();
        return cDAO.listarCargos();
    }

    public void altera(Cargo g) {
     CargoDAO cDAO = new CargoDAO();
     cDAO.atualizar(g);
        
        
    }
    
}
