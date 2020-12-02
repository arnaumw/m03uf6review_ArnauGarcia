/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03uf6review.orm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 *
 * int o long, double o float, boolean, char, String i java.sql.Date
 *
 * Recòrrer el result set i mostrar-lo per la consola com a instancies de la
 * classe Registre, que tindrà l'estructura de la teva taula.
 *
 *
 * @author arnaugarciaalvarez
 */
public class OrmMain {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Jugador> ListaJugadores = new ArrayList();
    static Jugador j1;

    public static void main(String[] args) throws Exception {

        Connection c1 = ConexionBD();
        ResultSet r1 = ConsultaBD(c1);
        rellenaLista(r1);
        mostrarLista(ListaJugadores);

    }

    private static Connection ConexionBD() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3307/jugadores";
        String username = "root";
        String password = "";

        Connection con = DriverManager.getConnection(url, username, password);

        if (con != null) {
            System.out.println("Conexión correctamente realizada!");
        } else {
            System.out.println("Conexión fallida...");
        }

        return con;
    }

    private static ResultSet ConsultaBD(Connection c1) throws Exception {

        Statement statement = c1.createStatement();
        String consulta = "select * FROM jugadores";

        ResultSet r1 = statement.executeQuery(consulta);

        return r1;
    }

    private static void rellenaLista(ResultSet r1) throws Exception {
        while (r1.next()) {

            int idJugador = r1.getInt("idJugador");
            String nombreJugador = r1.getString("nombreJugador");
            double mediaPuntosJugador = r1.getDouble("mediaPuntosJugador");
            boolean campeonJugador = r1.getBoolean("campeonJugador");
            String equiposJugador = r1.getString("equiposJugador");
            Date nacimientoJugador = r1.getDate("nacimientoJugador");

            Jugador j1 = new Jugador(idJugador, nombreJugador, mediaPuntosJugador, campeonJugador, equiposJugador, nacimientoJugador);
            ListaJugadores.add(j1);
        }
    }

    private static void mostrarLista(ArrayList<Jugador> ListaJugadores) {
        
        for (int i = 0; i < ListaJugadores.size(); i++) {
            
            System.out.println(ListaJugadores.get(i));
            
        }
    }

}
