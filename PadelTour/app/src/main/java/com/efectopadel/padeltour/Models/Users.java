package com.efectopadel.padeltour.Models;

public class Users {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String dni;
    private String fechaNacimiento;
    private String categoria;

    // Constructor vacío
    public Users() {}

    // Constructor completo
    public Users(String nombre, String apellido, String email, String telefono, String dni, String fechaNacimiento, String categoria) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getCategoria() {return categoria;    }
    public void setCategoria(String categoria) { this.categoria = categoria;   }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
}
