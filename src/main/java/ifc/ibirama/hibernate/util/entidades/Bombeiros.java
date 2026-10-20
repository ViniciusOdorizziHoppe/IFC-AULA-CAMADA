package ifc.ibirama.hibernate.util.entidades;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Bombeiro")
public class Bombeiros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "bom_cpf", length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "bom_data_nascimento", nullable = false)
    private Date bom_data_nascimento;

    @Column(name = "bom_nome_completo", nullable = false, length = 45)
    private String bom_nome_completo;

    @Column(name = "bom_nome_guerra", nullable = false, length = 45)
    private String bom_nome_guerra;

    @OneToMany(mappedBy = "bombeiro")
    private Set<Telefone_Contato> telefone = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Bombeiro_has_Patente",
        joinColumns = @JoinColumn(name = "bom_id"),
        inverseJoinColumns = @JoinColumn(name = "pat_id")
    )
    private Set<Patente> patente = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "Bombeiro_has_Usuarios",
        joinColumns = @JoinColumn(name = "bom_id"),
        inverseJoinColumns = @JoinColumn(name = "usu_id")
    )
    private Set<Usuarios> usuarios = new HashSet<>();

    public Bombeiros() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getBom_data_nascimento() {
        return bom_data_nascimento;
    }

    public void setBom_data_nascimento(Date bom_data_nascimento) {
        this.bom_data_nascimento = bom_data_nascimento;
    }

    public String getBom_nome_completo() {
        return bom_nome_completo;
    }

    public void setBom_nome_completo(String bom_nome_completo) {
        this.bom_nome_completo = bom_nome_completo;
    }

    public String getBom_nome_guerra() {
        return bom_nome_guerra;
    }

    public void setBom_nome_guerra(String bom_nome_guerra) {
        this.bom_nome_guerra = bom_nome_guerra;
    }

    public Set<Telefone_Contato> getTelefone() {
        return telefone;
    }

    public void setTelefone(Set<Telefone_Contato> telefone) {
        this.telefone = telefone;
    }

    public Set<Patente> getPatente() {
        return patente;
    }

    public void setPatente(Set<Patente> patente) {
        this.patente = patente;
    }

    public Set<Usuarios> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuarios> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Bombeiros outro = (Bombeiros) obj;

        return id != null && Objects.equals(id, outro.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}