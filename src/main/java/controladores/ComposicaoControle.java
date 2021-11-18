package controladores;

import converter.ConverterGenerico;
import entidades.*;
import facade.CidadeFacade;
import facade.ComposicaoFacade;
import facade.ProdutoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewAccessScoped
public class ComposicaoControle implements Serializable {

    private Composicao composicao;
    @Inject
    transient private ComposicaoFacade composicaoFacade;
    @Inject
    transient private ProdutoFacade produtoFacade;
    
    private ConverterGenerico converterGenerico;
    private Produto produto;
    private BigDecimal qtd = BigDecimal.ZERO;
    private BigDecimal precoVenda = BigDecimal.ZERO;
    private UnidadeMedida unidadeMedida;
    private ItemComp itemComp;

    @PostConstruct
    public void init(){
    }

    public ConverterGenerico getConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(composicaoFacade);
        }
        return converterGenerico;
    }

    public void setConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<Composicao> getListaFiltrando(String parte) {
        return composicaoFacade.listaFiltrando(parte, "nome");

    }

    public void addProduto(){
        itemComp = new ItemComp();
        itemComp.setProd(produto);
        itemComp.setQtd(qtd);
        itemComp.setComposicao(this.composicao);
        itemComp.setValor(itemComp.getProd().getProdCusto().multiply(qtd));
        composicao.getItemCompList().add(itemComp);

        composicao.setValor(composicao.getValor().add(itemComp.getValor()));
    }

    public void excluirProduto(ItemComp i){
        composicao.setValor(composicao.getValor().subtract(itemComp.getValor()));
        composicao.getItemCompList().remove(i);
    }

    public Composicao getComposicao() {
        return composicao;
    }

    public void setComposicao(Composicao composicao) {
        this.composicao = composicao;
    }

    public List<Composicao> getListaComposicao() {
        return composicaoFacade.listaTodos();
    }

    public void novo() {
        composicao = new Composicao();
    }


    public void editar(Composicao c) {
        this.composicao = c;
    }

    public void excluir(Composicao c) {
        composicaoFacade.remover(c);
    }

    public void salvar() {
        composicaoFacade.salvar(composicao);
        composicao = null;
    }
    public void salvarProd() {
        Produto p = new Produto();
        p.setProdNome(composicao.getNome());
        p.setProdAtivo(true);
        p.setProdQtd(BigDecimal.ZERO);
        p.setProdPreco(precoVenda);
        p.setProdCusto(composicao.getValor());
        p.setUnidadeMedida(unidadeMedida);
        produtoFacade.salvar(p);

        composicaoFacade.salvar(composicao);
        composicao = null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public ItemComp getItemComp() {
        return itemComp;
    }

    public void setItemComp(ItemComp itemComp) {
        this.itemComp = itemComp;
    }
}
