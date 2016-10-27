/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forfoodmvc.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Alunos
 */
@Entity
public class Cliente implements Serializable{
    
    private List<Pedido> pedidos;
    private String cliNome ;
    private int cliCpf;
    private int cliTelefone;
    private String cliEndereco;

    @Id
     public int getCliCpf() {
        return cliCpf;
    }

    public void setCliCpf(int cliCpf) {
        this.cliCpf = cliCpf;
    }
    
    @OneToMany(mappedBy= "cliente")
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getCliNome() {
        return cliNome;
    }

    public void setCliNome(String cliNome) {
        this.cliNome = cliNome;
    }

    public int getCliTelefone() {
        return cliTelefone;
    }

    public void setCliTelefone(int cliTelefone) {
        this.cliTelefone = cliTelefone;
    }

    public String getCliEndereco() {
        return cliEndereco;
    }

    public void setCliEndereco(String cliEndereco) {
        this.cliEndereco = cliEndereco;
    }
   
    

    
    
    
    
    
}
