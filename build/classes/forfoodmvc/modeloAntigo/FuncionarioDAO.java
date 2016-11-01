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
public class FuncionarioDAO {
    
    private Connection con;
    
    public FuncionarioDAO() {
        this.con = ConnectionFactory.getConnection();
    }
    
    public boolean adiciona(Funcionario fun) {
        String sql = "insert into Funcionario (funNome, funCpf, funFone, funEndereco, funSenha, Cargo_carCodigo) values (?,?,?,?,?,?)";
        boolean verifica = false;
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getCpf());
            stmt.setInt(3, fun.getTelefone());
            stmt.setString(4, fun.getEndereco());
            stmt.setString(5, fun.getSenha());
            stmt.setInt(6, fun.getCarCodigo());

            // executa
            stmt.execute();
            stmt.close();
            verifica = true;
        } catch (SQLException e) {
            System.out.println("ErroSql");
            throw new RuntimeException(e);
        }
        
        return verifica;
    }
    
    public void deleta(String codigo) {
        String sql = "delete from Funcionario where funCPF = ?;";
        
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, codigo);

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList listarFuncionario() {
        String sql = "select * from Funcionario;";
        ArrayList<Funcionario> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Funcionario x = new Funcionario();
                x.setCodigo(rs.getInt(1));
                x.setNome(rs.getString(2));
                x.setEndereco(rs.getString(3));
                x.setTelefone(rs.getInt(4));
                x.setSenha(rs.getString(5));
                x.setCarCodigo(rs.getInt(6));
                x.setCpf(rs.getString(7));                
                
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public ArrayList listarFuncionarioCodigo() {
        String sql = "select funCodigo, funNome from forfood.funcionario;";
        ArrayList<Funcionario> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Funcionario x = new Funcionario();
                x.setCodigo(rs.getInt(1));
                x.setNome(rs.getString(2));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public ArrayList listarSenhaCpfCodigo() {
        String sql = "select funCpf, funSenha from forfood.funcionario;";
        ArrayList<Funcionario> a = new ArrayList();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Funcionario x = new Funcionario();
                x.setCpf(rs.getString(1));
                x.setSenha(rs.getString(2));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public ArrayList listarFuncionarios() {
        String sql = "select * from Funcionario";
        ArrayList<Funcionario> a = new ArrayList<Funcionario>();
        try {
            // prepared statement para inserção
            PreparedStatement stmt = con.prepareStatement(sql);

            // executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no ArrayList
            while (rs.next()) {
                Funcionario x = new Funcionario();
                x.setNome(rs.getString(1));
                x.setTelefone(rs.getInt(2));
                x.setEndereco(rs.getString(3));
                x.setCpf(rs.getString(4));
                x.setSenha(rs.getString(5));
                x.setCarCodigo(rs.getInt(6));
                a.add(x);
            }
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
            
        }
        return a;
    }
    
    public void atualizar(Funcionario fun) {
        String sql = "update Funcionario set funNome=?, funEndereco=?, funFone=?, funSenha=?, Cargo_carCodigo=?, funCpf=? where funCodigo=?";
        
        try {
            
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getEndereco());
            stmt.setInt(3, fun.getTelefone());
            stmt.setString(4, fun.getSenha());
            stmt.setInt(5, fun.getCarCodigo());
            stmt.setString(6, fun.getCpf());
            stmt.setInt(7, fun.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erro SQL");
            throw new RuntimeException(e);
        }
        
        
    }
    
}
