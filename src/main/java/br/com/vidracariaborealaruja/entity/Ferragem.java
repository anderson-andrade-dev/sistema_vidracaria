package br.com.vidracariaborealaruja.entity;

import br.com.vidracariaborealaruja.record.FerragemRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo"})})
public class Ferragem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O código não pode ser nulo!")
    @NotBlank(message = "O código é obrigatório e não pode ficar em branco!")
    @Size(min = 4, max = 10, message = "O código deve ter o mínimo de {min} e o máximo de {max} !")
    @Column(name = "codigo", unique = true)
    private String codigo;
    @NotNull(message = "A descrição não pode ser nula!")
    @NotBlank(message = "A descrição é obrigatória e não pode ficar em branco!")
    @Size(min = 5, max = 255, message = "A descrição deve ter o mínimo de {min} e o máximo de {max} !")
    private String descricao;
    @DecimalMin(value = "0.0", message = "O preco não pode ser ser menor que 0.0!")
    private BigDecimal preco;

    public Ferragem() {
    }

    public Ferragem(String codigo, String descricao, BigDecimal preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void atualiza(FerragemRecord record) {
        this.codigo = record.codigo();
        this.descricao = record.descricao();
        this.preco = new BigDecimal(record.preco().replace(",", "."));
    }

    public void atualiza(String codigo, String descricao, BigDecimal preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ferragem ferragem = (Ferragem) o;
        return Objects.equals(id, ferragem.id) &&
                Objects.equals(codigo, ferragem.codigo) &&
                Objects.equals(descricao, ferragem.descricao) &&
                Objects.equals(preco, ferragem.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, descricao, preco);
    }

    @Override
    public String toString() {
        return "Ferragem{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
