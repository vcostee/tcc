package controladores;

import ENUM.TipoPlanoPagamento;
import converter.ConverterGenerico;
import entidades.PlanoPagamento;
import facade.PlanoPagamentoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class PlanoPagamentoControle implements Serializable {

    private PlanoPagamento planoPagamento ;
    @Inject
    transient private PlanoPagamentoFacade planoPagamentoFacade;
    
    private ConverterGenerico converterGenerico;

    @PostConstruct
    public void init(){

    }

    public ConverterGenerico getPlanoPagamentoConverter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(planoPagamentoFacade);
        }
        return converterGenerico;
    }

    public void setPlanoPagamentoConverter(ConverterGenerico converterGenerico) {
        this.converterGenerico = converterGenerico;
    }

    public List<PlanoPagamento> getListaFiltrando(String parte) {
        return planoPagamentoFacade.listaFiltrando(parte, "nome");
    }

    public List<PlanoPagamento> getListaPlanoPagamento() {
        return planoPagamentoFacade.listaTodos();
    }

    public void novo() {
        planoPagamento = new PlanoPagamento();
    }

    public PlanoPagamento getPlanoPagamento() {
        return planoPagamento;
    }

    public void setPlanoPagamento(PlanoPagamento planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public void editar(PlanoPagamento planoPagamento) {
        this.planoPagamento = planoPagamento;
    }

    public void excluir(PlanoPagamento planoPagamento) {
        planoPagamentoFacade.remover(planoPagamento);
    }

    public void salvar() {
        planoPagamentoFacade.salvar(planoPagamento);
        planoPagamento = null;
    }

    public TipoPlanoPagamento[] tiposPlano(){
        return TipoPlanoPagamento.values();
    }

}
