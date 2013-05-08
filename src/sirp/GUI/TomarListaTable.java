package sirp.GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import sirp.Entidades.*;
import sirp.*;

public class TomarListaTable extends javax.swing.JFrame {
    public TomarListaTable(int id_pro) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Control de Asistencia");        
        this.id_pro = id_pro;
        verCursos();
        verMaterias();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jCalendarComboBox1 = new de.wannawork.jcalendar.JCalendarComboBox();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Control de Asistencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable1.setModel(modelo);
        jTable1.setFocusable(false);
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Curso");

        jLabel2.setText("Materia");

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCalendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBox1)
                        .addComponent(jComboBox2))
                    .addComponent(jCalendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        verMaterias();
        configurarTabla();
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tomarValores();
        String sql = "SELECT estado FROM registro.asistencia WHERE id_dia ='"+
                d.getId_dia()+"' AND id_mat ='"+
                id_mat.get(jComboBox2.getSelectedIndex())+"';";
        int n = SIRP.con.nSeleccionados(sql);
        if(n == 0){
            insertarValores();
        }else{
            updateValores();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private void verCursos(){
        curso = new ArrayList();
        id_cur = new ArrayList();
        ResultSet rs = SIRP.con.listaResultados("SELECT curso.curso, curso.id_cur FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                                                "ON profesor.id_pro = materia.id_pro AND curso.id_cur = materia.id_cur AND profesor.id_pro = '"+
                                                id_pro+"' GROUP BY curso ORDER BY id_cur;");
        try {
            while(rs.next()){            
                curso.add(rs.getString("curso"));
                id_cur.add(rs.getInt("id_cur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TomarListaTable.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.removeAllItems();
        for(int i = 0;i<curso.size();i++){
            jComboBox1.addItem(curso.get(i));
        }
    }
    private void verMaterias(){
        jComboBox2.removeAllItems();
        materia = new ArrayList();
        id_mat = new ArrayList();
        ResultSet rs = SIRP.con.listaResultados("SELECT materia.id_mat,materia.materia\n" +
                "FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                "ON profesor.id_pro = materia.id_pro AND materia.id_cur = curso.id_cur AND profesor.id_pro = '"+
                id_pro+"' AND curso.id_cur = '"+
                id_cur.get(jComboBox1.getSelectedIndex())+"'");
        try {
            while(rs.next()){            
                materia.add(rs.getString("materia"));
                id_mat.add(rs.getInt("id_mat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TomarLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0;i<materia.size();i++){
            jComboBox2.addItem(materia.get(i));
        }        
    }
    private void configurarTabla(){
        modelo.setRowCount(0);
        modelo.setColumnCount(0);   
        modelo.addColumn("Alumno");
        modelo.addColumn("Estado");
        ListaAlumnos l = new ListaAlumnos((int)id_cur.get(jComboBox1.getSelectedIndex()));
        alumnos = l.getAl();
        for(int i =0;i<alumnos.size();i++){
            Object row[]= new Object[2];
            row[0]=alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido();
            row[1]="Presente";
            modelo.addRow(row);
        }
        JComboBox combo = CreameCombo();//CREO EL COMBO
        TableColumn col = jTable1.getColumnModel().getColumn(1);        
        col.setMaxWidth(200);
        col.setMinWidth(200);
        col.setResizable(true);
        col = jTable1.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(combo));//AGREGO EL COMBO AL CELLEDITOR
        jTable1.setAutoCreateRowSorter(true);
    }    
    private JComboBox CreameCombo() {
	JComboBox combo = new JComboBox(new String[] {"Presente", "Licencia",  "Falta"}) {
            public void updateUI() {
                super.updateUI();
                setBorder(BorderFactory.createEmptyBorder());
                setUI(new BasicComboBoxUI() {
                    @Override protected JButton createArrowButton() {
                        JButton button = super.createArrowButton();
                        button.setContentAreaFilled(false);
                        button.setBorder(BorderFactory.createEmptyBorder());
                        return button;
                    }
                });
            }
        };
        return combo;
    }    
    private void tomarValores(){         
        nombres = new ArrayList();
        estados = new ArrayList();        
        Date dia = jCalendarComboBox1.getDate();  
        d = new Dia(dia);
        d.insert();
        for(int i = 0;i<modelo.getRowCount();i++){
            String nombre = (String)(modelo.getValueAt(i, 0));
            String estado  = (String)(modelo.getValueAt(i, 1)); 
            nombres.add(nombre);
            if(estado.equals("Presente")){
                estados.add("P");
            }
            else{
                if(estado.equals("Falta"))
                    estados.add("F");
                else
                    estados.add("L");
            }            
        }
    }    
    private void insertarValores(){
        int id_dia = d.getId_dia();
        for(int i = 0; i<alumnos.size();i++){
            String sql = "INSERT INTO registro.asistencia(id_dia,id_alu,id_mat,estado) VALUES ('"
                + id_dia+"','"
                + alumnos.get(i).getId()+"','"
                + id_mat.get(jComboBox2.getSelectedIndex())+"','"
                + estados.get(i)+"');";
            SIRP.con.query(sql);
        }
        String Mensaje = "El Control de Asistencia para la materia de "+jComboBox2.getSelectedItem()+"\n"
                + "Correspondiente al Curso "+jComboBox1.getSelectedItem()+", en el dia "+d.getDia()+"\n"
                + "Se Inserto correctamente";
        JOptionPane.showMessageDialog(rootPane, Mensaje);
    }    
    private void updateValores(){
        int id_dia = d.getId_dia();
        for(int i = 0; i<alumnos.size();i++){
            String sql = "UPDATE `registro`.`asistencia` SET `estado`='"
                + estados.get(i)+"' WHERE id_dia='"
                + id_dia+"' and id_alu='"
                + alumnos.get(i).getId()+"' and id_mat='"
                + id_mat.get(jComboBox2.getSelectedIndex())+"';";
            SIRP.con.query(sql);
        }
        String Mensaje = "El Control de Asistencia para la materia de "+jComboBox2.getSelectedItem()+"\n"
                + "Correspondiente al curso "+jComboBox1.getSelectedItem()+", en el dia "+d.getDia()+"\n"
                + "Se actualizo correctamente";
        JOptionPane.showMessageDialog(rootPane, Mensaje);
    }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private List<Alumno> alumnos;
    private List curso;
    private List id_cur;
    private List materia;
    private List id_mat;
    private int id_pro;
    private List nombres;
    private List estados;
    private DefaultTableModel modelo = new DefaultTableModel();    
    private Dia d;
}
