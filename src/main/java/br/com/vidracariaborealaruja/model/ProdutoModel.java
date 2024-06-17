package br.com.vidracariaborealaruja.model;

import br.com.vidracariaborealaruja.entity.Ferragem;
import br.com.vidracariaborealaruja.entity.Perfil;
import br.com.vidracariaborealaruja.entity.Vidro;
import br.com.vidracariaborealaruja.record.FerragemRecord;
import br.com.vidracariaborealaruja.record.PerfilRecord;
import br.com.vidracariaborealaruja.repository.FerragemRepository;
import br.com.vidracariaborealaruja.repository.PerfilRepository;
import br.com.vidracariaborealaruja.repository.VidroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoModel {
    private final FerragemRepository ferragemRepository;
    private final VidroRepository vidroRepository;
    private final PerfilRepository perfilRepository;

    @Autowired
    public ProdutoModel(FerragemRepository ferragemRepository, VidroRepository vidroRepository, PerfilRepository perfilRepository) {
        this.ferragemRepository = ferragemRepository;
        this.vidroRepository = vidroRepository;
        this.perfilRepository = perfilRepository;
    }

    public void cadastraFerragem(Ferragem ferragem) throws RuntimeException {
        Ferragem existeNoBanco = ferragemRepository.findByCodigo(ferragem.getCodigo());
        if (existeNoBanco == null) {
            ferragemRepository.save(ferragem);
        } else {
            throw new RuntimeException("Codigo da Ferragem já cadastrado no Banco de Dados!");
        }
    }

    public void alteraFerragem(FerragemRecord record) {
        ferragemRepository.findById(record.id()).ifPresent(f -> {
            f.atualiza(record);
            ferragemRepository.save(f);
        });
    }

    public Ferragem buscaFerragem(Long id) {
        return ferragemRepository.findById(id).get();
    }

    public List<Ferragem> ferragens() {
        List<Ferragem> ferragens = (List<Ferragem>) ferragemRepository.findAll();
        if (ferragens == null) return new ArrayList<>();
        return ferragens;
    }


    public List<Vidro> vidros() {
        return (List<Vidro>) vidroRepository.findAll();
    }

    public void alteraVidro(Long id, String nome, Long espessura, boolean isTemperado, boolean isLaminado, String preco) {
        vidroRepository.findById(id).ifPresent(v -> {
            v.atualiza(nome, espessura, isTemperado, isLaminado, new BigDecimal(preco.replace(",", ".")));
            vidroRepository.save(v);
        });
    }

    public Vidro buscaVidro(Long id) {
        return vidroRepository.findById(id).get();
    }

    public void cadastraVidro(String nome, Long espessura, boolean isTemperado, boolean isLaminado, String preco) {
        BigDecimal precoCovertido = new BigDecimal(preco.replace(",", "."));
        vidroRepository.save(new Vidro(nome, espessura, isTemperado, isLaminado, precoCovertido));
    }

    public void cadastraPerfil(PerfilRecord perfilRecord) {
        perfilRepository.save(new Perfil(perfilRecord));
    }

    public Perfil buscaPerfil(Long id) {
        return perfilRepository.findById(id).get();
    }

    public void alteraPerfil(PerfilRecord perfilRecord) {
        perfilRepository.findById(perfilRecord.id()).ifPresent(p -> {
            perfilRepository.save(p.atualiza(perfilRecord));
        });
    }

    public List<Perfil> perfis() {
        return (List<Perfil>) perfilRepository.findAll();
    }
}
