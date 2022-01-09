/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import modelo.*;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author cubas
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //TODO LO QUE SE ESTA ELABORANDO HASTA AHORA ES TEMPORAL Y ESTA SUJETA A CAMBIOS, SOLO ES PARA PROBAR EL PROGRAMA 
        System.out.println("\n\nProbando Sistema, de momento se crean 3 alumnos registrados automaticamente, luego"
                + "\nse puede colocar un codigo y contraseña para validar si ese alumno esta en los registros");
        System.out.println("----------------------------------------------------------------------------------------");
        Date fechatest;
        fechatest = new Date();
        Facultad facultadtest;  //La clase facultad le pertenece a la clase alumno
        facultadtest = new Facultad("FISI");

        //Se crea un arreglo de Alumnos:
        ArregloAlumnos alumnosregistrados;

        //Se crea el sistema
        //..............
        Sistema sistema;

        //Se crean las clases que necesita el sistema, las cuales son: 
        ArregloFecha fechasSistema;
        ArregloTurno turnosSistema;
        ArregloAlumnos alumnosRegistrados;
        CabeceraTicket ticketsdelsistema;
        ticketsdelsistema = null;
        fechasSistema = new ArregloFecha();
        turnosSistema = new ArregloTurno();
        alumnosRegistrados = new ArregloAlumnos(3); //3 para probar el sistema
        Operario operarioregistradounico; //Este operario sera el que este registrado de momento
        operarioregistradounico = new Operario(fechatest, "contraop", "nombreop", "appelidoop", "codigoop");

        Alumno alumnoadd;//Esta clase alumnoadd sera para añadir los alumnos al arreglo de alumnos, que esta dentro de la clase sistema 

        alumnoadd = new Alumno(1111, "correo1", "contra1", "nombres1", "apellidos1", "codigo1", facultadtest);
        alumnosRegistrados.agregarAlumno(alumnoadd);

        alumnoadd = new Alumno(2222, "correo2", "contra2", "nombres2", "apellidos2", "codigo2", facultadtest);
        alumnosRegistrados.agregarAlumno(alumnoadd);

        alumnoadd = new Alumno(3333, "correo3", "contra3", "nombres3", "apellidos3", "codigo3", facultadtest);
        alumnosRegistrados.agregarAlumno(alumnoadd);

        //Terminamos de crear el sistema
        sistema = new Sistema(true, fechasSistema, turnosSistema, alumnosRegistrados, operarioregistradounico);

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("\tLos alumnos que tiene el sistema son:\n" + alumnosRegistrados);
        System.out.println("************************************************************************************************");
        System.out.println("\tEl operario de este sistema es:\n" + operarioregistradounico);
        System.out.println("------------------------------------------------------------------------------------------------");
        //Ahora que ya creamos el sistema, con sus arreglos adentro, pasamos a la parte de logearse 

        //Menu para seleccionar si se trata de un usuario o un operario
        int op1;

        do {

            System.out.println("\tEscoja una Opción");
            System.out.println(" 1.- Acceder como Alumno\n 2.- Acceder como Operario\n 3.- Salir del Sistema");

            op1 = teclado.nextInt();

            switch (op1) {

                case 2://Operario
                    String codigo;
                    String contraseña;
                    System.out.println("------------------------------------------------");
                    System.out.println("Ingrese su codigo: ");
                    codigo = teclado.next();
                    System.out.println("Ingrese su contraseña: ");
                    contraseña = teclado.next();
                    System.out.println("------------------------------------------------");
                    if (sistema.validarlogdeoperario(codigo, contraseña) == true) {

                        System.out.println("Usted es un operario, y si esta registrado");
                        int op2;
                        Operario operariotest;

                        operariotest = operarioregistradounico;

                        do {

                            System.out.println("0.-Cerrar sesion y volver al menu principal\n1.-Registrar un alumno\n2.-Validar un ticket\n3.-Cambiar las raciones por turno"
                                    + "\n4.-Crear una fecha para generar los tickets\n5.-Mostrar los alumnos registrados\n6.-Mostrar todos los tickets");

                            op2 = teclado.nextInt();
                            switch (op2) {

                                case 1:
                                    System.out.println("Digite los datos del alumno a agregar,"
                                            + "DNI,correo,contraseña,nombres,apellidos, y codigo la facultad por defecto es FISI:");
                                    //int DNI, String correo, String contrasena, String nombres, String apellidos, String codigo, Facultad facultad
                                    int DNIadd;
                                    String correoadd,
                                     contrasenaadd,
                                     nombreadd,
                                     apellidosadd,
                                     codigoadd;
                                    DNIadd = teclado.nextInt();
                                    correoadd = teclado.next();
                                    contrasenaadd = teclado.next();
                                    nombreadd = teclado.next();
                                    apellidosadd = teclado.next();
                                    codigoadd = teclado.next();

                                    alumnoadd = new Alumno(DNIadd, correoadd, contrasenaadd, nombreadd, apellidosadd, codigoadd, facultadtest);

                                    operariotest.registrarAlumno(alumnoadd, alumnosRegistrados);

                                    break;

                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:
                                    Fecha fechagenerada;
                                    fechagenerada = operariotest.crearFechaParaTickets();

                                    System.out.println("Ingrese los datos de los tickets");
                                    int numeronivel,
                                     numeroturno;
                                    String intervaloturno,
                                     alimentoname;

                                    Nivel nivel;
                                    Turno turno;
                                    Alimento alimento;

                                    System.out.println("Digite el nivel:");

                                    numeronivel = teclado.nextInt();
                                    nivel = new Nivel(numeronivel);

                                    System.out.println("Datos del turno:");

                                    System.out.println("  Ingrese el numero del turno:");
                                    numeroturno = teclado.nextInt();
                                    teclado.nextLine();

                                    System.out.println("  Ingrese el intervalo del turno:");
                                    intervaloturno = teclado.nextLine();

                                    turno = new Turno(numeroturno, intervaloturno);

                                    System.out.println("Digite el alimento:");

                                    alimentoname = teclado.nextLine();
                                    alimento = new Alimento(alimentoname);

                                    CabeceraTicket ticketsgeneradosporop;
                                    // ticketsgeneradosporop = new CabeceraTicket(333, nivel, turno, alimento, fechagenerada);
                                    ticketsgeneradosporop = fechagenerada.creartickets(nivel, turno, alimento, fechagenerada);

                                    sistema.setTicketscreadosconfecha(ticketsgeneradosporop);

                                    System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
                                    System.out.println(ticketsgeneradosporop);
                                    System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------");

                                    //CabeceraTicket(Sistema.racionestotalesporturno, nivel, turno, alimento, fecha); 
                                    break;
                                case 5:
                                    System.out.println("Los alumnos que tiene el sistema son\n" + alumnosRegistrados);
                                    break;
                                case 0:

                                    break;

                            }
                        } while (op2 != 0);

                    } else {
                        System.out.println("No esta registrado");

                    }

                    break;

                case 3:
                    System.out.println("ADIOS");
                    System.exit(0);
                    break;

                case 1: //Alumno

                    System.out.println("------------------------------------------------");
                    System.out.println("Ingrese su codigo: ");
                    codigo = teclado.next();
                    System.out.println("Ingrese su contraseña: ");
                    contraseña = teclado.next();
                    System.out.println("------------------------------------------------");
                    int opa;

                    Alumno alumnotest,
                     alumnotemp; //La clase alumnotest, servira para crearse con un constructor que solo requiere contraseña  y codigo para poder usar el metodo que esta en usuario llamado logearse

                    alumnotest = new Alumno(contraseña, codigo);

                    if (alumnotest.logearse(contraseña, codigo, sistema.getAlumnosRegistrados()) == true) {

                        System.out.println("Si esta registrado");

                        do {
                            System.out.println("El alumno es: ");

                            alumnotemp = sistema.getAlumnosRegistrados().devolverAlumno(codigo);  //Esto devuelve el alumno que coincide con el codigo
                            alumnotest = alumnotemp;
                            System.out.println(alumnotest);
                            System.out.println("\n0.-Cerrar sesion y volver al menu principal\n1.-Solicitar ticket\n2.-Cambiar contraseña\n3Mostrar sus datos");
                            opa = teclado.nextInt();
                            
                            System.out.println("El opa es: "+opa);
                            
                            
                            
                            
                            switch (opa) {  //Menu del alumno
                                case 1:
                                    sistema.asignarTicket(alumnotest);
                                    System.out.println("Alumno asignado");
                                    System.out.println(sistema.getTicketscreadosconfecha());
                                    break;
                                case 2:
                                    String newcontra;
                                    System.out.println("Digite su nueva contraseña");
                                    newcontra = teclado.next();
                                    alumnotest.setContrasena(newcontra);

                                    break;
                                
                                case 3:
                                    System.out.println("Todos sus datos son:");
                                    System.out.println(alumnotest);
                                    break;
                                case 4:

                                    break;
                                case 0:

                                    break;
                            }
                        } while (opa != 0);
                    } else {
                        System.out.println("No esta registrado");
                    }

                    break;

            }

        } while (op1 != 3);

    }

}
