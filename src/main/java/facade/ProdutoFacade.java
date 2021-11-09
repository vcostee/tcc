package facade;

import entidades.Cidade;
import entidades.Produto;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class ProdutoFacade extends AbstractFacade<Produto> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public ProdutoFacade(){ super(Produto.class);}
}
