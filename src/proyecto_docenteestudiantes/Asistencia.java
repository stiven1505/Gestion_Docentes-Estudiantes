/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Usuario
 */
public class Asistencia {

    public void llenarAsistencia(String NombreUsuario,String Docente,String grupo, String materia,LocalDate fecha, LocalTime hora) throws SQLException {
        
          Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();
         Statement stmt = con.createStatement();
         stmt.executeUpdate("INSERT INTO asistencia VALUES (0,'"+NombreUsuario+"','"+Docente+"','"+grupo+"','"+materia+"','"+fecha+"','"+hora+"')");
    }
}
