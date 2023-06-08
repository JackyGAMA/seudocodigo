package org.example.modelo;

import org.example.persistencia.HoroscopoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaHoroscopo implements TableModel {
    private ArrayList<Horoscopo> datos;
    private HoroscopoDAO pdao;

    public static final int COL = 6;


    public ModeloTablaHoroscopo() {
        pdao = new HoroscopoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaHoroscopo(ArrayList<Horoscopo> datos) {

        this.datos = datos;
        //pdao = new PrincesasDisneyDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COL;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {

            case 0:
                return "ID: ";

            case 1:
                return "Signo: ";
            case 2:
                return "URL: ";
            case 3:
                return "Elemento que representa: ";
            case 4:
                return "Meses de los signos: ";
            case 5:
                return "Ultimo dia del signo: ";
            default:
                return null;

        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return int.class;

            default:
                return String.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Horoscopo tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getSigno();
            case 2:
                return tmp.getUrl();
            case 3:
                return tmp.getElementoQueRepresenta();
            case 4:
                return tmp.getMesesDelSigno();
            case 5:
                return tmp.getUltimoDiaDelSigno();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId(Integer.parseInt((String) aValue));
                break;
            case 1:
                datos.get(rowIndex).setSigno((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setUrl((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setElementoQueRepresenta((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setMesesDelSigno((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setUltimoDiaDelSigno(Integer.parseInt((String) aValue));
                break;
            default:
                System.out.println("No se realizo modificacion alguna");
                break;
        }
    }
    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {

        try {
       //     ArrayList<Horoscopo> tirar = pdao.obtenerTodo();

            datos = pdao.obtenerTodo();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean agregarSignos(Horoscopo horoscopo) {
        boolean resultado = false;
        try {
            if (pdao.insertar(horoscopo)) {
                datos.add(horoscopo);
                resultado = true;
            } else {

                resultado = false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }

    public Horoscopo getHoroscopoAtIndex(int i) {

        return datos.get(i);
    }

    public boolean eliminarFila( int index) throws SQLException {

        if (pdao.delete(index)) {

            return true;

        } else {
            return false;
        }
    }


    public boolean actualizarCelda(String datoActualizado, int id, int colIndex) throws SQLException {
        if (pdao.cambiarlaCelda(datoActualizado,id,colIndex)){
            return true;
        }else {
            return false;
        }
    }



}
