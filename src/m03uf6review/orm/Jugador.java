/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03uf6review.orm;

import java.sql.Date;

/**
 *
 * @author arnaugarciaalvarez
 */
public class Jugador  {

    private int id;
    private String nombre;
    private double mediaPuntos;
    private boolean campeon;
    private String equipos;
    private Date nacimiento;

    public Jugador(int id, String nombre, double mediaPuntos, boolean campeon, String equipos, Date nacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.mediaPuntos = mediaPuntos;
        this.campeon = campeon;
        this.equipos = equipos;
        this.nacimiento = nacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMediaPuntos() {
        return mediaPuntos;
    }

    public void setMediaPuntos(double mediaPuntos) {
        this.mediaPuntos = mediaPuntos;
    }

    public boolean isCampeon() {
        return campeon;
    }

    public void setCampeon(boolean campeon) {
        this.campeon = campeon;
    }

    public String getEquipos() {
        return equipos;
    }

    public void setEquipos(String equipos) {
        this.equipos = equipos;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mediaPuntos=" + mediaPuntos + ", campeon=" + campeon + ", equipos=" + equipos + ", nacimiento=" + nacimiento + '}';
    }

    
}
