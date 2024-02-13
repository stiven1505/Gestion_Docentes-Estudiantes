/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class Notas {

    String nombreUsuario;
    String grupo;

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public double promedio(double parcialUno, double parcialDos, double examenFinal, double notasVarias, double proyectoIntegrador) {
        double resultado = 0;

        resultado = ((parcialUno * 20) + (parcialDos * 20) + (examenFinal * 25) + (notasVarias * 15) + (proyectoIntegrador * 20)) / 100;

        return resultado;
    }

    public String promedioGeneral() throws SQLException {
        
        Grupo g=new Grupo();
        String gr = g.seleccion();
        
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        Statement pro = con.createStatement();
        ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + nombreUsuario + "' AND grupo = '"+gr+"' ");
        int i = 0;
        double n = 0;

        while (rs.next()) {
            i++;
            n = rs.getDouble("promedio") + n;
            

        }
        double resultado = n/i;
        String r = Double.toString(resultado);
     
        System.out.println(r);

return r;
    }

 public String promedioPrimerCorte() throws SQLException {

        
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        Statement pro = con.createStatement();
        ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + nombreUsuario + "' AND grupo = '"+grupo+"' ");
        int i = 0;
        double n = 0;

        while (rs.next()) {
            i++;
            n = rs.getDouble("primer_parcial") + n;
            

        }
        double resultado = n/i;
        String r = Double.toString(resultado);
     
        System.out.println(r);

return r;
 }
public String promedioSegundoCorte() throws SQLException {

        
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        Statement pro = con.createStatement();
        ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + nombreUsuario + "' AND grupo = '"+grupo+"' ");
        int i = 0;
        double n = 0;

        while (rs.next()) {
            i++;
            n = rs.getDouble("segundo_parcial") + n;
            

        }
        double resultado = n/i;
        String r = Double.toString(resultado);
     
        System.out.println(r);

return r;
}
public String promedioTercerCorte() throws SQLException {

 
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        Statement pro = con.createStatement();
        ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + nombreUsuario + "' AND grupo = '"+grupo+"' ");
        int i = 0;
        double n = 0;

        while (rs.next()) {
            i++;
            n = rs.getDouble("examen_final") + n;
            

        }
        double resultado = n/i;
        String r = Double.toString(resultado);
     
        System.out.println(r);

return r;
     

    }
}
