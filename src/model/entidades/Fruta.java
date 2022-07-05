/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.List;

/**
 *
 * @author carlo
 */
public interface Fruta extends Entidad {

    String getNombre();

    String getDescripcion();

    String getCantidad();

    void setNombre(String nombre);

    void setDescripcion(String descripcion);

    void setCantidad(String cantidad);

    List<Fruta> getFrutas();
}
