package Practica5_gualpamathias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Competencia {
    ArrayList<Atleta> listaAtletas = new ArrayList<>();
    Conexion.Conexion con = new Conexion.Conexion();

    public void registro(double tiempo, String nombr_atleta, String Pais) {
        Atleta nuevoAtleta = new Atleta(tiempo, nombr_atleta, Pais);
        listaAtletas.add(nuevoAtleta);

        try {
            Connection conexionDB = con.conexion();
            String query = "INSERT INTO Atletas (tiempo, nombr_atleta, Pais) VALUES (?, ?, ?)";
            PreparedStatement pst = (PreparedStatement) conexionDB.prepareStatement(query);
            pst.setDouble(1, tiempo);
            pst.setString(2, nombr_atleta);
            pst.setString(3, Pais);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atleta registrado y guardado en la base de datos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar en la base de datos: " + e.getMessage());
        }
    }

    public String obtenerDatosGanador() {
        if (listaAtletas.isEmpty()) {
            return "No hay atletas registrados";
        }

        Atleta ganador = listaAtletas.get(0);
        for (Atleta atleta : listaAtletas) {
            if (atleta.tiempo < ganador.tiempo) {
                ganador = atleta;
            }
        }

        return "El Ganador es:\nNombre: " + ganador.nombr_atleta + "\nNacionalidad: " + ganador.Pais + "\nTiempo: " + ganador.tiempo;
    }

    public String obtenerAtletasPorPais(String pais) {
        if (listaAtletas.isEmpty()) {
            return "No hay atletas registrados";
        }

        StringBuilder resultado = new StringBuilder("Atletas de " + pais + ":\n");
        for (Atleta atleta : listaAtletas) {
            if (atleta.Pais.equalsIgnoreCase(pais)) {
                resultado.append("Nombre: ").append(atleta.nombr_atleta).append("\nTiempo: ").append(atleta.tiempo).append("\n");
            }
        }
        return resultado.toString();
    }

    public String obtenerPromedioTiempo() {
        if (listaAtletas.isEmpty()) {
            return "No hay atletas registrados";
        }

        double Ttiem = 0;
        for (Atleta atleta : listaAtletas) {
            Ttiem += atleta.tiempo;
        }

        double tiempro = Ttiem / listaAtletas.size();
        return "El tiempo promedio de los atletas es: " + tiempro;
    }

    public String eliminarAtleta(String nombre) {
        if (listaAtletas.isEmpty()) {
            return "No hay atletas registrados";
        }

        for (Atleta atleta : listaAtletas) {
            if (atleta.nombr_atleta.equalsIgnoreCase(nombre)) {
                listaAtletas.remove(atleta);

                try {
                    Connection conexionDB = con.conexion();
                    String query = "DELETE FROM Atletas WHERE nombr_atleta = ?";
                    PreparedStatement pst = (PreparedStatement) conexionDB.prepareStatement(query);
                    pst.setString(1, nombre);
                    pst.executeUpdate();
                    return "Atleta eliminado con éxito de la base de datos";
                } catch (SQLException e) {
                    return "Error al eliminar de la base de datos: " + e.getMessage();
                }
            }
        }
        return "No se encontró un atleta con ese nombre";
    }

    public String obtenerDatosAtletas() {
        if (listaAtletas.isEmpty()) {
            return "No hay atletas registrados";
        }

        StringBuilder resultado = new StringBuilder("Todos los atletas registrados son:\n");
        
        for (Atleta atleta : listaAtletas) {
            resultado.append("Nombre: ").append(atleta.nombr_atleta).append("\nNacionalidad: ").append(atleta.Pais)
                    .append("\nTiempo: ").append(atleta.tiempo).append("\n");
        }
        return resultado.toString();
    }
    
}