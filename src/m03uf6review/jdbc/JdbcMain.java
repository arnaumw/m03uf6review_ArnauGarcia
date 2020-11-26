/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03uf6review.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * En aquesta secció cal accedir a una taula de MySQL amb un camp de cada tipus:
 * 
 * int o long, double o float, boolean, char, String i java.sql.Date
 * 
 * Recòrrer el result set i mostrar-lo per la consola.
 * 
 * 
 * @author arnaugarciaalvarez
 */
public class JdbcMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
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
        
        Statement statement = con.createStatement();
        
        String consulta = "select * FROM jugadores";
        ResultSet r1 = statement.executeQuery(consulta);
        
        while(r1.next()){
            int idJugador = r1.getInt("idJugador");
            String nombreJugador = r1.getString("nombreJugador"); 
            double mediaPuntosJugador = r1.getDouble("mediaPuntosJugador");
            boolean campeonJugador = r1.getBoolean("campeonJugador");
            String equiposJugador = r1.getString("equiposJugador"); 
            Date nacimientoJugador = r1.getDate("nacimientoJugador");
            

            System.out.println("\n" + "Jugador " + idJugador + ": " + nombreJugador + " --> MediaPuntos: " + mediaPuntosJugador 
            + " --> Campeon Actual: " + campeonJugador + " --> Equipos en los que ha Jugado: " + equiposJugador 
            + " --> Fecha Nacimiento: " + nacimientoJugador);
        
        }
         
    }
    
}
