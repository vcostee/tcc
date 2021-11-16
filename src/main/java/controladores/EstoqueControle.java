package controladores;

import converter.ConverterGenerico;
import entidades.Cargo;
import entidades.Produto;
import facade.CargoFacade;
import facade.ProdutoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewAccessScoped
public class EstoqueControle implements Serializable {

    @Inject
    transient private ProdutoFacade produtoFacade;
    private Produto produto;
    private BigDecimal qtd = BigDecimal.ZERO;
    private String tipo = "add";

    @PostConstruct
    public void init(){

    }

    public Integer verificarQtdDecimais(){
        if (produto != null){
            if (produto.getUnidadeMedida() != null){
                return produto.getUnidadeMedida().getUmCasas().intValue();
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public void limparTela(){
        produto = null;
        qtd = BigDecimal.ZERO;
        tipo = "add";
    }

    public void salvar() {
        if(tipo.equals("add")){
            produto.setProdQtd(produto.getProdQtd().add(qtd));
        } else {
            produto.setProdQtd(produto.getProdQtd().subtract(qtd));
            if (produto.getProdQtd().compareTo(BigDecimal.ZERO) < 0){
                limparTela();
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "O produto não pode ter estoque negativo!", "");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return;
            }
        }
        produtoFacade.salvar(produto);
        limparTela();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
