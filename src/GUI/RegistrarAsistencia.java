package GUI;

import Main.SIRP;
import Entidades.Dia;
import Entidades.ListaAlumnos;
import Entidades.Alumno;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class RegistrarAsistencia extends javax.swing.JFrame {
    public RegistrarAsistencia(int id_pro) {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Control de Asistencia");        
        this.id_pro = id_pro;
        verCursos();
        verMaterias();
        comprobarEstado();
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
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Control de Asistencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(modelo);
        jTable1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTable1);

        jCalendarComboBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCalendarComboBox1StateChanged(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Curso");

        jLabel2.setText("Materia");

        jButton1.setText("Tomar Asistencia");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox1, 0, 143, Short.MAX_VALUE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jComboBox2, 0, 142, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCalendarComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(5, 5, 5)))
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
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jLabel3});

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
        comprobarEstado();
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tomarValores();
        d.insert();
        String sql = "SELECT estado FROM registro.asistencia WHERE id_dia ='"+
                d.getId_dia()+"' AND id_mat ='"+
                id_mat.get(jComboBox2.getSelectedIndex())+"';";
        int n = SIRP.con.nSeleccionados(sql);
        if(n == 0){
            insertarValores();
        }else{
            updateValores();
        }
        comprobarEstado();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jCalendarComboBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCalendarComboBox1StateChanged
        comprobarEstado();
    }//GEN-LAST:event_jCalendarComboBox1StateChanged
    private void verCursos(){
        curso = new ArrayList();
        id_cur = new ArrayList();
        String sql ="SELECT curso.curso, curso.id_cur FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                    "ON profesor.id_pro = materia.id_pro AND curso.id_cur = materia.id_cur AND profesor.id_pro = '"+
                    id_pro+"' GROUP BY curso ORDER BY id_cur;";
        ResultSet rs = SIRP.con.listaResultados(sql);
        try {
            while(rs.next()){            
                curso.add(rs.getString("curso"));
                id_cur.add(rs.getInt("id_cur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
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
        String sql ="SELECT materia.id_mat,materia.materia\n" +
                    "FROM registro.profesor INNER JOIN registro.materia INNER JOIN registro.curso\n" +
                    "ON profesor.id_pro = materia.id_pro AND materia.id_cur = curso.id_cur AND profesor.id_pro = '"+
                    id_pro+"' AND curso.id_cur = '"+
                    id_cur.get(jComboBox1.getSelectedIndex())+"'";
        ResultSet rs = SIRP.con.listaResultados(sql);
        try {
            while(rs.next()){            
                materia.add(rs.getString("materia"));
                id_mat.add(rs.getInt("id_mat"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistrarAsistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i = 0;i<materia.size();i++){
            jComboBox2.addItem(materia.get(i));
        }        
    }
    private void configurarTabla(){
        modelo.setRowCount(0);
        modelo.setColumnCount(0);  
        modelo.addColumn("Nº");
        modelo.addColumn("Alumno");
        modelo.addColumn("Estado");
        ListaAlumnos l = new ListaAlumnos((int)id_cur.get(jComboBox1.getSelectedIndex()));
        alumnos = l.getAl();
        for(int i =0;i<alumnos.size();i++){
            Object row[]= new Object[3];
            row[0]=(i+1);
            row[1]=alumnos.get(i).getNombre()+" "+alumnos.get(i).getApellido();
            row[2]="Presente";
            modelo.addRow(row);
        }
        JComboBox combo = CreameCombo();//CREO EL COMBO
        TableColumn col0 = jTable1.getColumnModel().getColumn(0);
        col0.setMaxWidth(30);
        col0.setMinWidth(30);
        TableColumn col = jTable1.getColumnModel().getColumn(2);        
        col.setMaxWidth(100);
        col.setMinWidth(100);
        col.setResizable(true);
        col = jTable1.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(combo));//AGREGO EL COMBO AL CELLEDITOR
        jTable1.setAutoCreateRowSorter(true);
    }    
    private JComboBox CreameCombo() {
	JComboBox combo = new JComboBox(new String[] {"Presente", "Licencia",  "Falta"}) {
            @Override public void updateUI() {
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
        for(int i = 0;i<modelo.getRowCount();i++){
            String nombre = (String)(modelo.getValueAt(i, 1));
            String estado  = (String)(modelo.getValueAt(i, 2)); 
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
    private void comprobarEstado(){
        tomarValores();
        String sql = "SELECT estado FROM registro.asistencia WHERE id_dia ='"+
                d.getId_dia()+"' AND id_mat ='"+
                id_mat.get(jComboBox2.getSelectedIndex())+"';";
        int n = SIRP.con.nSeleccionados(sql);
        if(n==0){
            jLabel3.setText("No se ha tomado Lista");
            jLabel3.setForeground(Color.red);       
            for(int i = 0;i<alumnos.size();i++){
                modelo.setValueAt("Presente", i, 2);
            }
        }else{
            jLabel3.setText("Ya se tomo lista");
            jLabel3.setForeground(Color.GREEN);
            for(int i = 0;i<alumnos.size();i++){
                String cons = "SELECT `estado` FROM `registro`.`asistencia` WHERE `id_dia` = '"+
                        d.getId_dia()+"' AND `id_alu` = '"+
                        alumnos.get(i).getId()+"' AND `id_mat` = '"+
                        id_mat.get(jComboBox2.getSelectedIndex())+"';";
                String temp = (transValor(SIRP.con.ver(cons, "estado")));
                modelo.setValueAt(temp, i, 2);
            }
            
        }
    }
    private String transValor(String s){
        String r = "";
        if(s.equals("P"))
            r+="Presente";
        else{
            if(s.equals("L"))
                r+="Licencia";
            else
                r+="Falta";
        }
        return r;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private de.wannawork.jcalendar.JCalendarComboBox jCalendarComboBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
