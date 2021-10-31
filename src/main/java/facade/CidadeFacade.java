package facade;

import entidades.Cidade;
import entidades.Estado;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class CidadeFacade extends AbstractFacade<Cidade> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public CidadeFacade(){ super(Cidade.class);}
}
