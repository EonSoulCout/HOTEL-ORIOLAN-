package Hotel;

import java.util.Date;

public class reserva {
    private generic<Date, Date> dr;
    private cliente cliente;
    private hotel habitacion; // Agregar atributo hotel

    public reserva(generic<Date, Date> dr, cliente cliente) {
        this.dr = dr;
        this.cliente = cliente;
    }

    public reserva(Date fechaInicio, Date fechaFin, cliente cliente) {
        dr = new generic<>(fechaInicio, fechaFin);
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return dr.getA1();
    }

    public void setFechaInicio(Date fechaInicio) {
        dr.setA1(fechaInicio);
    }

    public Date getFechaFin() {
        return dr.getA2();
    }

    public void setFechaFin(Date fechaFin) {
        dr.setA2(fechaFin);
    }

    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    // Getter y Setter para el atributo hotel
    public hotel getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(hotel habitacion) {
        this.habitacion = habitacion;
    }

    @Override
    public String toString() {
        return "\nReserva\n[Entrega de habitacion: " + getFechaInicio() + "]\n[Salida de Habitacion: " + getFechaFin() + "]\n"
                + getCliente() + "\n" + getHabitacion(); // Agregar información de la habitación
    }
}
