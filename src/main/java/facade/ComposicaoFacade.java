package facade;

import entidades.Cidade;
import entidades.Composicao;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class ComposicaoFacade extends AbstractFacade<Composicao> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public ComposicaoFacade(){ super(Composicao.class);}
}
