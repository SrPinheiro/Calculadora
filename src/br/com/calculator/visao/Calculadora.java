package br.com.calculator.visao;

import javax.swing.*;
import java.awt.*;

public class Calculadora extends JFrame {

    public Calculadora(String title){

        organizarLayout();

        setBackground(new Color(160,160,160));
        setVisible(true);
        setSize(232,322);
        setLocationRelativeTo(null);
        setTitle(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    private void organizarLayout() {
        setLayout(new BorderLayout());
        //setUndecorated(true);

        Display display = new Display();
        display.setPreferredSize(new Dimension(233,60));
        add(display, BorderLayout.NORTH);

        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);

    }
}
/*
 * Codigo feito por Leonardo Pinheiro
 * IDE: Intellij IDEA — JetBrains
 * Turma: Info 0121
 * IFNMG — Campus Almenara
 * GitHub: https://github.com/SrPinheiro
 * Data:
 */