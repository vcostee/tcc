package controladores;

import converter.ConverterGenerico;
import entidades.Cidade;
import entidades.Produto;
import facade.CidadeFacade;
import facade.ProdutoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class ProdutoControle implements Serializable {

    private Produto produto = new Produto();
    @Inject
    transient private ProdutoFacade produtoFacade;
    
    private ConverterGenerico converterGenerico;

    @PostConstruct
    public void init(){
        produto = new Produto();
    }

    public ConverterGenerico getConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(produtoFacade);
        }
        return converterGenerico;
    }

    public void setConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<Produto> getListaFiltrando(String parte) {
        return produtoFacade.listaFiltrando(parte, "nome");

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getListaProduto() {
        return produtoFacade.listaTodos();
    }

    public void novo() {
        produto = new Produto();
    }


    public void editar(Produto produto) {
        this.produto = produto;
    }

    public void excluir(Produto produto) {
        produtoFacade.remover(produto);
    }

    public void salvar() {
        produtoFacade.salvar(produto);
        novo();
    }

}
