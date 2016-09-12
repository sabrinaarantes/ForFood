/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jdbc_dao.ConnectionFactory;

/**
 *
 * @author Alunos
 */
public class PedidoDAO {
    
     private Connection con;

    public PedidoDAO() {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionaPedido(Pedido pedido) {
        String sql = "insert into Funcionario (pedCodigo, pedStatus, Prato_praCodigo) values (?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, pedido.getPedCodigo());
            stmt.setBoolean(2, pedido.isPedStatus());
            stmt.setInt(3, pedido.getPed_praCodigo());
            stmt.setInt(4, pedido.getPedMesa());
            stmt.setFloat(5, pedido.getPedValorTotal());
            stmt.setInt(6, pedido.getPed_funCodigo());
            
            
            
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletaPedido(int codigo) {
        String sql = "delete from Mesa_Pedido where mesaCodigo = ?;";

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

    public ArrayList listarPedidos() {
        String sql = "select * from Mesa_Pedido;";
        ArrayList<Pedido> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Pedido x = new Pedido();
                        x.setPedCodigo(rs.getInt(1));
                        x.setPedStatus(rs.getBoolean(2));
                        x.setPed_praCodigo(rs.getInt(3));
                        x.setPedMesa(rs.getInt(4));
                        x.setPedValorTotal(rs.getFloat(5));
                        x.setPed_funCodigo(0);
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
}
