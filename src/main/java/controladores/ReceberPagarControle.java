package controladores;

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
import java.util.List;

@Named
@ViewAccessScoped
public class ReceberPagarControle implements Serializable {

    private ReceberPagar receberPagar = new ReceberPagar();
    @Inject
    transient private ReceberPagarFacade receberPagarFacade;
    
    private ConverterGenerico converterGenerico;

    @PostConstruct
    public void init(){
        receberPagar = new ReceberPagar();
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

    public void novo() {
        receberPagar = new ReceberPagar();
    }


    public void editar(ReceberPagar receberPagar) {
        this.receberPagar = receberPagar;
    }

    public void excluir(ReceberPagar receberPagar) {
        receberPagarFacade.remover(receberPagar);
    }

    public void salvar() {
        receberPagarFacade.salvar(receberPagar);
        novo();
    }

}
