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
import java.util.Date;

/**
 *
 * @author Vinícius
 */
@Table (name="Viatura")
@Entity
public class Viaturas {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer via_id;
    
    @Column (name="via_placa", length = 7)
    private String via_placa;
    
    @Column (name= "via_combustivel",nullable = false)
    private String via_Combustivel;
    @Column (name= "via_utima_revisao",nullable = false, length = 45)
    private String via_utima_revisao;
    @Column (name= "via_km",nullable = false, length = 45)
    private String via_km;
   
    public Viaturas(){
        
    }

    public Integer getVia_id() {
        return via_id;
    }

    public void setVia_id(Integer via_id) {
        this.via_id = via_id;
    }

    public String getVia_placa() {
        return via_placa;
    }

    public void setVia_placa(String via_placa) {
        this.via_placa = via_placa;
    }

    public String getVia_Combustivel() {
        return via_Combustivel;
    }

    public void setVia_Combustivel(String via_Combustivel) {
        this.via_Combustivel = via_Combustivel;
    }

    public String getVia_utima_revisao() {
        return via_utima_revisao;
    }

    public void setVia_utima_revisao(String via_utima_revisao) {
        this.via_utima_revisao = via_utima_revisao;
    }

    public String getVia_km() {
        return via_km;
    }

    public void setVia_km(String via_km) {
        this.via_km = via_km;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Viaturas) {
            Viaturas aux = (Viaturas) obj;
                        if (aux.getVia_id() != null && this.via_id != null && aux.getVia_id().equals(this.via_id) && 
                aux.getVia_placa() != null && this.via_placa != null && aux.getVia_placa().equals(this.via_placa)) {
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
