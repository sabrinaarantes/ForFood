/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

/**
 *
 * @author Alunos
 */
public class Funcionario {
    
    private String nome;
    private String cpf;
    private int telefone;
    private String endereco;
    private String email;
    private String senha;
    private int codigo;
    private int carCodigo;
    private String carNome;

    public int getCarCodigo() {
        return carCodigo;
    }

    public void setCarCodigo(int carCodigo) {
        this.carCodigo = carCodigo;
    }

    public String getCarNome() {
        return carNome;
    }

    public void setCarNome(String carNome) {
        this.carNome = carNome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + ", senha=" + senha + ", codigo=" + codigo + ", carCodigo=" + carCodigo + ", carNome=" + carNome + '}';
    }
    

    
    
}
