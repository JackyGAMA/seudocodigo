package org.example.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class InterfazDAO {
    public abstract boolean insertar(Object obj) throws SQLException;

    abstract boolean updte(Object obj, int Id) throws SQLException;

    public abstract boolean delete(int id) throws SQLException;
    public abstract ArrayList obtenerTodo() throws SQLException;
    public abstract Object buscarPorId(String id) throws SQLException;
}
