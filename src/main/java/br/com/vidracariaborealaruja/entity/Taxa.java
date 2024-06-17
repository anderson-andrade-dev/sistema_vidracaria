package br.com.vidracariaborealaruja.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Taxa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 100, min = 0)
    private long credito;
    @Size(max = 100, min = 0)
    private long debito;

    public Taxa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getCredito() {
        return credito;
    }

    public void setCredito(long credito) {
        this.credito = credito;
    }

    public long getDebito() {
        return debito;
    }

    public void setDebito(long debito) {
        this.debito = debito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Taxa taxa = (Taxa) o;
        return credito == taxa.credito && debito == taxa.debito && Objects.equals(id, taxa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, credito, debito);
    }

    @Override
    public String toString() {
        return "Taxa{" +
                "id=" + id +
                ", credito=" + credito +
                ", debito=" + debito +
                '}';
    }
}
