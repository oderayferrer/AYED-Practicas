/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1.ejercicio3;

/**
 *
 * @author Oderay
 */
public class MainEjercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                int cantp =3;
        int cante =2;

        Estudiante[] estudiantes = new Estudiante[cante];
        
        estudiantes[0] = new Estudiante("Oderay","Ferrer","A","oderay@mail.com","50 885");
        estudiantes[1]= new Estudiante("Angeles","Bourdette","A","angeles@mail.com","12 345");
        
        Profesor[] profesores = new Profesor[cantp];
        profesores[0] = new Profesor("Pedro","Diaz","pedro@mail.com","AYED","Informatica unlp");
        profesores[1] = new Profesor("Laura","Fernandez","laura@mail.com","AYED","Informatica unlp");
        profesores[2] = new Profesor("Pablo","Sanchez","pablo@mail.com","Taller","Informatica unlp");
        
        for(int i =0; i<cante; i++){
            System.out.println(estudiantes[i].tusDatos(estudiantes[i]));
            
        }
        for(int i =0; i<cantp; i++){
            System.out.println(profesores[i].tusDatos(profesores[i]));
        }
        
    }
    
}
