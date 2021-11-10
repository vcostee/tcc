package controladores;

import converter.ConverterGenerico;
import entidades.Cargo;
import entidades.Estado;
import facade.EstadoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class EstadoControle implements Serializable {

    private Estado estado;
    @Inject
    transient private EstadoFacade estadoFacade;
    
    private ConverterGenerico estadoConverter;

    @PostConstruct
    public void init(){

    }

    public ConverterGenerico getEstadoConverter() {
        if (estadoConverter == null) {
            estadoConverter = new ConverterGenerico(estadoFacade);
        }
        return estadoConverter;
    }

    public void setEstadoConverter(ConverterGenerico converterGenerico) {
        this.estadoConverter = converterGenerico;
    }

    public List<Estado> getListaFiltrando(String parte) {
        return estadoFacade.listaFiltrando(parte, "nome");
    }

    public List<Estado> getListaEstado() {
        return estadoFacade.listaTodos();
    }

    public void novo() {
        estado = new Estado();
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void editar(Estado estado) {
        this.estado = estado;
    }

    public void excluir(Estado estado) {
        estadoFacade.remover(estado);
    }

    public void salvar() {
        estadoFacade.salvar(estado);
        estado = new Estado();
    }

}
