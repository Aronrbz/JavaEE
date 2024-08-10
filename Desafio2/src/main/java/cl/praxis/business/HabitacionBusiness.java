package cl.praxis.business;

import cl.praxis.model.Habitacion;
import java.util.ArrayList;
import java.util.List;

public class HabitacionBusiness {
    
    // Lista de habitaciones (simulación de base de datos)
    private List<Habitacion> habitaciones;

    // Constructor que inicializa la lista de habitaciones con algunos datos
    public HabitacionBusiness() {
        habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(1, "Habitación Simple", "Habitación para una persona", "simple.jpg", 50000, 1, 20));
        habitaciones.add(new Habitacion(2, "Habitación Doble", "Habitación para dos personas", "doble.jpg", 80000, 2, 30));
        habitaciones.add(new Habitacion(3, "Habitación Suite", "Habitación de lujo para dos personas", "suite.jpg", 150000, 2, 50));
    }

    // Método para obtener la lista de habitaciones
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    // Método para obtener una habitación por ID
    public Habitacion getHabitacionByID(int id) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getId() == id) {
                return habitacion;
            }
        }
        return null; // Si no se encuentra, devuelve null
    }

    // Método para calcular el valor a pagar
    public int calculaValorPagar(int id, int dias) {
        Habitacion habitacion = getHabitacionByID(id);
        if (habitacion != null) {
            return habitacion.getPrecio() * dias;
        }
        return 0; // Si no se encuentra la habitación, devuelve 0
    }
}
