/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.controle;

import forfoodmvc.modelo.Cargo;
import forfoodmvc.modelo.CargoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alunos
 */
public class CargoControle {

    public void cadastrarControle(Cargo c) {
        CargoDAO c1 = new CargoDAO();
        c1.cadastrar(c);
    }

    public List<Cargo> listarControle() {
        CargoDAO c1 = new CargoDAO();
        return c1.listar();
    }

    public void removerControle(Cargo c) {
        CargoDAO c1 = new CargoDAO();
        c1.remover(c);
    }

    public void alterarControle(Cargo c) {
        CargoDAO c1 = new CargoDAO();
        c1.alterar(c);
    }
}
