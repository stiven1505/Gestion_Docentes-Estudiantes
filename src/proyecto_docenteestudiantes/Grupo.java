/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_docenteestudiantes;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Grupo {
    
    String grupoo;
           

    public String getGrupo() {
        return grupoo;
    }

    public void setGrupo(String grupo) {
        this.grupoo = grupo;
    }

    public Grupo() {
        
    }

    public String seleccion (){
        grupoo=JOptionPane.showInputDialog(null, "Digite el grupo que desea ingresar:");
        return grupoo;
    }
    

   
  
    
            
    
    
    
    
}
