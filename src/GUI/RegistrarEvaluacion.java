package GUI;

import Entidades.Alumno;
import Entidades.ListaAlumnos;
import Main.SIRP;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class RegistrarEvaluacion extends javax.swing.JFrame {
    public RegistrarEvaluacion(int id_mat) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Registro de Evaluacion");
        this.id_mat = id_mat;
        id_cur = Integer.parseInt(SIRP.con.ver("SELECT id_cur FROM Registro.materia WHERE id_mat = '"+id_mat+"';", "id_cur"));
        this.verTema();
        this.verEvaluaciones();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Control de Examenes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable1.setModel(modelo);
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Tema");

        jLabel2.setText("Tipo de Evaluacion");

        jButton1.setText("Asignar Notas");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addContainerGap(95, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(jButton1)
                .addGap(3, 3, 3))
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
        configurarTabla();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        configurarTabla();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void verAlumnos(){
        alumnos = new ArrayList();
        ListaAlumnos l = new ListaAlumnos(id_cur);
        alumnos = l.getAl();
    }
    
    private void verEvaluaciones(){
        ResultSet rs = SIRP.con.consulta("SELECT * FROM `registro`.`tipo_ev`");
        id_tip = new ArrayList();
        tipo = new ArrayList();
        try {
            while(rs.next()){            
                id_tip.add(rs.getInt("id_tip"));
                tipo.add(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox2.removeAllItems();
        for(int i = 0;i<tipo.size();i++){
            jComboBox2.addItem(tipo.get(i));
        }        
    }
    
    private void verTema(){
        ResultSet rs = SIRP.con.consulta("SELECT * FROM registro.tema WHERE id_mat ='"+id_mat+"';");
        tema = new ArrayList();
        id_tem = new ArrayList();
        try {
            while(rs.next()){
                id_tem.add(rs.getInt("id_tem"));
                tema.add(rs.getString("tema"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarEvaluacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        jComboBox1.removeAllItems();
        for(int i = 0;i<tema.size();i++){
            jComboBox1.addItem(tema.get(i));
        }
    }
    
    private void verNotas(){
        
    }
    
    private void configurarTabla(){
        verAlumnos();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);  
        modelo.addColumn("Nº");
        modelo.addColumn("Alumno");
        modelo.addColumn("Nota");
        for(int i =0;i<alumnos.size();i++){
            Object row[]= new Object[3];
            row[0]=(i+1);
            row[1]=alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido();
            row[2]="";
            modelo.addRow(row);
        }
        TableColumn col0 = jTable1.getColumnModel().getColumn(0);
        col0.setMaxWidth(30);
        col0.setMinWidth(30);
        TableColumn col = jTable1.getColumnModel().getColumn(2);        
        col.setMaxWidth(100);
        col.setMinWidth(100);
        col.setResizable(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modelo = new DefaultTableModel();  
    private int id_cur;
    private int id_mat;
    private List<Alumno> alumnos;
    private List tema;
    private List id_tem;
    private List id_tip;
    private List tipo;
}
