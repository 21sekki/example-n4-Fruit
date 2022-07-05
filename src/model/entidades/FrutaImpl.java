/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.entidades;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlo
 */
public class FrutaImpl implements Fruta {

    private String nombre;
    private String cantidad;
    private String descripcion;
    private List<Fruta> frutas;

    public FrutaImpl(String nombre) {
        this(nombre, null, null);
    }

    public FrutaImpl(String nombre, String cantidad, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.frutas = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void addFruta(Fruta fruta) {
        this.frutas.add(fruta);
    }

    public void removeFactura(Fruta fruta) {
        this.frutas.remove(fruta);
    }

    public List<Fruta> getFrutas() {
        return frutas;
    }

    public void setFacturas(List<Fruta> frutas) {
        this.frutas = frutas;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FrutaImpl other = (FrutaImpl) obj;
        if ((this.nombre == null) ? (other.nombre != null) : !this.nombre.equals(other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        return hash;
    }

    public String toString() {
        return getCantidad();
    }

}
