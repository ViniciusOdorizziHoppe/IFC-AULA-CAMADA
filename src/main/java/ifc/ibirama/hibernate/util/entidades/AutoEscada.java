/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

/**
 *
 * @author aluno
 */
public class AutoEscada extends Viaturas{
    private Integer aue_id;
    private Integer aut_altura_max;
    
    public AutoEscada(){
        
    }

    public Integer getAue_id() {
        return aue_id;
    }

    public void setAue_id(Integer aue_id) {
        this.aue_id = aue_id;
    }

    public Integer getAut_altura_max() {
        return aut_altura_max;
    }

    public void setAut_altura_max(Integer aut_altura_max) {
        this.aut_altura_max = aut_altura_max;
    }
    
        @Override
    public boolean equals(Object obj) {
        if (obj instanceof AutoEscada) {
            AutoEscada aux = (AutoEscada) obj;
            if (aux.getAue_id() != null && this.aue_id != null && aux.getAue_id().equals(this.aue_id)) {
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
