
package forfoodmvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class PratoDAO {
     // a conexão com o banco de dados
    private Connection con;

    public PratoDAO() {
        this.con = ConnectionFactory.getConnection();
    }

    public boolean adiciona(Prato prato) {
        String sql = "insert into Prato (praNome,praPreco, praDescricao, praTempo) values (?,?,?,?)";
        boolean verifica = false;

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, prato.getNome());
            stmt.setFloat(2, prato.getPreco());
            stmt.setString(3, prato.getDescricao());
            stmt.setInt(4, prato.getTempo());
            
            
            // executa
            stmt.execute();
            stmt.close();
            verifica = true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verifica;
    }

    public void deleta(int codigo) {
        String sql = "delete from Prato where praCodigo = ?;";

        try {
           
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, codigo);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList listarPratos() {
        String sql = "select * from Prato;";
        ArrayList<Prato> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Prato x = new Prato();
                        x.setCod(rs.getInt(1));
                        x.setNome(rs.getString(2)) ;
                        x.setDescricao(rs.getString(3));
                        x.setPreco(rs.getFloat(4));
                        x.setTempo(rs.getInt(5));
                        
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public void atualizar(Prato prato) {
        String sql = "update Prato set praNome=?, praDescricao=?, praPreco=?, praTempo=? where praCodigo=?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, prato.getNome());
            stmt.setFloat(3, prato.getPreco());
            stmt.setString(2, prato.getDescricao());
            stmt.setInt(4, prato.getTempo());
            stmt.setInt(5, prato.getCod());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
    }
    
    public ArrayList listarPratoCodigo() {
        String sql = "select praCodigo, praNome, praPreco from forfood.prato;";
        ArrayList<Prato> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Prato x = new Prato();
                        x.setCod(rs.getInt(1));
                        x.setNome(rs.getString(2));
                        x.setPreco(rs.getFloat(3));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
