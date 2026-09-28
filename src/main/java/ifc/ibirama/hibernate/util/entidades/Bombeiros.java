*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

import java.util.Date;
import jakarta.prasitence.Entity;

import javax.annotation.processing.Generated;



/**
 *
 * @author Vinícius
 */
@Table (name="Bombeiro")
@Entity
public class Bombeiros {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column (name="bom_cpf", length = 11, unique = tue, nullable = false)
    private char cpf;
    @Column (name= "bom_data_nscimento",nullable = false)
    private Date bom_data_nascimento;
    @Column (name= "bom_nome_completo",nullable = false, length = 45)
    private String bom_nome_completo;
    @Column (name= "bom_nome_guerra",nullable = false, length = 45)
    private String bom_nome_guerra;
   
    public Bombeiros(){
        
    }
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the bom_cpf
     */
    public char getcpf() {
        return cpf;
    }

    /**
     * @param bom_cpf the bom_cpf to set
     */
    public void setcpf(char bom_cpf) {
        this.cpf = bom_cpf;
    }

    /**
     * @return the bom_data_nascimento
     */
    public Date getBom_data_nascimento() {
        return bom_data_nascimento;
    }

    /**
     * @param bom_data_nascimento the bom_data_nascimento to set
     */
    public void setBom_data_nascimento(Date bom_data_nascimento) {
        this.bom_data_nascimento = bom_data_nascimento;
    }

    /**
     * @return the bom_nome_completo
     */
    public String getBom_nome_completo() {
        return bom_nome_completo;
    }

    /**
     * @param bom_nome_completo the bom_nome_completo to set
     */
    public void setBom_nome_completo(String bom_nome_completo) {
        this.bom_nome_completo = bom_nome_completo;
    }

    /**
     * @return the bom_nome_guerra
     */
    public String getBom_nome_guerra() {
        return bom_nome_guerra;
    }

    /**
     * @param bom_nome_guerra the bom_nome_guerra to set
     */
    public void setBom_nome_guerra(String bom_nome_guerra) {
        this.bom_nome_guerra = bom_nome_guerra;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bombeiros) {
            Bombeiros aux = (Bombeiros)obj;
            if((aux.getId() != null) || (aux.getcpf() != null)){
                
            }
            if (aux.getId().equals(this.id)) && (aux.getcpf().equals(this.cpf)) {
                return true;
            }
        }else   {
            return false;
        }
    }
    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
    
}