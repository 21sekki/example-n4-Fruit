/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrutaViewImpl.java
 *
 * Created on 23-nov-2009, 9:47:30
 */
package vista.fruta;

import vista.AbstractViewImpl;
import controlador.FrutaController;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Fruta;
import modelo.FrutaModel;

/**
 *
 * @author carlo
 */
public class FrutaViewImpl extends AbstractViewImpl<FrutaController, FrutaModel> implements FrutaView {

    //Atributos propios de Swing
    private FrutaTableAndComboModel tableModel;
    private FrutaViewImplInternal panelFruta;

    /** Creates new form FrutaViewImpl */
    public FrutaViewImpl() {
        //tableModel = new FrutaTableAndComboModel();
        tableModel = FrutaTableAndComboModel.create();
        initComponents();

        this.panelFruta = new FrutaViewImplInternal(this);
        this.jPanelFruta.add(this.panelFruta);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFruta = new javax.swing.JTable();
        jPanelFruta = new javax.swing.JPanel();

        jTableFruta.setModel(tableModel);
        jTableFruta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFrutaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFruta);

        jPanelFruta.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelFruta.setLayout(new javax.swing.BoxLayout(jPanelFruta, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelFruta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelFruta, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTableFrutaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFrutaMouseClicked
        FrutaTableAndComboModel ctm = (FrutaTableAndComboModel) this.jTableFruta.getModel();
        Fruta pieza = ctm.getRow(this.jTableFruta.getSelectedRow());
        panelFruta.setPieza(pieza);
    }//GEN-LAST:event_jTableFrutaMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelFruta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFruta;
    // End of variables declaration//GEN-END:variables

    public void refresh() {
        tableModel.setFrutas(getModel().listar());//cambia el modelo de JTable(TableModel) por medio de una clase que hemos creado (ContactosTableModel)
    }

    protected void fireNuevaFrutaGesture(String nombre, String cantidad, String descripcion) {
        List<String> datos = new ArrayList<String>();
        datos.add(nombre);
        datos.add(cantidad);
        datos.add(descripcion);
        getController().nuevaEntidadGesture(datos);
    }

    protected void fireActualizaFrutaGesture(String nombre, String cantidad, String descripcion) {
        List<String> datos = new ArrayList<String>();
        datos.add(nombre);
        datos.add(cantidad);
        datos.add(descripcion);
        getController().actualizaEntidadGesture(datos);
    }

    protected void fireBorraFrutaGesture(String nombre) {
        getController().borraEntidadGesture(nombre);
    }
}
