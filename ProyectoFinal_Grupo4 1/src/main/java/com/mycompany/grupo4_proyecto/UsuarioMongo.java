/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo4_proyecto;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import control.Conexion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import org.bson.Document;

/**
 *
 * @author HOME
 */
public class UsuarioMongo {
    
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public UsuarioMongo() {
        Conexion conexion = new Conexion();
        database = conexion.crearConexion().getDatabase("Login");
        collection = database.getCollection("inicio");
    }

    public boolean verificarCredenciales(String usuario, String contrasenia) {
        Document query = new Document("usuario", usuario)
                .append("contrasenia", contrasenia);

        return collection.countDocuments(query) > 0;
    }

    public boolean verificarExistenciaUsuario(String usuario) {
        Document query = new Document("usuario", usuario);
        return collection.countDocuments(query) > 0;
    }

    public boolean registrarUsuario(String usuario, String contrasenia) {
        // Verificar restricciones: usuario en minúsculas, contraseña con máximo 10 caracteres
        if (usuario.matches("^[a-z]+$") && contrasenia.length() <= 10) {
            if (!verificarExistenciaUsuario(usuario)) {
                Document usuarioNuevo = new Document("usuario", usuario)
                        .append("contrasenia", contrasenia);
                collection.insertOne(usuarioNuevo);
                return true; // Registro exitoso
            } else {
                JOptionPane.showMessageDialog(null, "El usuario ya existe. Por favor, elige otro nombre de usuario.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario. Asegúrate de que el usuario sea en minúsculas y la contraseña tenga máximo 10 caracteres.");
        }
        return false; // Registro no exitoso
    }
}