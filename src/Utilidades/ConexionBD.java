/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ConexionBD {

    String driver = "com.mysql.jdbc.Driver";

    String connectString = "jdbc:mysql://localhost:3306/e-commerce";

    String user = "root";
    String password = "";
    Connection con;

    public ConexionBD() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectString, user, password);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public Connection getConexion() {
        return con;
    }

//Hacer insert o update o delete
    public boolean ejecutarSql(String sql) {
        boolean guardo = false;
        try {

            Statement stmt = con.createStatement();
            guardo = stmt.execute(sql);

        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.print(e.getMessage());

        }
        return guardo;
    }

//Consultas
    public ResultSet ejecutarQuery(String sql) {
        ResultSet rs = null;
        try {

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(sql);

        } catch (Exception e) {
            // JOptionPane.showMessageDialog(null,e.getMessage());
            System.out.print(e.getMessage());
        }

        return rs;

    }

    public void cerrarConexion() throws SQLException {
        con.close();
    }

}
