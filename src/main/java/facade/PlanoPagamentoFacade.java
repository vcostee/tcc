package facade;

import entidades.PlanoPagamento;
import entidades.UnidadeMedida;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class PlanoPagamentoFacade extends AbstractFacade<PlanoPagamento> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public PlanoPagamentoFacade(){ super(PlanoPagamento.class);}
}
