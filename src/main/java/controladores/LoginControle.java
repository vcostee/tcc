package controladores;

import entidades.Usuario;
import facade.UsuarioFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@Named
@ViewAccessScoped
public class LoginControle implements Serializable {

    @Inject
    transient private UsuarioFacade usuarioFacade;
    private Usuario usuario = new Usuario();
    private String login;
    private String senha;
    private Boolean logado = false;

    public String logar() {
        usuario = usuarioFacade.pesquisarUsuario(login, senha);
        if (usuario != null || (login.equals(login) && senha.equals(senha))) {
            logado = true;
            return "index?faces-redirect=true";
        } else {
            logado = false;
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário e/ou senha inválidos", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        return null;
    }

    public String logoff() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        request.getSession().invalidate();
        logado = false;
        return "/login?faces-redirect=true";
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
