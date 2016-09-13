package forfoodmvc.modelo;
// Generated 13/09/2016 11:16:18 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Funcionario generated by hbm2java
 */
public class Funcionario  implements java.io.Serializable {


     private Integer funCodigo;
     private Cargo cargo;
     private String funNome;
     private String funEndereco;
     private int funFone;
     private String funSenha;
     private String funCpf;
     private Set pedidos = new HashSet(0);

    public Funcionario() {
    }

	
    public Funcionario(Cargo cargo, String funNome, String funEndereco, int funFone, String funSenha, String funCpf) {
        this.cargo = cargo;
        this.funNome = funNome;
        this.funEndereco = funEndereco;
        this.funFone = funFone;
        this.funSenha = funSenha;
        this.funCpf = funCpf;
    }
    public Funcionario(Cargo cargo, String funNome, String funEndereco, int funFone, String funSenha, String funCpf, Set pedidos) {
       this.cargo = cargo;
       this.funNome = funNome;
       this.funEndereco = funEndereco;
       this.funFone = funFone;
       this.funSenha = funSenha;
       this.funCpf = funCpf;
       this.pedidos = pedidos;
    }
   
    public Integer getFunCodigo() {
        return this.funCodigo;
    }
    
    public void setFunCodigo(Integer funCodigo) {
        this.funCodigo = funCodigo;
    }
    public Cargo getCargo() {
        return this.cargo;
    }
    
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    public String getFunNome() {
        return this.funNome;
    }
    
    public void setFunNome(String funNome) {
        this.funNome = funNome;
    }
    public String getFunEndereco() {
        return this.funEndereco;
    }
    
    public void setFunEndereco(String funEndereco) {
        this.funEndereco = funEndereco;
    }
    public int getFunFone() {
        return this.funFone;
    }
    
    public void setFunFone(int funFone) {
        this.funFone = funFone;
    }
    public String getFunSenha() {
        return this.funSenha;
    }
    
    public void setFunSenha(String funSenha) {
        this.funSenha = funSenha;
    }
    public String getFunCpf() {
        return this.funCpf;
    }
    
    public void setFunCpf(String funCpf) {
        this.funCpf = funCpf;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


