package controladores;

import converter.ConverterGenerico;
import entidades.Produto;
import entidades.UnidadeMedida;
import facade.ProdutoFacade;
import facade.UnidadeMedidaFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class UnidadeMedidaControle implements Serializable {

    private UnidadeMedida unidadeMedida = new UnidadeMedida();
    @Inject
    transient private UnidadeMedidaFacade unidadeMedidaFacade;
    
    private ConverterGenerico converterGenerico;

    @PostConstruct
    public void init(){
        unidadeMedida = new UnidadeMedida();
    }

    public ConverterGenerico getConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(unidadeMedidaFacade);
        }
        return converterGenerico;
    }

    public void setConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<UnidadeMedida> getListaFiltrando(String parte) {
        return unidadeMedidaFacade.listaFiltrando(parte, "nome");

    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public List<UnidadeMedida> getListaUnidades() {
        return unidadeMedidaFacade.listaTodos();
    }

    public void novo() {
        unidadeMedida = new UnidadeMedida();
    }

    public void editar(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public void excluir(UnidadeMedida unidadeMedida) {
        unidadeMedidaFacade.remover(unidadeMedida);
    }

    public void salvar() {
        unidadeMedidaFacade.salvar(unidadeMedida);
        novo();
    }

}
