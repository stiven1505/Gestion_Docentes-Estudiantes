/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

//import pk01.Grupo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Usuario  {

    String nombre_usuario;
    String contrasena;
    String rol;
    String group;

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario() {
        
    }

    public void validacion() throws SQLException {
        
       
        
        InicioEstudiante inicioEstudiante = new InicioEstudiante();
        InicioDocente inicioDocente = new InicioDocente();
        InicioAdmin inicioAdmin = new InicioAdmin();
        Inicio inicioo = new Inicio();

        int consulta = 0;
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();
          
        Docente doc = new Docente();
        
        
         if (rol.equals("admin")) {
            
           
            
           
            
            String SQL = "select * from admin where nombre_usuario='" + nombre_usuario + "' AND contrasena = '" + contrasena + "'";
            try {

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(SQL);

                if (rs.next()) {
                    consulta = 1;
                    if (consulta == 1) {
                        
                        inicioAdmin.setVisible(true);
                        inicioAdmin.setNombre1(nombre_usuario);
                        
                       
                        

                    }
                } else {
                   JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña son incorrectas \n                     Vuelva a intentar");
                  
                    inicioo.setVisible(true);
                }

            } catch (Exception e) {
            }
        }
 
        if (rol.equals("docente")) {
            
           
            
           
            
            String SQL = "select * from docente where nombre_usuario='" + nombre_usuario + "' AND contraseña = '" + contrasena + "'";
            try {

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(SQL);

                if (rs.next()) {
                    consulta = 1;
                    if (consulta == 1) {
                        
                        inicioDocente.setVisible(true);
                        inicioDocente.setNombre1(nombre_usuario);
                        
                       
                        

                    }
                } else {
                   JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña son incorrectas \n                     Vuelva a intentar");
                  
                    inicioo.setVisible(true);
                }

            } catch (Exception e) {
            }
        }

        if (rol.equals("estudiante")) {

            String SQL = "select * from estudiante where nombre_usuario='" + nombre_usuario + "' AND contraseña = '" + contrasena + "'";
            try {

                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(SQL);

                if (rs.next()) {
                    consulta = 1;
                    if (consulta == 1) {
                        
                        inicioEstudiante.setVisible(true);
                        inicioEstudiante.setNombre(nombre_usuario);

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña son incorrectas \n                     Vuelva a intentar");
                    inicioo.setVisible(true);
                }

            } catch (Exception e) {
            }
        }

    }

}
