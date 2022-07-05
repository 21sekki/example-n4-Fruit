/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.persistencia.JDBC;

import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Fruta;
import modelo.entidades.FrutaImpl;
import modelo.persistencia.FrutaDAO;

/**
 *
 * @author carlo
 */
public class FrutaDAOJDBC implements FrutaDAO {

    public void create(Fruta entidad) {

        String sql = "insert into frutas(nombre,cantidad,descripcion) values (?,?,?)";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getNombre());
            stm.setString(2, entidad.getCantidad());
            stm.setString(3, entidad.getDescripcion());

            stm.execute();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public Fruta read(String pk) {
        Fruta f = null;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM frutas where nombre=" + pk);
            String nombre, cantidad, descripcion;
            if (res.next()) {
                nombre = res.getString("nombre");
                cantidad = res.getString("cantidad");
                descripcion = res.getString("descripcion");
                f = new FrutaImpl(nombre, cantidad, descripcion);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return f;
    }

    public void update(Fruta entidad) {
        String sql = "update frutas set cantidad=?, descripcion=? where nombre like ?";
        try {
            PreparedStatement stm = Persistencia.createConnection().prepareStatement(sql);
            stm.setString(1, entidad.getCantidad());
            stm.setString(2, entidad.getDescripcion());
            stm.setString(3, entidad.getNombre());

            stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public void delete(Fruta entidad) {
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            stmt.executeUpdate("DELETE FROM frutas where nombre=" + entidad.getNombre());

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    public List<Fruta> list() {
        List<Fruta> piezas = new ArrayList<Fruta>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM frutas ");
            String nombre, cantidad, descripcion;
            while (res.next()) {

                nombre = res.getString("nombre");
                cantidad = res.getString("cantidad");
                descripcion = res.getString("descripcion");
                piezas.add(new FrutaImpl(nombre, cantidad, descripcion));
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
        return piezas;
    }
}
