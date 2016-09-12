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
public class Pedido {
    
    private int pedCodigo;
    private boolean pedStatus;
    private int ped_praCodigo;
    private int pedMesa;
    private float pedValorTotal;
    private int ped_funCodigo;

    public int getPedCodigo() {
        return pedCodigo;
    }

    public void setPedCodigo(int pedCodigo) {
        this.pedCodigo = pedCodigo;
    }

    public boolean isPedStatus() {
        return pedStatus;
    }

    public void setPedStatus(boolean pedStatus) {
        this.pedStatus = pedStatus;
    }

    public int getPed_praCodigo() {
        return ped_praCodigo;
    }

    public void setPed_praCodigo(int ped_praCodigo) {
        this.ped_praCodigo = ped_praCodigo;
    }

    public int getPedMesa() {
        return pedMesa;
    }

    public void setPedMesa(int pedMesa) {
        this.pedMesa = pedMesa;
    }

    public float getPedValorTotal() {
        return pedValorTotal;
    }

    public void setPedValorTotal(float pedValorTotal) {
        this.pedValorTotal = pedValorTotal;
    }

    public int getPed_funCodigo() {
        return ped_funCodigo;
    }

    public void setPed_funCodigo(int ped_funCodigo) {
        this.ped_funCodigo = ped_funCodigo;
    }
    
    
    

}