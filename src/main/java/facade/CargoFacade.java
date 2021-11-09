package facade;

import entidades.Cargo;
import entidades.Pessoa;

import javax.inject.Inject;
import javax.persistence.EntityManager;


public class CargoFacade extends AbstractFacade<Cargo> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public CargoFacade(){ super(Cargo.class);}
}
