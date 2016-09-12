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


/**
 *
 * @author Alunos
 */
public class ClienteDAO {

    // a conexão com o banco de dados
    private Connection con;

    public ClienteDAO() {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionar(Cliente cliente) {
        String sql = "insert into Cliente (cliNome,cliFone, cliEndereco, cliCPF) values (?,?,?,?)";
        
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, cliente.getNome());
            stmt.setInt(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getCpf());
            

            // executa
            stmt.execute();
            stmt.close();
           
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    public void deletar(int cpf) {
        String sql = "delete from Cliente where cliCpf = ?;";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, cpf);

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList listarClientes() {
        String sql = "select * from Cliente";
        ArrayList<Cliente> a = new ArrayList<Cliente>();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Cliente x = new Cliente();
                        x.setCpf(rs.getInt(1));
                        x.setNome(rs.getString(2)) ;
                        x.setTelefone(rs.getInt(3));
                        x.setEndereco(rs.getString(4));
                        
                        
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
            
        }
        return a;
    }
    
    public void atualizar(Cliente cliente) {
        String sql = "update Cliente set cliNome=?, cliFone=?, cliEndereco=? where cliCpf=?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            
            stmt.setInt(2, cliente.getTelefone());
            stmt.setString(3, cliente.getEndereco());
            stmt.setInt(4, cliente.getCpf());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    

}
