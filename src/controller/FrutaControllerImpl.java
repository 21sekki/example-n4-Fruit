/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import modelo.FrutaModel;
import modelo.entidades.Fruta;
import modelo.entidades.FrutaImpl;
import vista.fruta.FrutaView;

/**
 *
 * @author carlo
 */
public class FrutaControllerImpl extends AbstractControllerImpl<FrutaModel, FrutaView, String> implements FrutaController {

    protected Fruta generaEntidad(List<String> datos) {
        String nombre = datos.get(0);
        String cantidad = datos.get(1);
        String descripcion = datos.get(2);
        Fruta f = new FrutaImpl(nombre);
        f.setCantidad(cantidad);
        f.setDescripcion(descripcion);
        return f;

    }

    protected Fruta generaEntidad(String pk) {
        return new FrutaImpl(pk);
    }

}
