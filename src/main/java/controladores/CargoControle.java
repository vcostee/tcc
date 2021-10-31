package controladores;

import converter.ConverterGenerico;
import entidades.Cargo;
import facade.CargoFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewAccessScoped
public class CargoControle implements Serializable {

    private Cargo cargo = new Cargo();
    @Inject
    transient private CargoFacade cargoFacade;
    
    private ConverterGenerico cargoConverter;

    @PostConstruct
    public void init(){
        cargo = new Cargo();
    }

    public ConverterGenerico getCargoConverter() {
        if (cargoConverter == null) {
            cargoConverter = new ConverterGenerico(cargoFacade);
        }
        return cargoConverter;
    }

    public void setCargoConverter(ConverterGenerico cargoConverter) {
        this.cargoConverter = cargoConverter;
    }

    public List<Cargo> getListaCargosFiltrando(String parte) {
        return cargoFacade.listaFiltrando(parte, "nome");

    }

    public List<Cargo> getListaCargo() {
        return cargoFacade.listaTodos();
    }

    public void novo() {
        cargo = new Cargo();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void editar(Cargo cargo) {
        this.cargo = cargo;
    }

    public void excluir(Cargo cargo) {
        cargoFacade.remover(cargo);
    }

    public void salvar() {
        cargoFacade.salvar(cargo);
        cargo = new Cargo();
    }

}
