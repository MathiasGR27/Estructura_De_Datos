package tareaindividual_tiendaenlineagrafica;

// Importaciones necesarias
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TareaIndividual_TiendaenLineaGrafica extends JFrame {
    
    // Declaración de componentes de la interfaz gráfica
    private JTextField nombreTextField, precioTextField;
    private DefaultListModel<String> modeloLista;
    private List<Producto> inventario;

    // Constructor de la clase
    public TareaIndividual_TiendaenLineaGrafica() {
        // Configuración de la ventana principal
        setTitle("Tienda en Línea");
        setSize(990, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear componentes del formulario
        nombreTextField = new JTextField(20);
        precioTextField = new JTextField(10);
        JButton agregarButton = new JButton("Agregar Producto");
        JButton ordenarButton = new JButton("Ordenar por Precio");
        JButton buscarButton = new JButton("Buscar por Nombre");
        JButton buscarBinarioButton = new JButton("Búsqueda Binaria por Precio");
        JButton salirButton = new JButton("Salir");

        // Configurar la lista
        modeloLista = new DefaultListModel<>();
        JList<String> listaProductos = new JList<>(modeloLista);
        JScrollPane scrollPane = new JScrollPane(listaProductos);

        // Crear el panel de entrada de datos
        JPanel panelEntradaDatos = new JPanel(new GridLayout(3, 2, 5, 5));
        panelEntradaDatos.add(new JLabel("Nombre del Producto:"));
        panelEntradaDatos.add(nombreTextField);
        panelEntradaDatos.add(new JLabel("Precio del Producto:"));
        panelEntradaDatos.add(precioTextField);
        panelEntradaDatos.add(agregarButton);

        // Configurar el color inicial y de resaltado para los botones
        Color colorInicial = new Color(173, 216, 230); // Celeste
        Color colorResaltado = new Color(0, 255, 255);    // Azul

        // Establecer el color inicial para los botones
        agregarButton.setBackground(colorInicial);
        ordenarButton.setBackground(colorInicial);
        buscarButton.setBackground(colorInicial);
        buscarBinarioButton.setBackground(colorInicial);
        salirButton.setBackground(colorInicial);

        // Crear el panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        panelBotones.add(agregarButton);
        panelBotones.add(ordenarButton);
        panelBotones.add(buscarButton);
        panelBotones.add(buscarBinarioButton);
        panelBotones.add(salirButton);

        // Configurar el diseño del formulario con un SplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(400);

        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.add(panelEntradaDatos, BorderLayout.NORTH);
        panelIzquierdo.add(panelBotones, BorderLayout.CENTER);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.setBackground(Color.LIGHT_GRAY);
        panelDerecho.add(scrollPane, BorderLayout.CENTER);

        splitPane.setLeftComponent(panelIzquierdo);
        splitPane.setRightComponent(panelDerecho);

        // Agregar acciones a los botones
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });
        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ordenarPorPrecio();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPorNombre();
            }
        });
        buscarBinarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarBinarioPorPrecio();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Establecer el color de resaltado para los botones al pasar el mouse
        agregarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarButton.setBackground(colorResaltado);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregarButton.setBackground(colorInicial);
            }
        });
        ordenarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ordenarButton.setBackground(colorResaltado);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ordenarButton.setBackground(colorInicial);
            }
        });
        buscarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarButton.setBackground(colorResaltado);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarButton.setBackground(colorInicial);
            }
        });
        buscarBinarioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buscarBinarioButton.setBackground(colorResaltado);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buscarBinarioButton.setBackground(colorInicial);
            }
        });
        salirButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                salirButton.setBackground(colorResaltado);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                salirButton.setBackground(colorInicial);
            }
        });

        // Agregar el SplitPane al contenedor principal
        add(splitPane);

        // Inicializar la lista de productos (puedes cargarla desde tu base de datos si es necesario)
        inventario = new ArrayList<>();
    }

    // Método para agregar un producto al inventario
    private void agregarProducto() {
        // Obtener el nombre y el precio ingresados por el usuario
        String nombre = nombreTextField.getText().trim();
        String precioTexto = precioTextField.getText().trim();

        // Validar que el nombre solo contenga caracteres
        if (!nombre.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(null, "Ingrese solo letras para el nombre del producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que el precio sea un número
        try {
            double precio = Double.parseDouble(precioTexto);

            // Validar que el precio sea un número positivo
            if (precio < 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un precio válido (número positivo).", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Crear un objeto Producto y agregarlo al inventario
            Producto producto = new Producto(nombre, precio);
            inventario.add(producto);

            // Agregar la representación en cadena del producto a la lista visual en la interfaz gráfica
            modeloLista.addElement(producto.toString());

            // Limpiar los campos después de agregar el producto
            nombreTextField.setText("");
            precioTextField.setText("");
        } catch (NumberFormatException e) {
            // Error al convertir el precio a double (no es un número)
            JOptionPane.showMessageDialog(null, "Ingrese solo números para el precio del producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para mostrar todos los productos en la lista visual
    private void mostrarInventario() {
        modeloLista.clear();
        for (Producto producto : inventario) {
            modeloLista.addElement(producto.toString());
        }
    }

    // Método para ordenar el inventario por precio utilizando el algoritmo de merge sort
    private void ordenarPorPrecio() {
        Producto[] arrayProductos = inventario.toArray(new Producto[0]);
        mergeSort(arrayProductos, 0, arrayProductos.length - 1);

        inventario.clear();
        inventario.addAll(Arrays.asList(arrayProductos));

        mostrarInventario();
    }

    // Método para buscar un producto por nombre en el inventario
private void buscarPorNombre() {
    // Solicita al usuario que ingrese el nombre del producto a buscar
    String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar:");
    // Variable para indicar si se ha encontrado el producto
    boolean encontrado = false;

    // Recorre el inventario para buscar el producto por nombre
    for (int i = 0; i < inventario.size(); i++) {
        Producto producto = inventario.get(i);
        // Compara el nombre del producto en el inventario con el nombre buscado (ignorando mayúsculas/minúsculas)
        if (producto.getNombre().equalsIgnoreCase(nombreBusqueda)) {
            // Si encuentra el producto, muestra un mensaje con la posición y los detalles del producto
            JOptionPane.showMessageDialog(null, "Producto encontrado en la posición " + i + ": " + producto);
            encontrado = true;
            // Sale del bucle ya que se ha encontrado el producto
            break;
        }
    }

    // Si no se encontró el producto, muestra un mensaje indicándolo
    if (!encontrado) {
        JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
    }
}

    private void buscarBinarioPorPrecio() {
    // Verifica si el inventario está vacío
    if (inventario.isEmpty()) {
        JOptionPane.showMessageDialog(null, "El inventario está vacío. Agregue productos antes de buscar.");
        return;
    }

    // Verifica si el inventario está ordenado
    if (!estaOrdenado(inventario)) {
        JOptionPane.showMessageDialog(null, "El inventario no está ordenado. Ordénelo primero.");
        return;
    }

    // Obtiene el precio de búsqueda del usuario
    double precioBusqueda = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto a buscar:"));

    // Llamada a la función de búsqueda binaria
    int indice = busquedaBinaria(inventario.toArray(new Producto[0]), precioBusqueda);

    // Comprueba si se encontró el producto y muestra el mensaje correspondiente
    if (indice != -1) {
        JOptionPane.showMessageDialog(null, "Producto encontrado en la posición " + indice + ": " + inventario.get(indice));
    } else {
        JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
    }
}

    // Función para verificar si la lista está ordenada por precio
    private boolean estaOrdenado(List<Producto> lista) {
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i - 1).getPrecio() > lista.get(i).getPrecio()) {
                return false;
            }
        }
        return true;
    }

    // Función de búsqueda binaria
    private static int busquedaBinaria(Producto arr[], double precioBusqueda) {
        // Inicialización de variables para los límites del rango de búsqueda
        int izquierda = 0;
        int derecha = arr.length - 1;

        // Bucle de búsqueda binaria
        while (izquierda <= derecha) {
            // Calcular el índice medio del arreglo
            int medio = izquierda + (derecha - izquierda) / 2;

            // Comprobar si el elemento en el índice medio tiene el precio buscado
            if (arr[medio].getPrecio() == precioBusqueda) {
                return medio;  // Elemento encontrado, devuelve el índice
            }

            // Si el precio en el índice medio es menor que el precio buscado, buscar en la mitad derecha
            if (arr[medio].getPrecio() < precioBusqueda) {
                izquierda = medio + 1;
            } else { // Si el precio en el índice medio es mayor, buscar en la mitad izquierda
                derecha = medio - 1;
            }
        }

        // Elemento no encontrado, devuelve -1
        return -1;
    }

    // Implementación del algoritmo de merge sort para ordenar un arreglo de productos por precio
    private void mergeSort(Producto arr[], int left, int right) {
        // Verifica si hay más de un elemento en el arreglo
        if (left < right) {
             // Calcula el índice medio del arreglo
            int middle = left + (right - left) / 2;
            // Llama recursivamente a mergeSort para la mitad izquierda del arreglo
            mergeSort(arr, left, middle);
            // Llama recursivamente a mergeSort para la mitad derecha del arreglo
            mergeSort(arr, middle + 1, right);
            // Combina las mitades ordenadas utilizando la función merge
            merge(arr, left, middle, right);
        }
    }
           

    // Función auxiliar para combinar dos subarreglos ordenados en un arreglo
    private void merge(Producto arr[], int left, int middle, int right) {
        // Calcula las longitudes de los subarreglos izquierdo y derecho
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // Crea subarreglos temporales para almacenar los datos del subarreglo izquierdo y derecho
    Producto leftArray[] = new Producto[n1];
    Producto rightArray[] = new Producto[n2];

    // Copia los datos a los subarreglos temporales
    System.arraycopy(arr, left, leftArray, 0, n1);
    System.arraycopy(arr, middle + 1, rightArray, 0, n2);

    // Índices para recorrer los subarreglos izquierdo, derecho y el arreglo principal
    int i = 0, j = 0;
    int k = left;

    // Combina los elementos de los subarreglos izquierdo y derecho en el arreglo principal
    while (i < n1 && j < n2) {
        // Compara los elementos de los subarreglos y coloca el menor en el arreglo principal
        if (leftArray[i].compareTo(rightArray[j]) <= 0) {
            arr[k] = leftArray[i];
            i++;
        } else {
            arr[k] = rightArray[j];
            j++;
        }
        k++;
    }

    // Copia los elementos restantes, si los hay, del subarreglo izquierdo al arreglo principal
    while (i < n1) {
        arr[k] = leftArray[i];
        i++;
        k++;
    }

    // Copia los elementos restantes, si los hay, del subarreglo derecho al arreglo principal
    while (j < n2) {
        arr[k] = rightArray[j];
        j++;
        k++;
    }
    }

    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TareaIndividual_TiendaenLineaGrafica().setVisible(true);
            }
        });
    }
}