/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modeloAntigo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
        String sql = "insert into Pedido (pedStatus, Prato_praCodigo, pedMesa, pedValorTotal, Funcionario_funCodigo, pedData, pedQuantidade ) values (?,?,?,?,?,?,?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setBoolean(1, pedido.isPedStatus());
            stmt.setInt(2, pedido.getPed_praCodigo());
            stmt.setInt(3, pedido.getPedMesa());
            stmt.setFloat(4, pedido.getPedValorTotal());
            stmt.setInt(5, pedido.getPed_funCodigo());
            stmt.setString(6, pedido.getData());
            stmt.setInt(7, pedido.getQuantidade());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
        }
    }

    public void deletaPedido(int codigo) {
        String sql = "delete from Pedido where pedCodigo = ?;";

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
        String sql = "select * from Pedido;";
        ArrayList<Pedido> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Pedido x = new Pedido();
                x.setPed_funCodigo(rs.getInt(1));
                x.setPedCodigo(rs.getInt(2));
                x.setPedStatus(rs.getBoolean(3));
                x.setPedValorTotal(rs.getFloat(4));
                x.setPedMesa(rs.getInt(5));
                x.setQuantidade(rs.getInt(6));
                x.setData(rs.getString(7));
                x.setPed_praCodigo(rs.getInt(8));

                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    public Pedido atualizar(Pedido pedido) {
        String sql = "update Pedido set pedStatus=?, pedMesa=?, pedQuantidade=?, Funcionario_funCodigo=?, Prato_praCodigo=?, pedValorTotal= ?, pedData=? where pedCodigo=?";

        try {

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setBoolean(1, pedido.isPedStatus());
            stmt.setInt(2, pedido.getPedMesa());
            stmt.setInt(3, pedido.getQuantidade());
            stmt.setInt(4, pedido.getPed_funCodigo());
            stmt.setInt(5, pedido.getPed_praCodigo());
            stmt.setFloat(6, pedido.getPedValorTotal());
            stmt.setString(7, pedido.getData());
            stmt.setFloat(8, pedido.getPedCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
        }
        return pedido;
    }

}
