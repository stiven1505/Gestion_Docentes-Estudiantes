/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Registro {

    String nombre;
    String materia;
    String nombre_usuario;
    String contrasena;
    String nombreUsuarioEliminarEstudiante;
    String nombreUsuarioAgregar;
    String contrasenaAgregar;
    String grupoAgregar;
    String nombreAgregar;
    String programaAgregar;
    String nombreUsuarioEliminarDocente;
    
    public String getNombreUsuarioAgregar() {
        return nombreUsuarioAgregar;
    }

    public void setNombreUsuarioAgregar(String nombreUsuarioAgregar) {
        this.nombreUsuarioAgregar = nombreUsuarioAgregar;
    }

    public String getContrasenaAgregar() {
        return contrasenaAgregar;
    }

    public void setContrasenaAgregar(String contrasenaAgregar) {
        this.contrasenaAgregar = contrasenaAgregar;
    }

    public String getGrupoAgregar() {
        return grupoAgregar;
    }

    public void setGrupoAgregar(String grupoAgregar) {
        this.grupoAgregar = grupoAgregar;
    }

    public String getNombreAgregar() {
        return nombreAgregar;
    }

    public void setNombreAgregar(String nombreAgregar) {
        this.nombreAgregar = nombreAgregar;
    }

    public String getProgramaAgregar() {
        return programaAgregar;
    }

    public void setProgramaAgregar(String programaAgregar) {
        this.programaAgregar = programaAgregar;
    }

    public String getNombreUsuarioEliminarEstudiante() {
        return nombreUsuarioEliminarEstudiante;
    }

    public void setNombreUsuarioEliminarEstudiante(String nombreUsuarioEliminarEstudiante) {
        this.nombreUsuarioEliminarEstudiante = nombreUsuarioEliminarEstudiante;
    }
    

    public String getNombreUsuarioEliminarDocente() {
        return nombreUsuarioEliminarDocente;
    }

    public void setNombreUsuarioEliminarDocente(String nombreUsuarioEliminarDocente) {
        this.nombreUsuarioEliminarDocente = nombreUsuarioEliminarDocente;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Registro() {

    }

    
   

    
    

   
    public void eliminarEstudiante() throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM estudiante WHERE nombre_usuario='" + nombreUsuarioEliminarEstudiante + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
    }

    

    public void agregarEstudiante() throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO estudiante VALUES ('" + nombreUsuarioAgregar + "','" + contrasenaAgregar + "','" + nombreAgregar + "','" + grupoAgregar + "','" + programaAgregar + "')");
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
    }

    public void eliminarDocente() throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM docente WHERE nombre_usuario='" + nombreUsuarioEliminarDocente + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
    }
    public void registrarDocentes() throws SQLException {
        
        Conexionbd cc=new Conexionbd();
        Connection con = cc.conexion();
       

        try {
           
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO docente VALUES ('"+nombre_usuario+"','"+contrasena+"','"+nombre+"','"+materia+"')");
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }

    }
}
