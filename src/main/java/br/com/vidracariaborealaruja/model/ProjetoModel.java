package br.com.vidracariaborealaruja.model;

import br.com.vidracariaborealaruja.entity.Area;
import br.com.vidracariaborealaruja.entity.CategoriaProjeto;
import br.com.vidracariaborealaruja.entity.Projeto;
import br.com.vidracariaborealaruja.entity.Vao;
import br.com.vidracariaborealaruja.repository.AreaRepository;
import br.com.vidracariaborealaruja.repository.CategoriaRepository;
import br.com.vidracariaborealaruja.repository.ProjetoRepository;
import br.com.vidracariaborealaruja.repository.VaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjetoModel {
    private final CategoriaRepository categoriaRepository;
    private static final String urlServidor = "/images/projetos/";
    private final VaoRepository vaoRepository;
    private final AreaRepository areaRepository;
    private final ProjetoRepository projetoRepository;

    @Autowired
    public ProjetoModel(CategoriaRepository categoriaRepository, VaoRepository vaoRepository,
                        AreaRepository areaRepository, ProjetoRepository projetoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.vaoRepository = vaoRepository;
        this.areaRepository = areaRepository;
        this.projetoRepository = projetoRepository;
    }

    public void cadastraCategoria(String nome) {
        categoriaRepository.save(new CategoriaProjeto(nome));
    }

    public List<CategoriaProjeto> categorias() {
        return (List<CategoriaProjeto>) categoriaRepository.findAll();
    }

    public void cadastraProjeto(String nome, String url, Long divisaoHorizontal, Long divisaoVertical, Long categoriaId) {
        final String  urlPronta = urlServidor + url;
        categoriaRepository.findById(categoriaId).ifPresent(c ->{
            List<Area> areas = new ArrayList<>();
            Vao vao = new Vao("Gerado Pelo Sistema", 0, 0);
            for (int linha = 0; linha < divisaoHorizontal; linha++) {
                for (int coluna = 0; coluna < divisaoVertical; coluna++) {
                    areas.add(new Area(0, 0, coluna, linha, 0, 0, vao));
                }
            }
            Projeto projeto = new Projeto(nome,vao,urlPronta);
            projeto.getVao().getAreas().addAll(areas);
            areas.forEach(area -> {
                area.setVao(vao);
            });
            projeto.setCategoriaProjeto(c);
            c.getProjetos().add(projeto);
            projetoRepository.save(projeto);
        });
    }
}
