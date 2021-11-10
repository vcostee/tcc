package controladores;

import converter.ConverterGenerico;
import entidades.Cargo;
import entidades.Cidade;
import facade.CargoFacade;
import facade.CidadeFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class CidadeControle implements Serializable {

    private Cidade cidade;
    @Inject
    transient private CidadeFacade cidadeFacade;
    
    private ConverterGenerico converterGenerico;

    @PostConstruct
    public void init(){
    }

    public ConverterGenerico getConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(cidadeFacade);
        }
        return converterGenerico;
    }

    public void setConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<Cidade> getListaFiltrando(String parte) {
        return cidadeFacade.listaFiltrando(parte, "nome");

    }

    public Cidade getCidade() { return cidade; }

    public void setCidade(Cidade cidade) { this.cidade = cidade; }

    public List<Cidade> getListaCidade() {
        return cidadeFacade.listaTodos();
    }

    public void novo() {
        cidade = new Cidade();
    }


    public void editar(Cidade cidade) {
        this.cidade = cidade;
    }

    public void excluir(Cidade cidade) {
        cidadeFacade.remover(cidade);
    }

    public void salvar() {
        cidadeFacade.salvar(cidade);
        novo();
    }

}
