/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
/**
 *
 * @author aluno
 */

@Table (name="Patente")
@Entity
public class Patente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer pat_id;
    
    @Column (name="pat_sigla", length = 10,unique = true)
    private String pat_sigla;
    
    @Column (name= "pat_descricao",nullable = false, unique = true)
    private String pat_descricao;
    
    private Set<Bombeiros> bombeiro = new HashSet<Bombeiros()>                                                                      
    
    public Patente(){
        
    }

    public Integer getPat_id() {
        return pat_id;
    }

    public void setPat_id(Integer pat_id) {
        this.pat_id = pat_id;
    }

    public String getPat_sigla() {
        return pat_sigla;
    }

    public void setPat_sigla(String pat_sigla) {
        this.pat_sigla = pat_sigla;
    }

    public String getPat_descricao() {
        return pat_descricao;
    }

    public void setPat_descricao(String pat_descricao) {
        this.pat_descricao = pat_descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.pat_id);
        hash = 37 * hash + Objects.hashCode(this.pat_sigla);
        hash = 37 * hash + Objects.hashCode(this.pat_descricao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Patente other = (Patente) obj;
        if (!Objects.equals(this.pat_sigla, other.pat_sigla)) {
            return false;
        }
        if (!Objects.equals(this.pat_descricao, other.pat_descricao)) {
            return false;
        }
        return Objects.equals(this.pat_id, other.pat_id);
    }

    
   

   
    
}
