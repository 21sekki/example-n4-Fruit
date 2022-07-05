/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.entidades.Fruta;
import controlador.FrutaController;
import modelo.persistencia.GenericDAO;
import modelo.persistencia.JDBC.FrutaDAOJDBC;

/**
 *
 * @author carlo
 */
public class FrutaModelImpl extends AbstractModelImpl<FrutaController, Fruta, String> implements FrutaModel {

    protected GenericDAO obtenerImplementacionDAO() {
        return new FrutaDAOJDBC();
        //return new FrutaDAOJPA();
    }

}
