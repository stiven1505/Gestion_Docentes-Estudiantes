/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Docente {

    String grupo;
    String nombre_usuario;

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setAdicionarParcialUno(double adicionarParcialUno) {
        this.adicionarParcialUno = adicionarParcialUno;
    }

    public void setAdicionarParcialDos(double adicionarParcialDos) {
        this.adicionarParcialDos = adicionarParcialDos;
    }

    public void setAdicionarExamenFinal(double adicionarExamenFinal) {
        this.adicionarExamenFinal = adicionarExamenFinal;
    }

    public void setAdicionarNotasVarias(double adicionarNotasVarias) {
        this.adicionarNotasVarias = adicionarNotasVarias;
    }

    public void setAdicionarProyectoIntegrador(double adicionarProyectoIntegrador) {
        this.adicionarProyectoIntegrador = adicionarProyectoIntegrador;
    }

    public void setAdicionarNombreUsuario(String adicionarNombreUsuario) {
        this.adicionarNombreUsuario = adicionarNombreUsuario;
    }

    

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public void setModificarTipo(String modificarTipo) {
        this.modificarTipo = modificarTipo;
    }

    public void setModificarNota(double modificarNota) {
        this.modificarNota = modificarNota;
    }

    public void setModificarNombre(String modificarNombre) {
        this.modificarNombre = modificarNombre;
    }

    public void setModificarNombreDocente(String modificarNombreDocente) {
        this.modificarNombreDocente = modificarNombreDocente;
    }

    public void setEliminarNombre(String eliminarNombre) {
        this.eliminarNombre = eliminarNombre;
    }

    public void setEliminarNombreDocente(String eliminarNombreDocente) {
        this.eliminarNombreDocente = eliminarNombreDocente;
    }

    public void Docente() {

    }

    

    double adicionarParcialUno;
    double adicionarParcialDos;
    double adicionarExamenFinal;
    double adicionarNotasVarias;
    double adicionarProyectoIntegrador;
    String adicionarNombreUsuario;

    public void adicionarNotas(Notas notas) throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();
        double r;
        r = notas.promedio(adicionarParcialUno, adicionarParcialDos, adicionarExamenFinal, adicionarNotasVarias, adicionarProyectoIntegrador);

        try {
            Statement mat = con.createStatement();
            ResultSet rs = mat.executeQuery("SELECT * FROM docente WHERE nombre_usuario ='" + nombre_usuario + "'");

            Statement grup = con.createStatement();
            ResultSet rss = grup.executeQuery("SELECT * FROM estudiante WHERE nombre_usuario ='" + adicionarNombreUsuario + "'");
            while (rs.next() && rss.next()) {
                String s = rs.getString("materia");
                String ss = rss.getString("grupo");
                Statement stmt = con.createStatement();
                stmt.executeUpdate("INSERT INTO notas VALUES(0,'" + adicionarParcialUno + "','" + adicionarParcialDos + "','" + adicionarExamenFinal + "','" + adicionarProyectoIntegrador + "','" + adicionarNotasVarias + "','" + r + "',  '" + adicionarNombreUsuario + "','" + nombre_usuario + "','" + s + "','" + ss + "') ");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
    }
    String modificarTipo;
    double modificarNota;
    String modificarNombre;
    String modificarNombreDocente;

    public void modificarNota(Notas notas) throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();
        double uno = 0;
        double dos = 0;
        double tres = 0;
        double cuatro = 0;
        double cinco = 0;
        double promedio;

        try {
            if (modificarTipo.equals("primer_parcial")) {
                Statement pro = con.createStatement();
                ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");
                while (rs.next()) {
                    dos = rs.getDouble("segundo_parcial");
                    tres = rs.getDouble("examen_final");
                    cuatro = rs.getDouble("notas_varias");
                    cinco = rs.getDouble("proyecto_integrador");
                }
                promedio = notas.promedio(modificarNota, dos, tres, cuatro, cinco);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE notas SET " + modificarTipo + "='" + modificarNota + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE notas SET promedio ='" + promedio + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

            }

            if (modificarTipo.equals("segundo_parcial")) {
                Statement pro = con.createStatement();
                ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");
                while (rs.next()) {
                    uno = rs.getDouble("primer_parcial");

                    tres = rs.getDouble("examen_final");
                    cuatro = rs.getDouble("notas_varias");
                    cinco = rs.getDouble("proyecto_integrador");
                }
                promedio = notas.promedio(uno, modificarNota, tres, cuatro, cinco);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE notas SET " + modificarTipo + "='" + modificarNota + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE notas SET promedio ='" + promedio + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

            }

            if (modificarTipo.equals("examen_final")) {
                Statement pro = con.createStatement();
                ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");
                while (rs.next()) {
                    uno = rs.getDouble("primer_parcial");
                    dos = rs.getDouble("segundo_parcial");

                    cuatro = rs.getDouble("notas_varias");
                    cinco = rs.getDouble("proyecto_integrador");
                }
                promedio = notas.promedio(uno, dos, modificarNota, cuatro, cinco);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE notas SET " + modificarTipo + "='" + modificarNota + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE notas SET promedio ='" + promedio + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

            }

            if (modificarTipo.equals("notas_varias")) {
                Statement pro = con.createStatement();
                ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");
                while (rs.next()) {
                    uno = rs.getDouble("primer_parcial");
                    dos = rs.getDouble("segundo_parcial");
                    tres = rs.getDouble("examen_final");

                    cinco = rs.getDouble("proyecto_integrador");
                }
                promedio = notas.promedio(uno, dos, tres, modificarNota, cinco);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE notas SET " + modificarTipo + "='" + modificarNota + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE notas SET promedio ='" + promedio + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

            }

            if (modificarTipo.equals("proyecto_integrador")) {
                Statement pro = con.createStatement();
                ResultSet rs = pro.executeQuery("SELECT * FROM notas WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");
                while (rs.next()) {
                    uno = rs.getDouble("primer_parcial");
                    dos = rs.getDouble("segundo_parcial");
                    tres = rs.getDouble("examen_final");
                    cuatro = rs.getDouble("notas_varias");

                }
                promedio = notas.promedio(uno, dos, tres, cuatro, modificarNota);
                Statement stmt = con.createStatement();
                stmt.executeUpdate("UPDATE notas SET " + modificarTipo + "='" + modificarNota + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

                Statement stm = con.createStatement();
                stm.executeUpdate("UPDATE notas SET promedio ='" + promedio + "' WHERE nombre_usuario_docente = '" + modificarNombreDocente + "' AND nombre_usuario_estudiante ='" + modificarNombre + "' ");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
    }

    String eliminarNombre;
    String eliminarNombreDocente;

    public void eliminarNota() throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        try {

            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE FROM notas WHERE nombre_usuario_estudiante='" + eliminarNombre + "' AND nombre_usuario_docente='" + eliminarNombreDocente + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }

    }

    String asistenciaGrupo;
    String asistenciaNombreUsuario;
    String asistenciaDocente;

    public void setAsistenciaDocente(String asistenciaDocente) {
        this.asistenciaDocente = asistenciaDocente;
    }

    public void setAsistenciaNombreUsuario(String asistenciaNombreUsuario) {
        this.asistenciaNombreUsuario = asistenciaNombreUsuario;
    }

    public void setAsistenciaGrupo(String asistenciaGrupo) {
        this.asistenciaGrupo = asistenciaGrupo;
    }

    public void asistencia(Asistencia asistencia) throws SQLException {
        Conexionbd cc = new Conexionbd();
        Connection con = cc.conexion();

        LocalTime hora = LocalTime.now();
        LocalDate fecha = LocalDate.now();
        String s = "";
        try {
            Statement mat = con.createStatement();
            ResultSet rs = mat.executeQuery("SELECT * FROM docente WHERE nombre_usuario ='" + asistenciaDocente + "'");
            while (rs.next()) {
                s = rs.getString("materia");

            }

        } catch (SQLException ex) {
            Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Nombre de usuario ya existente vuelva a intentarlo");
        }
        asistencia.llenarAsistencia(asistenciaNombreUsuario, asistenciaDocente, asistenciaGrupo, s, fecha, hora);

    }

}
