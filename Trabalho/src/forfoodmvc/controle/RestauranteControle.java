
package forfoodmvc.controle;


import forfoodmvc.modeloAntigo.Restaurante;
import forfoodmvc.modeloAntigo.RestauranteDAO;


public class RestauranteControle {

    public boolean adiciona(Restaurante r) {
        RestauranteDAO rDAO = new RestauranteDAO();
        return rDAO.adiciona(r);
    }
    
}
