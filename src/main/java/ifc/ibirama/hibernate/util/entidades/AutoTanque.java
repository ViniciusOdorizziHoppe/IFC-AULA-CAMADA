/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class AutoTanque extends Viaturas{
    private Integer aut_id;
    private Float aut_litragem;
    
    public AutoTanque(){
        
    }

    public Integer getAut_id() {
        return aut_id;
    }

    public void setAut_id(Integer aut_id) {
        this.aut_id = aut_id;
    }

    public Float getAut_litragem() {
        return aut_litragem;
    }

    public void setAut_litragem(Float aut_litragem) {
        this.aut_litragem = aut_litragem;
    }
    
       @Override
    public boolean equals(Object obj) {
        if (obj instanceof AutoTanque) {
            AutoTanque aux = (AutoTanque) obj;
            if (aux.getAut_id() != null && this.aut_id != null && aux.getAut_id().equals(this.aut_id)) {
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
