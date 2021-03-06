package forfoodmvc.modelo;
// Generated 13/09/2016 11:16:18 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Cargo generated by hbm2java
 */
@Entity
public class Cargo implements Serializable{

     private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
     private Integer carCodigo;
     private String carNome;
     private String carDescricao;
     private float carSalario;

    public Cargo() {
    }

	
    public Cargo(String carNome, String carDescricao, float carSalario) {
        this.carNome = carNome;
        this.carDescricao = carDescricao;
        this.carSalario = carSalario;
    }
    public Cargo(String carNome, String carDescricao, float carSalario, Set funcionarios) {
       this.carNome = carNome;
       this.carDescricao = carDescricao;
       this.carSalario = carSalario;
       
    }
   
    @Id
    @GeneratedValue
    public Integer getCarCodigo() {
        return this.carCodigo;
    }
    
    @OneToMany(mappedBy= "funcionarios")
    public void setCarCodigo(Integer carCodigo) {
        this.carCodigo = carCodigo;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
    
    public String getCarNome() {
        return this.carNome;
    }
    
    public void setCarNome(String carNome) {
        this.carNome = carNome;
    }
    public String getCarDescricao() {
        return this.carDescricao;
    }
    
    public void setCarDescricao(String carDescricao) {
        this.carDescricao = carDescricao;
    }
    public float getCarSalario() {
        return this.carSalario;
    }
    
    public void setCarSalario(float carSalario) {
        this.carSalario = carSalario;
    }
   



}


