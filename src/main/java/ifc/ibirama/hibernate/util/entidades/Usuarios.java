/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author Vinícius
 */
@Table (name="Usuarios")
@Entity
public class Usuarios {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer uso_id;
    
    @Column (name="uso_login", length = 7)
    private String uso_login;
    
    @Column (name= "uso_senha",nullable = false)
    private String uso_senha;

    public Integer getUso_id() {
        return uso_id;
    }
    private Bombeiros bombeiros;
    public Usuarios(){
        
    }


    public void setUso_id(Integer uso_id) {
        this.uso_id = uso_id;
    }

    public String getUso_login() {
        return uso_login;
    }

    public void setUso_login(String uso_login) {
        this.uso_login = uso_login;
    }

    public String getUso_senha() {
        return uso_senha;
    }

    public void setUso_senha(String uso_senha) {
        this.uso_senha = uso_senha;
    }
    
     @Override 
    public boolean equals(Object obj) { 
        if (obj instanceof Usuarios) { 
            Usuarios aux = (Usuarios) obj; 
            if (aux.getUso_id() != null && this.uso_id != null && aux.getUso_id().equals(this.uso_id) && 
                aux.getUso_login() != null && this.uso_login != null && aux.getUso_login().equals(this.uso_login)) { 
                return true; 
            } else { 
                return false; 
            } 
        } else { 
            return false; 
        } 
    } 

    @Override 
    public int hashCode(){ 
        return getClass().hashCode(); 
    } 
    
}
