package sirp.GUI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sirp.Entidades.*;
import sirp.*;

public class TomarLista extends javax.swing.JFrame {
    public TomarLista(int id_pro) {
        this.id_pro = id_pro;
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.tomarValores();
        this.setTitle("Prof: "+profesor);
        this.verCursos();
        this.verMaterias();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jCalendarPanel1 = new de.wannawork.jcalendar.JCalendarPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Datos para Toma de Asistencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jCalendarPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Fecha", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jButton1.setText("Tomar Lista");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Curso: ");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Materia: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jCalendarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jCalendarPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tomarValores();
        Date dia = jCalendarPanel1.getDate();        
        SeleccionarValores();
        d = new Dia(dia);
        d.insert();
        int n = SIRP.con.nSeleccionados("SELECT estado FROM registro.asistencia WHERE id_dia = '"+
                d.getId_dia()+"' AND id_mat = '"+
                id_mat.get(jComboBox3.getSelectedIndex())+"'");
        if (n == 0)
            ControlarAsistencia1();
        else
            ControlarAsistencia2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        verMaterias();
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void SeleccionarValores(){
        selectId_cur = Integer.parseInt(SIRP.con.ver("select id_cur from registro.curso where curso='"+jComboBox2.getSelectedItem()+"';", "id_cur"));
    }
    
    private void tomarValores(){ 
        curso = new ArrayList();
        id_cur = new ArrayList();
        ResultSet rs = 
        SIRP.con.listaResultados("SELECT DISTINCT(curso.id_cur),curso.curso,CONCAT(profesor.nombre,' ',profesor.apellido)profesor\n" +
                                "FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                                "ON profesor.id_pro = materia.id_pro AND materia.id_cur = curso.id_cur AND profesor.id_pro ='"+id_pro+"';");
        try {
            while(rs.next()){
                id_cur.add(rs.getInt("id_cur"));
                curso.add(rs.getString("curso"));
                profesor = rs.getString("profesor");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TomarLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void verCursos(){
        jComboBox2.removeAllItems();
        for(int i = 0;i<curso.size();i++){
            jComboBox2.addItem(""+curso.get(i));
        }
    }
    
    private void ControlarAsistencia1(){
        ListaAlumnos l = new ListaAlumnos(selectId_cur);
        List<Alumno> al = l.getAl();
        d.insert();
        int id_dia = d.getId_dia();
        for(int i = 0; i<al.size();i++){
            al.get(i).controlarAsistencia(id_dia, (int)(id_mat.get(jComboBox3.getSelectedIndex())));
        }
    }
    
    private void ControlarAsistencia2(){
        ListaAlumnos l = new ListaAlumnos(selectId_cur);
        List<Alumno> al = l.getAl();
        int id_dia = d.getId_dia();
        for(int i = 0; i<al.size();i++){
            al.get(i).updateAsistencia(id_dia, (int)(id_mat.get(jComboBox3.getSelectedIndex())));
        }        
    }
    
    private void verMaterias(){
        jComboBox3.removeAllItems();
        materia = new ArrayList();
        id_mat = new ArrayList();
        ResultSet rs = SIRP.con.listaResultados("SELECT materia.id_mat,materia.materia\n" +
                "FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                "ON profesor.id_pro = materia.id_pro AND materia.id_cur = curso.id_cur AND profesor.id_pro = '"+
                id_pro+"' AND curso.id_cur = '"+
                id_cur.get(jComboBox2.getSelectedIndex())+"'");
        try {
            while(rs.next()){            
                materia.add(rs.getString("materia"));
                id_mat.add(rs.getInt("id_mat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TomarLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0;i<materia.size();i++){
            jComboBox3.addItem(materia.get(i));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private de.wannawork.jcalendar.JCalendarPanel jCalendarPanel1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    private int id_pro;
    private List id_cur;
    private List curso;
    private List materia;
    private List id_mat;
    private String profesor;
    private int selectId_cur;
    private Dia d;
}
