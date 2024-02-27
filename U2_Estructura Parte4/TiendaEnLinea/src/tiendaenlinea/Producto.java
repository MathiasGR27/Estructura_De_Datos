package tiendaenlinea;

// Clase Producto
class Producto implements Comparable<Producto> {
    // Atributos de la clase Producto
    private String nombre;
    private double precio;

    // Constructor de la clase Producto
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método para obtener el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Método de comparación para la interfaz Comparable
    @Override
    public int compareTo(Producto otroProducto) {
        return Double.compare(this.precio, otroProducto.precio);
    }

    // Método toString para imprimir la información del producto
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}