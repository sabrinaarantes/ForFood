package forfoodmvc.modelo;
// Generated 13/09/2016 11:16:18 by Hibernate Tools 4.3.1

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Pedido  implements Serializable {

     private List<Prato> pratos;
     private Cliente cliente;
     private Funcionario funcionario;
     private Integer pedCodigo;
     private boolean pedStatus;
     private float pedValorTotal;
     private int pedMesa;
     private int pedQuantidade;
     private Date pedData;

    public Pedido() {
    }

	
    public Pedido(Funcionario funcionario, Prato prato, boolean pedStatus, float pedValorTotal, int pedMesa, int pedQuantidade, Date pedData) {
        this.pedStatus = pedStatus;
        this.pedValorTotal = pedValorTotal;
        this.pedMesa = pedMesa;
        this.pedQuantidade = pedQuantidade;
        this.pedData = pedData;
    }

   
    @Id
    @GeneratedValue
    public Integer getPedCodigo() {
        return this.pedCodigo;
    }
    
    public void setPedCodigo(Integer pedCodigo) {
        this.pedCodigo = pedCodigo;
    }
    
    @ManyToOne
    @JoinColumn(name="cliCpf")
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
       
    @ManyToOne
    @JoinColumn(name="funCodigo")
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @ManyToMany
    @JoinTable(name ="prato_pedido",joinColumns = @JoinColumn(name = "pedCodigo"),
    inverseJoinColumns = @JoinColumn(name = "praCodigo"))
    public List<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }
   
    public boolean isPedStatus() {
        return this.pedStatus;
    }
    
    public void setPedStatus(boolean pedStatus) {
        this.pedStatus = pedStatus;
    }
    public float getPedValorTotal() {
        return this.pedValorTotal;
    }
    
    public void setPedValorTotal(float pedValorTotal) {
        this.pedValorTotal = pedValorTotal;
    }
    public int getPedMesa() {
        return this.pedMesa;
    }
    
    public void setPedMesa(int pedMesa) {
        this.pedMesa = pedMesa;
    }
    public int getPedQuantidade() {
        return this.pedQuantidade;
    }
    
    public void setPedQuantidade(int pedQuantidade) {
        this.pedQuantidade = pedQuantidade;
    }
    public Date getPedData() {
        return this.pedData;
    }
    
    public void setPedData(Date pedData) {
        this.pedData = pedData;
    }
    




}


