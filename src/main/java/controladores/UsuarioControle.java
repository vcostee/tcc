package controladores;

import converter.ConverterGenerico;
import entidades.Estado;
import entidades.Usuario;
import facade.EstadoFacade;
import facade.UsuarioFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class UsuarioControle implements Serializable {

    private Usuario usuario;
    @Inject
    transient private UsuarioFacade usuarioFacade;
    
    private ConverterGenerico usuConverter;

    @PostConstruct
    public void init(){

    }

    public ConverterGenerico getUsuConverter() {
        if (usuConverter == null) {
            usuConverter = new ConverterGenerico(usuarioFacade);
        }
        return usuConverter;
    }

    public void setUsuConverter(ConverterGenerico converterGenerico) {
        this.usuConverter = converterGenerico;
    }

    public List<Usuario> getListaFiltrando(String parte) {
        return usuarioFacade.listaFiltrando(parte, "nome");
    }

    public List<Usuario> getListaUsuario() {
        return usuarioFacade.listaTodos();
    }

    public void novo() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void editar(Usuario usu) {
        this.usuario = usu;
    }

    public void excluir(Usuario usu) {
        usuarioFacade.remover(usu);
    }

    public void salvar() {
        usuarioFacade.salvar(usuario);
        usuario = null;
    }

}
