package facade;

import entidades.Produto;
import entidades.ReceberPagar;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class ReceberPagarFacade extends AbstractFacade<ReceberPagar> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public ReceberPagarFacade(){ super(ReceberPagar.class);}

    public List<ReceberPagar> todasPagar() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 0 and rp_tipo = 0", ReceberPagar.class);
        return q.getResultList();
    }

    public List<ReceberPagar> todasPagas() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 1 and rp_tipo = 0", ReceberPagar.class);
        return q.getResultList();
    }

    public List<ReceberPagar> todasPagarCanceladas() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 3 and rp_tipo = 0", ReceberPagar.class);
        return q.getResultList();
    }

    public List<ReceberPagar> todasReceber() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 0 and rp_tipo = 1", ReceberPagar.class);
        return q.getResultList();
    }

    public List<ReceberPagar> todasRecebidas() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 2 and rp_tipo = 1", ReceberPagar.class);
        return q.getResultList();
    }

    public List<ReceberPagar> todasReceberCanceladas() {
        Query q = em.createNativeQuery("select * from receberpagar rp where rp.rp_status = 3 and rp_tipo = 1", ReceberPagar.class);
        return q.getResultList();
    }
}
