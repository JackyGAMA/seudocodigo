package org.example.controlador;

import org.example.interfaz.ventanaHoroscopo;
import org.example.modelo.ModeloTablaHoroscopo;
import org.example.modelo.Horoscopo;
import org.example.persistencia.HoroscopoDAO;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.sql.SQLOutput;
public class ControladorHoroscopo extends MouseAdapter{
    private ventanaHoroscopo vista;
    private ModeloTablaHoroscopo modelo;


    public ControladorHoroscopo(ventanaHoroscopo vista) {
        this.vista = vista;
        this.vista.getTablaHoroscopo().addMouseListener(this);
        this.vista.getB0tonCargar().addMouseListener(this);
        this.vista.getBotonAgregar().addMouseListener(this);
        modelo = new ModeloTablaHoroscopo();
        this.vista.getTablaHoroscopo().setModel(modelo);
        this.vista.getBotonActualizar().addMouseListener(this);
        this.vista.getBotonBorrar().addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.vista.getBotonAgregar()){
            modelo.cargarDatos();
            this.vista.getTablaHoroscopo().setModel(modelo);
            this.vista.getTablaHoroscopo().updateUI();

        }
        if(e.getSource() == this.vista.getBotonAgregar()){

            Horoscopo sagitario = new Horoscopo();
            sagitario.setId(0);
            sagitario.setSigno(this.vista.getTxtSigno().getText());
            sagitario.setUrl(this.vista.getTxtUrl().getText());
            sagitario.setElementoQueRepresenta(this.vista.getTxtElementoQueRepresenta().getText());
            sagitario.setMesesDelSigno(this.vista.getTxtMesesDeLosSignos().getText());
            sagitario.setUltimoDiaDelSigno(Integer.parseInt(this.vista.getTxtUltimoDia().getText()));

            if(modelo.agregarSignos(sagitario)){
                JOptionPane.showMessageDialog(vista,"Se agrego correctamente","Confirmacion",JOptionPane.INFORMATION_MESSAGE);

                modelo.cargarDatos();
                this.vista.getTablaHoroscopo().setModel(modelo);
                this.vista.getTablaHoroscopo().updateUI();

            }else {
                JOptionPane.showMessageDialog(vista,"No se pudo agregar correctamente, revise su informacion","Error",JOptionPane.ERROR_MESSAGE);
            }
            this.vista.limpiar();

        }

        if (e.getSource() == this.vista.getTablaHoroscopo()){

            try {
                int index = this.vista.getTablaHoroscopo().getSelectedRow();
                Horoscopo tmp = modelo.getHoroscopoAtIndex(index);
                this.vista.getLblImagen().setIcon(tmp.getImagen());
            } catch (MalformedURLException ex) {
                throw new RuntimeException(ex);
            }
            this.vista.getLblImagen().setText("");
        }

        if(e.getSource() == this.vista.getBotonBorrar()){
            int index = this.vista.getTablaHoroscopo().getSelectedRow();
            Horoscopo tmp = modelo.getHoroscopoAtIndex(index);
            int resultado = JOptionPane.showConfirmDialog(vista,"Esta seguro que desea borrar el contenido "+(tmp.getId())+"?","Confirmacion",JOptionPane.YES_NO_OPTION);
            if(resultado == JOptionPane.YES_NO_OPTION) {
                try {
                    if (modelo.eliminarFila(tmp.getId())) {
                        JOptionPane.showMessageDialog(vista, "Se borro correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        modelo.cargarDatos();
                        this.vista.getTablaHoroscopo().setModel(modelo);
                        this.vista.getTablaHoroscopo().updateUI();


                    } else {
                        JOptionPane.showMessageDialog(vista, "No se pudo borrar correctamente, revise su conexion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }

        }

        if (e.getSource() == this.vista.getBotonActualizar()) {
            int index = this.vista.getTablaHoroscopo().getSelectedRow();
            Horoscopo tmp = modelo.getHoroscopoAtIndex(index);
            int id = tmp.getId();
            String datoActualizado = JOptionPane.showInputDialog(vista,"Inserte el cambio a actualizar de "+
                    this.vista.getTablaHoroscopo().getColumnName(vista.getTablaHoroscopo().getSelectedColumn())+" del registro "
                    +id,"Actualizar",JOptionPane.INFORMATION_MESSAGE);


            int colIndex = this.vista.getTablaHoroscopo().getSelectedColumn();

            System.out.println(colIndex+""+datoActualizado+""+id);

            try {
                if(modelo.actualizarCelda(datoActualizado,id,colIndex)){
                    System.out.println("se realizo con exito");
                    modelo.cargarDatos();
                    this.vista.getTablaHoroscopo().setModel(modelo);
                    this.vista.getTablaHoroscopo().updateUI();

                }else{
                    System.out.println("no se realizo con exito");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        }
    }
}
