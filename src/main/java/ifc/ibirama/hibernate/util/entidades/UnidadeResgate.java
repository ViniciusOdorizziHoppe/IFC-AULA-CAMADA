/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

/**
 *
 * @author aluno
 */
public class UnidadeResgate extends Viaturas{
     private Integer unr_id;
     private Integer unr_capacidade;
     
      public UnidadeResgate(){
        
    }

    public Integer getUnr_id() {
        return unr_id;
    }

    public void setUnr_id(Integer unr_id) {
        this.unr_id = unr_id;
    }

    public Integer getUnr_capacidade() {
        return unr_capacidade;
    }

    public void setUnr_capacidade(Integer unr_capacidade) {
        this.unr_capacidade = unr_capacidade;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UnidadeResgate) {
            UnidadeResgate aux = (UnidadeResgate) obj;
            if (aux.getUnr_id() != null && this.unr_id != null && aux.getUnr_id().equals(this.unr_id)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
      
   @Override
    public int hashCode() {
        return getClass().hashCode();
    }
} 
