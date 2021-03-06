package controladores;

import ENUM.TipoPessoa;
import converter.ConverterGenerico;
import entidades.Pessoa;
import facade.CargoFacade;
import facade.PessoaFacade;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@ViewAccessScoped
public class PessoaControle implements Serializable {

    private Pessoa pessoa;
    @Inject
    transient private PessoaFacade pessoaFacade;
    @Inject
    transient private CargoFacade cargoFacade;
    
    private ConverterGenerico pessoaConverter;
    private ConverterGenerico cargoConverter;

    @PostConstruct
    public void init(){

    }

    public ConverterGenerico getPessoaConverter() {
        if (pessoaConverter == null) {
            pessoaConverter = new ConverterGenerico(pessoaFacade);
        }
        return pessoaConverter;
    }
    public ConverterGenerico getCargoConverter() {
        if (cargoConverter == null) {
            cargoConverter = new ConverterGenerico(cargoFacade);
        }
        return cargoConverter;
    }

    public void setPessoaConverter(ConverterGenerico pessoaConverter) {
        this.pessoaConverter = pessoaConverter;
    }

    public List<Pessoa> getListaPessoasFiltrando(String parte) {
        return pessoaFacade.listaFiltrando(parte, "nome");

    }

    public void setarSalario(){
        if (pessoa.getCargo() != null && pessoa.getCargo().getCargoSalario() != null) {
            pessoa.setPesSalario(pessoa.getCargo().getCargoSalario());
        } else {
            pessoa.setPesSalario(BigDecimal.ZERO);
        }
    }

    public List<Pessoa> getListaPessoa() {
        return pessoaFacade.listaTodos();
    }

    public void novo() {
        pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa Pessoa) {
        this.pessoa = Pessoa;
    }

    public void editar(Pessoa pes) {
        this.pessoa = pes;
    }

    public void excluir(Pessoa fun) {
        pessoaFacade.remover(fun);
    }

    public void salvar() {
        pessoaFacade.salvar(pessoa);
        pessoa = null;
    }

    public TipoPessoa[] tipoPessoas(){
        return TipoPessoa.values();
    }

}
