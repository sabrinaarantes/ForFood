
package forfoodmvc.controle;


import forfoodmvc.modelo.Restaurante;
import forfoodmvc.modelo.RestauranteDAO;


public class RestauranteControle {

    public boolean adiciona(Restaurante r) {
        RestauranteDAO rDAO = new RestauranteDAO();
        return rDAO.adiciona(r);
    }
    
}
