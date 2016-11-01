
package forfoodmvc.modeloAntigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RestauranteDAO {
    
    
    
     // a conexão com o banco de dados
    private Connection con;

    public RestauranteDAO() {
        this.con = ConnectionFactory.getConnection();
    }

    public boolean adiciona(Restaurante restaurante) {
        String sql = "insert into Restaurante (resCnpj,resNome, resEndereco, resFone, resSenha) values (?,?,?,?,?)";
        boolean verifica = false;
        
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, restaurante.getCnpj());
            stmt.setString(2, restaurante.getNome());
            stmt.setString(4, restaurante.getEndereco());
            stmt.setInt(3, restaurante.getTelefone());
            stmt.setString(5, restaurante.getSenha());
           
            
            // executa
            stmt.execute();
            stmt.close();
             verifica = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verifica ;
    }

    public void deleta(int codigo) {
        String sql = "delete from Restaurante where cliCodigo = ?;";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, codigo);

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*public ArrayList getRestaurante() {
        String sql = "select * from Cliente;";
        ArrayList<String> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                String x = rs.getString(1) + ", " + rs.getString(2) + "," + rs.getString(3);
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }*/
}
