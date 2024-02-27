/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package u2practica2_burbujanombres;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class U2Practica2_BurbujaNombres extends JFrame {

    private JTextField nombreTextField;
    private DefaultTableModel modeloTabla;

    public U2Practica2_BurbujaNombres() {
        // Configurar la ventana principal
        setTitle("Formulario de Nombres"); //nombre del formulario
        setSize(500, 400); //tamaño del formulario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //crear el formilario
        setLocationRelativeTo(null);

        // Crear componentes del formulario
        nombreTextField = new JTextField(20); //tamaño de la tabla
        JButton agregarNombreButton = new JButton("Agregar Nombre"); //boton agregar
        JButton ordenarNombresButton = new JButton("Ordenar Nombres");//boton ordenar

        // Configurar la tabla
        modeloTabla = new DefaultTableModel(); //crea tablaaa
        modeloTabla.addColumn("Nombres");//nombre de la tabla

        JTable tablaNombres = new JTable(modeloTabla);///crea tablaaa 
        JScrollPane scrollPane = new JScrollPane(tablaNombres);

        // Configurar el diseño del formulario
        setLayout(new BorderLayout());
        JPanel panelFormulario = new JPanel(new FlowLayout());
        panelFormulario.add(nombreTextField);
        panelFormulario.add(agregarNombreButton);
        panelFormulario.add(ordenarNombresButton);

        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar acciones de los botones
        agregarNombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNombre();
            }
        });

        ordenarNombresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNombres();
            }
        });
    }

    private void agregarNombre() {
        String nombre = nombreTextField.getText().trim();
        if (!nombre.isEmpty()) {
            modeloTabla.addRow(new Object[]{nombre});
            nombreTextField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un nombre", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ordenarNombres() {
        int filas = modeloTabla.getRowCount();
        String[] nombres = new String[filas];

        for (int i = 0; i < filas; i++) {
            nombres[i] = (String) modeloTabla.getValueAt(i, 0);
        }

        // Ordenar los nombres alfabéticamente
        Arrays.sort(nombres);

        // Actualizar la tabla con los nombres ordenados
        for (int i = 0; i < filas; i++) {
            modeloTabla.setValueAt(nombres[i], i, 0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new U2Practica2_BurbujaNombres().setVisible(true);
            }
        });
    }
}

