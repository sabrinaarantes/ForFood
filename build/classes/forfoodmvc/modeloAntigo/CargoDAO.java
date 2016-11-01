
package forfoodmvc.modeloAntigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class CargoDAO {
     // a conexão com o banco de dados
    private Connection con;

    public CargoDAO() {
        this.con = ConnectionFactory.getConnection();
    }

      public boolean adiciona(Cargo cargo) {
        String sql = "insert into Cargo (carNome,carDescricao, carSalario) values (?,?,?)";
        boolean verifica = false;
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());
            stmt.setFloat(3, cargo.getSalario());

            // executa
            stmt.execute();
            stmt.close();
            verifica = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verifica;
    }

    public void deleta(String nome) {
        String sql = "delete from Cargo where carNome = ?;";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, nome);

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

      public ArrayList listarCargos() {
        String sql = "select * from Cargo";
        ArrayList<Cargo> a = new ArrayList<Cargo>();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Cargo x = new Cargo();
                        x.setCodigo(rs.getInt(1));
                        x.setNome(rs.getString(2)) ;
                        x.setDescricao(rs.getString(3));
                        x.setSalario(rs.getFloat(4));
                        
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
            
        }
        return a;
    }

    public void atualizar(Cargo cargo) {
        String sql = "update Cargo set carNome=?, carDescricao=?, carSalario=? where carCodigo=?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cargo.getNome());
            stmt.setString(2, cargo.getDescricao());
            stmt.setFloat(3, cargo.getSalario());
            stmt.setInt(4, cargo.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
        }
        
        
    }  
      
}
