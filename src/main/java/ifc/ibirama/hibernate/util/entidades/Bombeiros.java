
package ifc.ibirama.hibernate.util.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
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
    private String id;
    @Column (name="bom_cpf", length = 11, unique = true, nullable = false)
    private String cpf;
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
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the bom_cpf
     */
    public String getcpf() {
        return cpf;
    }

    /**
     * @param bom_cpf the bom_cpf to set
     */
    public void setcpf(String bom_cpf) {
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
            Bombeiros aux = (Bombeiros) obj;
            
            // O primeiro if que você fez estava vazio e sem utilidade, então mantive apenas a validação principal
            // Corrigido o fechamento dos parênteses externos do if e adicionado checagens para evitar NullPointerException
            if (aux.getId() != null && this.id != null && aux.getId().equals(this.id) && 
                aux.getcpf() != null && this.cpf != null && aux.getcpf().equals(this.cpf)) {
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