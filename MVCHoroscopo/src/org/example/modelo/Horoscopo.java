package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
public class Horoscopo {
    private int id;
    private String Signo;
    private String Url;
    private String ElementoQueRepresenta;
    private String MesesDelSigno;
    private int UltimoDiaDelSigno;

    public Horoscopo() {
    }

    public Horoscopo(int id, String signo, String url, String elementoQueRepresenta, String mesesDelSigno, int ultimoDiaDelSigno) {
        this.id = id;
        Signo = signo;
        Url = url;
        ElementoQueRepresenta = elementoQueRepresenta;
        MesesDelSigno = mesesDelSigno;
        UltimoDiaDelSigno = ultimoDiaDelSigno;
    }

    /*public Horoscopo(String signo, String url, String elementoQueRepresenta, String mesesDelSigno, String ultimoDiaDelSigno) {
        Signo = signo;
        Url = url;
        ElementoQueRepresenta = elementoQueRepresenta;
        MesesDelSigno = mesesDelSigno;
        UltimoDiaDelSigno = ultimoDiaDelSigno;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSigno() {
        return Signo;
    }

    public void setSigno(String signo) {
        Signo = signo;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getElementoQueRepresenta() {
        return ElementoQueRepresenta;
    }

    public void setElementoQueRepresenta(String elementoQueRepresenta) {
        ElementoQueRepresenta = elementoQueRepresenta;
    }

    public String getMesesDelSigno() {
        return MesesDelSigno;
    }

    public void setMesesDelSigno(String mesesDelSigno) {
        MesesDelSigno = mesesDelSigno;
    }

    public int getUltimoDiaDelSigno() {
        return UltimoDiaDelSigno;
    }

    public void setUltimoDiaDelSigno(int ultimoDiaDelSigno) {
        UltimoDiaDelSigno = ultimoDiaDelSigno;
    }

    @Override
    public String toString() {
        return "Horoscopo{" +
                "id=" + id +
                ", Signo='" + Signo + '\'' +
                ", Url='" + Url + '\'' +
                ", ElementoQueRepresenta='" + ElementoQueRepresenta + '\'' +
                ", MesesDelSigno='" + MesesDelSigno + '\'' +
                ", UltimoDiaDelSigno='" + UltimoDiaDelSigno + '\'' +
                '}';
    }

    public ImageIcon getImagen() throws MalformedURLException {

        URL urlImage = new URL(this.Url);
        return new ImageIcon(urlImage);

    }

}
