/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.ArregloAlumnos;
/**
 *
 * @author cubas
 */
public class Alumno extends Usuario {
    private int DNI;
    private String correo;
    private Facultad facultad; 
    

    public Alumno(int DNI, String correo, String contrasena, String nombres, String apellidos, String codigo, Facultad facultad) {
            
            super(contrasena, nombres, apellidos, codigo);
            this.DNI = DNI;
            this.correo = correo;
            this.facultad = facultad;
        
        
    }

 
    public Alumno(String contrasena, String codigo) {
        super(contrasena, codigo);
    }
  
  
    public void solicitarContraseña(){
             System.out.println("--------------------------------------------");
             System.out.println("Su contraseña es : "+getContraseña());
             System.out.println("--------------------------------------------");
    }
    public void cambiarContraseña(String nuevaContraseña){
              this.contrasena = nuevaContraseña;
    }

    public int getDNI() {
        return DNI;
    }

    public String getCorreo() {
        return correo;
    }
    
    @Override
    public String toString() {
        return "Alumno{"+"\n"+ "DNI=" + DNI + "\n"+ 
                "correo=" + correo + "\n"+ 
       //         "contraseña="+ this.getContraseña()+ "\n"+ 
                "codigo=" + this.getCodigo() + "\n"+ 
                "apellidos=" + this.getApellidos() + "\n"+ 
                "nombres=" + this.getNobmres()+ "\n"+ 
                "-------------------------------------------------"+ "\n"+
                '}';
    }
    
    
}
