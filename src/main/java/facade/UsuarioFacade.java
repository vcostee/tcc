package facade;

import entidades.Estado;
import entidades.Usuario;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class UsuarioFacade extends AbstractFacade<Usuario> {
    @Inject
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager(){return em;}

    public UsuarioFacade(){ super(Usuario.class);}

    public Usuario pesquisarUsuario(String login, String senha){
        Query q = em.createNativeQuery("select * from usuario u where u.usu_login = :login and u.usu_senha = :senha", Usuario.class);
        q.setParameter("login", login);
        q.setParameter("senha", senha);

        Usuario u = (Usuario) q.getResultList().get(0);
        if (u != null){
            return u;
        } else {
            return null;
        }
    }
}
