package com.efectopadel.padeltour.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "turnos")
public class Turno {
    @Id
    private String id;
    private int cancha;        // Número de cancha (ej: 1, 2, 3)
    private int horario;       // Número de bloque horario (ej: 1, 2, 3...)
    private String horaInicio; // Ejemplo: "08:00"
    private String horaFin;    // Ejemplo: "09:30"
    private String estado;     // Ej: "libre", "reservado"
    private String usuarioId;  // (opcional) Id del usuario que reservó este turno

    // Getters y setters

    public Turno() {}

    public Turno(int cancha, int horario, String horaInicio, String horaFin, String estado, String usuarioId) {
        this.cancha = cancha;
        this.horario = horario;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.usuarioId = usuarioId;
    }

    public String getId() {
        return id;
    }

    public int getCancha() {
        return cancha;
    }

    public void setCancha(int cancha) {
        this.cancha = cancha;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}