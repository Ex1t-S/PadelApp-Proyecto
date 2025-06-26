package com.efectopadel.padeltour.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String nombre;
    private String apellido ;
    private String email;
    private String contraseña;
    private String categoria;      // Nuevo campo
    private String telefono;   // Nuevo campo

    // --- Constructores ---
    public User() {}

    public User(String firstName, String lastName, String email, String password, String category, String phoneNumber) {
        this.nombre = firstName;
        this.apellido = lastName;
        this.email = email;
        this.contraseña = password;
        this.categoria = category;
        this.telefono = phoneNumber;
    }

    // --- Getters y Setters ---
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
