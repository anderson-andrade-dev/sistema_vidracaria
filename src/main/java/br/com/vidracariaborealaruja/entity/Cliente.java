/**
 * Autor: Anderson Andrade:.
 * Data Criação: 5 de jan. de 2024
 */
package br.com.vidracariaborealaruja.entity;

import java.util.Objects;

import org.antlr.v4.runtime.misc.NotNull;

import br.com.vidracariaborealaruja.record.ClienteRecord;
import br.com.vidracariaborealaruja.record.EnderecoRecord;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 *
 */
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String nome;
    @Positive
    private Long celular;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public Cliente() {

    }

    public Cliente(ClienteRecord clienteRecord) {
        this.nome = clienteRecord.nome();
        this.celular = clienteRecord.celular();
        this.endereco = new Endereco(clienteRecord.tipoLogradouro(), clienteRecord.logradouro(), clienteRecord.numero(),
                clienteRecord.bairro(), clienteRecord.cidade(), clienteRecord.estado());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", celular=" + celular + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(celular, id, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Cliente other = (Cliente) obj;
        return Objects.equals(celular, other.celular) && Objects.equals(id, other.id)
                && Objects.equals(nome, other.nome);
    }

    public void atualiza(ClienteRecord clienteRecord) {
        this.nome = clienteRecord.nome();
        this.celular = clienteRecord.celular();
        this.endereco.setTipoLogradouro(clienteRecord.tipoLogradouro());
        this.endereco.setLogradouro(clienteRecord.logradouro());
        this.endereco.setNumero(clienteRecord.numero());
        this.endereco.setBairro(clienteRecord.bairro());
        this.endereco.setCidade(clienteRecord.cidade());
        this.endereco.setEstado(clienteRecord.estado());
    }

}
