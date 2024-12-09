import java.util.ArrayList;
import java.util.Scanner;

class Equipo {
    public String nombre;
    public String entrenador;
    public ArrayList<String> jugadores;

    public Equipo(String nombre, String entrenador) {
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.jugadores = new ArrayList<>();
    }

    public void agregarJugador(String jugador) {
        jugadores.add(jugador);
    }

    public void mostrarEquipo() {
        System.out.println("Equipo: " + nombre);
        System.out.println("Entrenador: " + entrenador);
        System.out.println("Jugadores: " + jugadores);
    }
}

class Partido {
    public String equipo1;
    public String equipo2;
    public String fecha;
    public String resultado;

    public Partido(String equipo1, String equipo2, String fecha, String resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.resultado = resultado;
    }

    public void mostrarPartido() {
        System.out.println("Partido: " + equipo1 + " vs " + equipo2);
        System.out.println("Fecha: " + fecha);
        System.out.println("Resultado: " + resultado);
    }
}

public class GestionTorneos {
    public ArrayList<Equipo> equipos;
    public ArrayList<Partido> partidos;

    public GestionTorneos() {
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void registrarEquipo(Equipo equipo) {
        equipos.add(equipo);
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public void listarEquipos() {
        System.out.println("\nEquipos Registrados:");
        for (Equipo equipo : equipos) {
            equipo.mostrarEquipo();
        }
    }

    public void listarPartidos() {
        System.out.println("\nHistorial de Partidos:");
        for (Partido partido : partidos) {
            partido.mostrarPartido();
        }
    }

    public static void main(String[] args) {
        GestionTorneos gestion = new GestionTorneos();
        Scanner scanner = new Scanner(System.in);

        // Registro de Equipos
        System.out.println("Registro de Equipos:");
        for (int i = 1; i <= 4; i++) {
            System.out.print("Ingrese el nombre del equipo " + i + ": ");
            String nombreEquipo = scanner.nextLine();

            System.out.print("Ingrese el nombre del entrenador del equipo " + i + ": ");
            String entrenador = scanner.nextLine();

            Equipo equipo = new Equipo(nombreEquipo, entrenador);

            System.out.println("Ingrese los nombres de los 5 jugadores del equipo " + nombreEquipo + ":");
            for (int j = 1; j <= 5; j++) {
                System.out.print("Jugador " + j + ": ");
                String jugador = scanner.nextLine();
                equipo.agregarJugador(jugador);
            }

            gestion.registrarEquipo(equipo);
        }

        // Registro de Partidos
        System.out.println("\nRegistro de Partidos:");
        System.out.print("¿Cuántos partidos desea registrar? ");
        int numPartidos = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        for (int i = 1; i <= numPartidos; i++) {
            System.out.println("\nPartido " + i + ":");
            System.out.print("Ingrese el nombre del primer equipo: ");
            String equipo1 = scanner.nextLine();

            System.out.print("Ingrese el nombre del segundo equipo: ");
            String equipo2 = scanner.nextLine();

            System.out.print("Ingrese la fecha del partido (dd/mm/aaaa): ");
            String fecha = scanner.nextLine();

            System.out.print("Ingrese el resultado del partido (Ejemplo: 2-1): ");
            String resultado = scanner.nextLine();

            Partido partido = new Partido(equipo1, equipo2, fecha, resultado);
            gestion.registrarPartido(partido);
        }

        // Mostrar Equipos Registrados
        gestion.listarEquipos();

        // Mostrar Partidos Registrados
        gestion.listarPartidos();

        scanner.close();
    }
}
