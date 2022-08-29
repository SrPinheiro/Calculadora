package br.com.calculator.visao;

import br.com.calculator.modelo.Memoria;
import br.com.calculator.modelo.MemoriaObserver;

import javax.swing.*;
import java.awt.*;

public class Display extends JPanel implements MemoriaObserver {

    private final JLabel label;

    public Display(){
        setBackground(new Color(46,49,60));
        //setBorder(BorderFactory.createLineBorder(Color.BLACK));

        label = new JLabel(Memoria.getInstance().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier",Font.PLAIN, 30));
        add(label);

        setLayout(new FlowLayout(FlowLayout.RIGHT, 10,25));
        //setBackground(Color.GREEN);

        Memoria.getInstance().addObservador(this);
    }

    @Override
    public void valorAlterado(String valor) {
        label.setText(valor);
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