package facade;

import entidades.Produto;
import entidades.ReceberPagar;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class ReceberPagarFacade extends AbstractFacade<ReceberPagar> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public ReceberPagarFacade(){ super(ReceberPagar.class);}
}
