/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package u2practica1_burbuja;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class U2Practica1_Burbuja extends JFrame {

    private JTextField numeroTextField;
    private DefaultTableModel modeloTabla;
    
    public U2Practica1_Burbuja(){
    // Configurar la ventana principal
        setTitle("Formulario de Números");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes del formulario
        numeroTextField = new JTextField(20);
        JButton agregarNumeroButton = new JButton("Agregar Número");
        JButton ordenarNumerosButton = new JButton("Ordenar Números");

        // Configurar la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Números");

        JTable tablaNumeros = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaNumeros);

        // Configurar el diseño del formulario
        setLayout(new BorderLayout());
        JPanel panelFormulario = new JPanel(new FlowLayout());
        panelFormulario.add(numeroTextField);
        panelFormulario.add(agregarNumeroButton);
        panelFormulario.add(ordenarNumerosButton);

        add(panelFormulario, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Configurar acciones de los botones
        agregarNumeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarNumero();
            }
        });
        
        ordenarNumerosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarNumeros();
            }
        });
    }

    private void agregarNumero() {
        try {
            int numero = Integer.parseInt(numeroTextField.getText());
            modeloTabla.addRow(new Object[]{numero});
            numeroTextField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número valido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void ordenarNumeros() {
        int filas = modeloTabla.getRowCount();
        int[] numeros = new int[filas];

        for (int i = 0; i < filas; i++) {
            numeros[i] = (int) modeloTabla.getValueAt(i, 0);
        }

        // Ordenar los números usando el método de burbuja
        for (int i = 0; i < filas - 1; i++) {
            for (int j = 0; j < filas - i - 1; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    // Intercambiar los elementos si están en el orden incorrecto
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                }
            }
        }

        // Actualizar la tabla con los números ordenados
        for (int i = 0; i < filas; i++) {
            modeloTabla.setValueAt(numeros[i], i, 0);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new U2Practica1_Burbuja().setVisible(true);
            }
        });
    }
}

