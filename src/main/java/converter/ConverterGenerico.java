/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import entidades.ClassePai;
import facade.AbstractFacade;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConverterGenerico implements Converter {

    private AbstractFacade facade;

    public ConverterGenerico(AbstractFacade facade) {
        this.facade = facade;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
//        return facade.buscar(Long.parseLong(value));
        if (value != null && !value.equals("null") && !value.equals("")) {
            Long id = Long.parseLong(value);
            return facade.buscar(id);
        } else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }


}