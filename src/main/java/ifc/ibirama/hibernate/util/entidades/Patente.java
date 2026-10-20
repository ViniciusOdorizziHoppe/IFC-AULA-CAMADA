package ifc.ibirama.hibernate.util.entidades;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Patente")
public class Patente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pat_id;

    @Column(name = "pat_sigla", length = 10, unique = true)
    private String pat_sigla;

    @Column(name = "pat_descricao", nullable = false, unique = true)
    private String pat_descricao;

    @ManyToMany(mappedBy = "patente")
    private Set<Bombeiros> bombeiro = new HashSet<>();

    public Patente() {
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

    public Set<Bombeiros> getBombeiro() {
        return bombeiro;
    }

    public void setBombeiro(Set<Bombeiros> bombeiro) {
        this.bombeiro = bombeiro;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Patente outra = (Patente) obj;

        return pat_id != null
                && Objects.equals(pat_id, outra.pat_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}