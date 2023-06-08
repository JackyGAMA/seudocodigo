package org.example.persistencia;

import org.example.modelo.Horoscopo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class HoroscopoDAO extends InterfazDAO {
    public HoroscopoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO Horoscopo(Signo,URL,elementoQueRepresenta,mesesDeLosSignos,ultimoDiaDelSigno) VALUES(?,?,?,?,?)";
        int rowCount = 0;


        PreparedStatement pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((Horoscopo) obj).getSigno());
        pstm.setString(2, ((Horoscopo) obj).getUrl());
        pstm.setString(3, ((Horoscopo) obj).getElementoQueRepresenta());
        pstm.setString(4, ((Horoscopo) obj).getMesesDelSigno());
        pstm.setInt(5, ((Horoscopo) obj).getUltimoDiaDelSigno());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean updte(Object obj,int Id) throws SQLException {
        String sqlUpdate = "UPDATE Horoscopo SET Signo = ?, URL = ?, ElementoQueRepresenta = ?, MesesDeLosSignos = ?, UltimoDia= ? WHERE Id = "+Id+";";
        int rowCount = 0;


        PreparedStatement pstm = ConexionSingleton.getInstance("Horoscopo.db").getConnection().prepareStatement(sqlUpdate);

        pstm.setString(1, ((Horoscopo) obj).getSigno());
        pstm.setString(2, ((Horoscopo) obj).getUrl());
        pstm.setString(3, ((Horoscopo) obj).getElementoQueRepresenta());
        pstm.setString(4, ((Horoscopo) obj).getMesesDelSigno());
        pstm.setInt(5, ((Horoscopo) obj).getUltimoDiaDelSigno());

        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sqlDelete = "DELETE FROM Horoscopo WHERE id = ?;";
        int rowCount =0;
        PreparedStatement pstm = ConexionSingleton.getInstance("Horoscopo.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1,id);
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM Horoscopo";
        ArrayList<Horoscopo> resultado = new ArrayList<>();

        Statement stm = ConexionSingleton.getInstance("horoscopo.db").getConnection().createStatement();
        ResultSet rst = stm.executeQuery(sql);
        while (rst.next()){
            resultado.add(new Horoscopo(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4),
                    rst.getString(5),rst.getInt(6)));
        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM Horoscopo WHERE Id = ?;";
        Horoscopo horoscopo = null;

        PreparedStatement pstm= ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sql);
        pstm.setInt(1,Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if(rst.next()){
            horoscopo = new Horoscopo(rst.getInt(1),rst.getString(2), rst.getString(3),
                    rst.getString(4),rst.getString(5),rst.getInt(6));
            return horoscopo;
        }
        return null;

    }

    public boolean cambiarlaCelda(String datoActualizado, int Id,int colIndex) throws SQLException {
        String sqlUpdate;
        PreparedStatement pstm;
        int rowCount;

        switch (colIndex){

            case 1:
                sqlUpdate = "UPDATE Horoscopo SET signo = ? WHERE Id = "+Id+";";
                rowCount = 0;
                pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1, (datoActualizado));
                rowCount = pstm.executeUpdate();

                return rowCount > 0;

            case 2:
                sqlUpdate = "UPDATE Horoscopo SET Url = ? WHERE Id = "+Id+";";
                rowCount = 0;
                pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1, (datoActualizado));
                rowCount = pstm.executeUpdate();

                return rowCount > 0;
            case 3:
                sqlUpdate = "UPDATE Horoscopo SET ElementoQueRepresenta = ? WHERE Id = "+Id+";";
                rowCount = 0;
                pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1, (datoActualizado));
                rowCount = pstm.executeUpdate();

                return rowCount > 0;
            case 4:
                sqlUpdate = "UPDATE Horoscopo SET MesesDeLosSignos = ? WHERE Id = "+Id+";";
                rowCount = 0;
                pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1, (datoActualizado));
                rowCount = pstm.executeUpdate();

                return rowCount > 0;

            case 5:
                sqlUpdate = "UPDATE Horoscopo SET UltimoDia = ? WHERE Id = "+Id+";";
                rowCount = 0;
                pstm = ConexionSingleton.getInstance("horoscopo.db").getConnection().prepareStatement(sqlUpdate);
                pstm.setString(1, (datoActualizado));
                rowCount = pstm.executeUpdate();

                return rowCount > 0;
        }
        return false;
    }
}
