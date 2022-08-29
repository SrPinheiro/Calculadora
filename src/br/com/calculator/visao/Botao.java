package br.com.calculator.visao;

import javax.swing.*;
import java.awt.*;

public class Botao extends JButton {

    public Botao(String text, Color cor){
        setText(text);
        setBackground(cor);
        setForeground(new Color(248,248,255));
        setOpaque(true);
        setFont(new Font("courier",Font.PLAIN, 30));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

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