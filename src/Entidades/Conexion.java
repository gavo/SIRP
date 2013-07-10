package Entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection Conec;
    private Statement St;
    /*Creando la instania de conexion */

    public Conexion() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Conec = DriverManager.getConnection("jdbc:sqlserver://localhost:1433", "gavo", "vargas");

            if (Conec != null) {
                System.out.println();
                System.out.println("Successfully connected");
                System.out.println();
                System.out.println("\nDriver Information");
            }
        } catch (SQLException excepcionSql) {
            JOptionPane.showMessageDialog(null, excepcionSql.getMessage(), "Error en base de datos", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException claseNoEncontrada) {
            JOptionPane.showMessageDialog(null, claseNoEncontrada.getMessage(), "No se encontró el controlador", JOptionPane.ERROR_MESSAGE);
        }
    }
//Metodo de ejecucion de insert,update,delete a la base de datos

    public String ejecutar(String sql) {
        String error = "";
        try {
            St = Conec.createStatement();
            St.executeQuery("use colegio;"+sql);
        } catch (Exception ex) {
            error = ex.getMessage();
        }
        return (error);
    }

    //Metodo para las consultas a la base de datos
    public ResultSet consulta(String sql) {
        ResultSet res = null;    
        try {
            Statement s = Conec.createStatement();
            res = s.executeQuery("use colegio;"+sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }

    public int nSeleccionados(String consulta) {
        int n = 0;
        ResultSet rs = consulta(consulta);
        try {
            while (rs.next()) {
                n++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int ultimo(String tabla, String columna) {
        int n = 0;
        ResultSet rs = consulta("select Max(" + columna + ")" + columna + " from " + tabla);
        try {
            int aux = 0;
            while (rs.next()) {
                aux = rs.getInt(columna);
            }
            n += aux;
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public String ver(String consult, String columna) {
        String s = "";
        try {
            ResultSet rs = consulta(consult);
            while (rs.next()) {
                s = rs.getString(columna);
            }
        } catch (SQLException ex) {
            System.out.println("Error al ver datos: \n");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }
}
