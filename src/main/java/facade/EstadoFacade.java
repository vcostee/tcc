package facade;

import entidades.Cargo;
import entidades.Estado;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class EstadoFacade extends AbstractFacade<Estado> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public EstadoFacade(){ super(Estado.class);}
}
