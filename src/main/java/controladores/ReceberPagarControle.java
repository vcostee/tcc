package controladores;

import ENUM.StatusConta;
import ENUM.TipoConta;
import converter.ConverterGenerico;
import entidades.Cidade;
import entidades.ReceberPagar;
import facade.CidadeFacade;
import facade.ReceberPagarFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewAccessScoped
public class ReceberPagarControle implements Serializable {

    private ReceberPagar receberPagar ;
    @Inject
    transient private ReceberPagarFacade receberPagarFacade;
    
    private ConverterGenerico converterGenerico;
    private Boolean pagar;

    @PostConstruct
    public void init(){

    }

    public ConverterGenerico getConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(receberPagarFacade);
        }
        return converterGenerico;
    }

    public void setConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<ReceberPagar> getListaFiltrando(String parte) {
        return receberPagarFacade.listaFiltrando(parte, "nome");

    }

    public ReceberPagar getReceberPagar() { return receberPagar; }

    public void setReceberPagar(ReceberPagar receberPagar) { this.receberPagar = receberPagar; }

    public List<ReceberPagar> getListaReceberPagar() {
        return receberPagarFacade.listaTodos();
    }

    public List<ReceberPagar> getListaPagar() {
        return receberPagarFacade.todasPagar();
    }
    public List<ReceberPagar> getListaPaga() {
        return receberPagarFacade.todasPagas();
    }
    public List<ReceberPagar> getListaPagaCancelada() {
        return receberPagarFacade.todasPagarCanceladas();
    }

    public List<ReceberPagar> getListaReceber() {
        return receberPagarFacade.todasReceber();
    }
    public List<ReceberPagar> getListaRecebida() {
        return receberPagarFacade.todasRecebidas();
    }
    public List<ReceberPagar> getListaRecebidaCancelada() {
        return receberPagarFacade.todasReceberCanceladas();
    }

    public void novoPagar() {
        receberPagar = new ReceberPagar();
        receberPagar.setRpTipo(TipoConta.PAGAR);
        receberPagar.setRpStatus(StatusConta.ABERTA);
    }

    public void novoReceber() {
        receberPagar = new ReceberPagar();
        receberPagar.setRpTipo(TipoConta.RECEBER);
        receberPagar.setRpStatus(StatusConta.ABERTA);
    }


    public void editar(ReceberPagar receberPagar) {
        this.receberPagar = receberPagar;
    }

    public void pagamento(ReceberPagar receberPagar) {
        this.receberPagar = receberPagar;
        pagar = true;
    }

    public void recebimento(ReceberPagar receberPagar) {
        this.receberPagar = receberPagar;
        pagar = false;
    }

    public void excluir(ReceberPagar receberPagar) {
        receberPagarFacade.remover(receberPagar);
    }

    public void salvarConta() {
        receberPagar.setRpDataCadastro(new Date());
        receberPagarFacade.salvar(receberPagar);
        receberPagar = null;
    }

    public void salvarPaga() {
        receberPagar.setRpDataPagamento(new Date());
        if (pagar) {
            receberPagar.setRpStatus(StatusConta.PAGA);
        } else {
            receberPagar.setRpStatus(StatusConta.RECEBIDA);
        }
        receberPagarFacade.salvar(receberPagar);
        receberPagar = null;
    }

    public void cancelarConta(ReceberPagar rp){
        rp.setRpStatus(StatusConta.CANCELADA);
        receberPagarFacade.salvar(rp);
    }

    public Boolean getPagar() {
        return pagar;
    }

    public void setPagar(Boolean pagar) {
        this.pagar = pagar;
    }
}
