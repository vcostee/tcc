package facade;

import entidades.Produto;
import entidades.UnidadeMedida;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class UnidadeMedidaFacade extends AbstractFacade<UnidadeMedida> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public UnidadeMedidaFacade(){ super(UnidadeMedida.class);}
}
