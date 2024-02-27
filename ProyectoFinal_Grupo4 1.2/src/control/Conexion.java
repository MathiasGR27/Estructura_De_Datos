/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;
import org.bson.Document;

public class Conexion {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;
    private final String server = "localhost";
    private final int puerto = 27017;

    public MongoClient crearConexion() {
        try {
            MongoClientURI uri = new MongoClientURI("mongodb://" + server + ":" + puerto);
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDatabase("Login");
            collection = database.getCollection("inicio");
             
        } catch (MongoException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + e.toString());
        }
        return mongoClient;
    }

    public void cerrarConexion() {
        if (mongoClient != null) {
            mongoClient.close();
            JOptionPane.showMessageDialog(null, "Conexión cerrada");
        }
    }
}
