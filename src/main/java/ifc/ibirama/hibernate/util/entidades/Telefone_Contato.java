/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifc.ibirama.hibernate.util.entidades;

/**
 *
 * @author aluno
 */

@Table (name="Telefone_Contato")
@Entity
public class Telefone_Contato {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer tec_id;
    
    @Column (name="tec_numero", length = 45,unique = true)
    private String tec_numero;
    
    @Column (name= "tec_tipo",nullable = false, unique = true)
    private String tec_tipo;
    @ManyToOne
    @JoinColumn(name="bom_id", unique = true)
    private Bombeiros bombeiro;
    
    
    public Telefone_Contato(){
        
    }

    public Integer getTec_id() {
        return tec_id;
    }

    public void setTec_id(Integer tec_id) {
        this.tec_id = tec_id;
    }

    public String getTec_numero() {
        return tec_numero;
    }

    public void setTec_numero(String tec_numero) {
        this.tec_numero = tec_numero;
    }

    public String getTec_tipo() {
        return tec_tipo;
    }

    public void setTec_tipo(String tec_tipo) {
        this.tec_tipo = tec_tipo;
    }
    
         @Override 
    public boolean equals(Object obj) { 
        if (obj instanceof Telefone_Contato) { 
            Telefone_Contato aux = (Telefone_Contato) obj; 
            if (aux.getTec_id() != null && this.tec_id != null && aux.getTec_id().equals(this.tec_id)) { 
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
