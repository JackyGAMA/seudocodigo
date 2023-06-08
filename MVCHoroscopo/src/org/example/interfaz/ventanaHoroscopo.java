package org.example.interfaz;


import jdk.jfr.Enabled;

import javax.swing.*;
import java.awt.*;

public class  ventanaHoroscopo extends JFrame {
    private GridLayout layoutGeneral;

    //Objetos de panel 1
    private JLabel lblId;
    private JLabel lblSigno;
    private JLabel lblUrl;
    private JLabel lblElementoQueRepresenta;
    private JLabel lblMesesDeLosSignos;
    private JLabel lblUltimoDia;
    private JTextField txtId;
    private JTextField txtSigno;
    private JTextField txtUrl;
    private JTextField txtElementoQueRepresenta;
    private JTextField txtMesesDeLosSignos;
    private JTextField txtUltimoDia;
    private JButton botonAgregar;
    private JPanel panel1;
    //Objetos Panel 2
    private JTable tablaHoroscopo;
    private JPanel panel2;
    private JButton b0tonCargar;
    private JScrollPane scroll;
    //Objetos Panel 3
    private JPanel panel3;
    private JLabel lblfila;
    private JLabel lblImagen;
    //Objetos Panel 4
    private JPanel panel4;
    private JButton botonBorrar;
    private JButton botonActualizar;

    //getter y setters

    public GridLayout getLayoutGeneral() {
        return layoutGeneral;
    }

    public void setLayoutGeneral(GridLayout layoutGeneral) {
        this.layoutGeneral = layoutGeneral;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblSigno() {
        return lblSigno;
    }

    public void setLblSigno(JLabel lblSigno) {
        this.lblSigno = lblSigno;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JLabel getLblElementoQueRepresenta() {
        return lblElementoQueRepresenta;
    }

    public void setLblElementoQueRepresenta(JLabel lblElementoQueRepresenta) {
        this.lblElementoQueRepresenta = lblElementoQueRepresenta;
    }

    public JLabel getLblMesesDeLosSignos() {
        return lblMesesDeLosSignos;
    }

    public void setLblMesesDeLosSignos(JLabel lblMesesDeLosSignos) {
        this.lblMesesDeLosSignos = lblMesesDeLosSignos;
    }

    public JLabel getLblUltimoDia() {
        return lblUltimoDia;
    }

    public void setLblUltimoDia(JLabel lblUltimoDia) {
        this.lblUltimoDia = lblUltimoDia;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtSigno() {
        return txtSigno;
    }

    public void setTxtSigno(JTextField txtSigno) {
        this.txtSigno = txtSigno;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JTextField getTxtElementoQueRepresenta() {
        return txtElementoQueRepresenta;
    }

    public void setTxtElementoQueRepresenta(JTextField txtElementoQueRepresenta) {
        this.txtElementoQueRepresenta = txtElementoQueRepresenta;
    }

    public JTextField getTxtMesesDeLosSignos() {
        return txtMesesDeLosSignos;
    }

    public void setTxtMesesDeLosSignos(JTextField txtMesesDeLosSignos) {
        this.txtMesesDeLosSignos = txtMesesDeLosSignos;
    }

    public JTextField getTxtUltimoDia() {
        return txtUltimoDia;
    }

    public void setTxtUltimoDia(JTextField txtUltimoDia) {
        this.txtUltimoDia = txtUltimoDia;
    }

    public JButton getBotonAgregar() {
        return botonAgregar;
    }

    public void setBotonAgregar(JButton botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTable getTablaHoroscopo() {
        return tablaHoroscopo;
    }

    public void setTablaHoroscopo(JTable tablaHoroscopo) {
        this.tablaHoroscopo = tablaHoroscopo;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JButton getB0tonCargar() {
        return b0tonCargar;
    }

    public void setB0tonCargar(JButton b0tonCargar) {
        this.b0tonCargar = b0tonCargar;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JLabel getLblfila() {
        return lblfila;
    }

    public void setLblfila(JLabel lblfila) {
        this.lblfila = lblfila;
    }

    public JLabel getLblImagen() {
        return lblImagen;
    }

    public void setLblImagen(JLabel lblImagen) {
        this.lblImagen = lblImagen;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBotonBorrar() {
        return botonBorrar;
    }

    public void setBotonBorrar(JButton botonBorrar) {
        this.botonBorrar = botonBorrar;
    }

    public JButton getBotonActualizar() {
        return botonActualizar;
    }

    public void setBotonActualizar(JButton botonActualizar) {
        this.botonActualizar = botonActualizar;
    }

    public ventanaHoroscopo(String title) throws HeadlessException {
        super(title);

        layoutGeneral = new GridLayout(2, 2);
        this.setLayout(layoutGeneral);

        //panel 1
        panel1 = new JPanel();
        panel1.setBackground(new Color(183, 101, 253, 255));

        lblId = new JLabel("Id");
        txtId = new JTextField(5);
        txtId.setText("0");
        txtId.setEnabled(false);
        panel1.add(lblId);
        panel1.add(txtId);

        lblSigno = new JLabel("Signo:");
        txtSigno = new JTextField(10);
        panel1.add(lblSigno);
        panel1.add(txtSigno);

        lblUrl = new JLabel("URL: ");
        txtUrl = new JTextField(30);
        panel1.add(lblUrl);
        panel1.add(txtUrl);

        lblElementoQueRepresenta = new JLabel("Elemento que representa: ");
        txtElementoQueRepresenta = new JTextField(10);
        panel1.add(lblElementoQueRepresenta);
        panel1.add(txtElementoQueRepresenta);

        lblMesesDeLosSignos = new JLabel("Meses de los signos: ");
        txtMesesDeLosSignos = new JTextField(10);
        panel1.add(lblMesesDeLosSignos);
        panel1.add(txtMesesDeLosSignos);

        lblUltimoDia = new JLabel("Ultimo dia:  ");
        txtUltimoDia = new JTextField(5);
        panel1.add(lblUltimoDia);
        panel1.add(txtUltimoDia);

        botonAgregar = new JButton("Agregar");
        panel1.add(botonAgregar);


        //panel 2
        panel2 = new JPanel();
        panel2.setBackground(new Color(253, 141, 83));
        panel2.setLayout(new FlowLayout());
        b0tonCargar = new JButton("Cargar");
        panel2.add(b0tonCargar);
        tablaHoroscopo = new JTable();
        scroll = new JScrollPane(tablaHoroscopo);
        panel2.add(scroll);


        //panel 3
        panel3 = new JPanel();
        panel3.setBackground(new Color(238, 98, 187, 255));
        panel3.setLayout(new FlowLayout());
        lblfila = new JLabel("Imagen:");
        panel3.add(lblfila);
        lblImagen = new JLabel("...");
        panel3.add(lblImagen);

        //panel 4
        panel4 = new JPanel();
        panel4.setBackground(new Color(248, 233, 136, 255));
        panel4.setLayout(new FlowLayout());
        botonActualizar = new JButton("Actualizar");
        botonBorrar = new JButton("Borrar");
        panel4.add(botonActualizar);
        panel4.add(botonBorrar);


        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000, 900);
        this.setVisible(true);
    }
    public void limpiar(){
        txtSigno.setText("");
        txtUrl.setText("");
        txtElementoQueRepresenta.setText("");
        txtMesesDeLosSignos.setText("");
        txtUltimoDia.setText("");
    }


}