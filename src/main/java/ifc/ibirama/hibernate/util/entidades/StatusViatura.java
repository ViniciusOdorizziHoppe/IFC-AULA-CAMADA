/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

/**
 *
 * @author aluno
 */
public class StatusViatura{
        private Integer stv_id;
        private String stv_descricao;
        private String stv_sigla;
        
        
        public StatusViatura(){
            
        }

    public Integer getStv_id() {
        return stv_id;
    }

    public void setStv_id(Integer stv_id) {
        this.stv_id = stv_id;
    }

    public String getStv_descricao() {
        return stv_descricao;
    }

    public void setStv_descricao(String stv_descricao) {
        this.stv_descricao = stv_descricao;
    }

    public String getStv_sigla() {
        return stv_sigla;
    }

    public void setStv_sigla(String stv_sigla) {
        this.stv_sigla = stv_sigla;
    }
    
      @Override
    public boolean equals(Object obj) {
        if (obj instanceof StatusViatura) {
            StatusViatura aux = (StatusViatura) obj;
            if (aux.getStv_id() != null && this.stv_id != null && aux.getStv_id().equals(this.stv_id)) {
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
