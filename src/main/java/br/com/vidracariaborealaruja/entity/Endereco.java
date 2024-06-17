/**
 * Autor: Anderson Andrade:.
 * Data Criação: 5 de jan. de 2024
 */
package br.com.vidracariaborealaruja.entity;

import java.util.Objects;

import org.antlr.v4.runtime.misc.NotNull;

import br.com.vidracariaborealaruja.record.EnderecoRecord;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

/**
 *
 */
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @NotNull
    private String tipoLogradouro;
    @NotBlank
    @NotNull
    private String logradouro;
    @NotBlank
    @NotNull
    private String numero;
    @NotBlank
    @NotNull
    private String bairro;
    @NotBlank
    @NotNull
    private String cidade;
    @NotBlank
    @NotNull
    private String estado;

    public Endereco() {

    }

    public Endereco(String tipoLogradouro, String logradouro, String numero, String bairro, String cidade, String estado) {
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", tipoLogradouro=" + tipoLogradouro + ", logradouro=" + logradouro + ", numero="
                + numero + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(bairro, cidade, estado, id, logradouro, numero, tipoLogradouro);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        return Objects.equals(bairro, other.bairro) && Objects.equals(cidade, other.cidade)
                && Objects.equals(estado, other.estado) && Objects.equals(id, other.id)
                && Objects.equals(logradouro, other.logradouro) && Objects.equals(numero, other.numero)
                && Objects.equals(tipoLogradouro, other.tipoLogradouro);
    }

    public void atualiza(EnderecoRecord enderecoRecord) {
        this.tipoLogradouro = enderecoRecord.tipoLogradouro();
        this.logradouro = enderecoRecord.logradouro();
        this.numero = enderecoRecord.numero();
        this.bairro = enderecoRecord.bairro();
        this.cidade = enderecoRecord.cidade();
        this.estado = enderecoRecord.estado();
    }
}
