/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.fruta;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import modelo.entidades.Fruta;

/**
 *
 * @author carlo
 */
public class FrutaTableAndComboModel implements TableModel, ComboBoxModel {

    private List<Fruta> frutas = new ArrayList<Fruta>();
    private List<TableModelListener> tableListeners = new ArrayList<TableModelListener>();
    private List<ListDataListener> dataListeners = new ArrayList<ListDataListener>();

    //Implementacion Singleton
    private static FrutaTableAndComboModel model = null;

    private FrutaTableAndComboModel() {
    }

    public static FrutaTableAndComboModel create() {
        if (model == null) {
            model = new FrutaTableAndComboModel();
        }
        return model;
    }

    public List<Fruta> getFrutas() {
        return frutas;
    }

    public void setFrutas(List<Fruta> frutas) {
        this.frutas = frutas;
        fireContentsChanged();
    }

    protected void fireContentsChanged() {
        fireContentsChangedTableModel();
        fireContentsChangedListData();
    }
    //--------------- MÉTODOS PROPIOS DE TableModel -------------------------

    public Fruta getRow(int indexRow) {
        return frutas.get(indexRow);
    }

    public int getRowCount() {
        return frutas.size();
    }

    public int getColumnCount() {
        return 3; //ya que tendremos tres valores a mostrar por contacto
    }

    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = "Nombre";
                break;
            case 1:
                name = "Cantidad";
                break;
            case 2:
                name = "Descripcion";
                break;
        }
        return name;
    }

    public Class<?> getColumnClass(int columnIndex) {
        return String.class; //Todos los valores de contacto son un String
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //No permito editar celdas
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Fruta fruta = frutas.get(rowIndex);
        String value = null;
        switch (columnIndex) {
            case 0:
                value = fruta.getNombre();
                break;
            case 1:
                value = fruta.getCantidad();
                break;
            case 2:
                value = fruta.getDescripcion();
                break;
        }
        return value;

    }

    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addTableModelListener(TableModelListener l) {
        tableListeners.add(l);
    }

    public void removeTableModelListener(TableModelListener l) {
        tableListeners.remove(l);
    }

    protected void fireContentsChangedTableModel() {
        //TableModelEvent event = new TableModelEvent(this,0,getRowCount());
        TableModelEvent event = new TableModelEvent(this, 0, this.getRowCount() - 1, TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
        for (TableModelListener listener : tableListeners) {
            listener.tableChanged(event);
        }
    }
    //--------------- MÉTODOS PROPIOS DE ComboBoxModel -------------------------
    private Fruta frutaSelected = null;

    public void setSelectedItem(Object anItem) {
        if (anItem != null) {
            frutaSelected = (Fruta) anItem;
            fireContentsChangedListData();
        }
    }

    public Object getSelectedItem() {
        return frutaSelected;
    }

    public int getSize() {
        return frutas.size();
    }

    public Object getElementAt(int index) {
        return frutas.get(index);
    }

    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    protected void fireContentsChangedListData() {
        ListDataEvent e = new ListDataEvent(this, ListDataEvent.CONTENTS_CHANGED, 0, frutas.size());
        for (ListDataListener l : dataListeners) {
            l.contentsChanged(e);
        }
    }
}
