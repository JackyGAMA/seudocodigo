
import org.example.controlador.ControladorHoroscopo;
import org.example.interfaz.ventanaHoroscopo;

import javax.swing.*;
import java.sql.SQLException;
public class Main{
    public static void main(String[] args) {
        ventanaHoroscopo view = new ventanaHoroscopo("MVC");
        ControladorHoroscopo controlador = new ControladorHoroscopo(view);
    }
}