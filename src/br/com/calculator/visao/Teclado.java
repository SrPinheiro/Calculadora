package br.com.calculator.visao;

import br.com.calculator.modelo.Memoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teclado extends JPanel implements ActionListener {
    private final Color CINZA_ESCURO = new Color(68,68,68);
    private final Color CINZA_CLARO = new Color(99,99,99);
    private final Color LARANJA = new Color(255,140,0);
    Teclado(){
        setBackground(new Color(46,49,60));

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints container = new GridBagConstraints();

        setLayout(layout);
        container.weightx = 1;
        container.weighty = 1;
        container.fill = GridBagConstraints.BOTH;

        //LINHA 1
        container.gridwidth = 2;
        addBotao("AC", CINZA_ESCURO, container,0,0);
        container.gridwidth = 1;
        addBotao("±", CINZA_ESCURO, container,2,0);
        addBotao("/", LARANJA, container,3,0);

        //LINHA 2
        addBotao("7", CINZA_CLARO, container,0,1);
        addBotao("8", CINZA_CLARO, container,1,1);
        addBotao("9", CINZA_CLARO, container,2,1);
        addBotao("X", LARANJA, container,3,1);

        //LINHA 3
        addBotao("4", CINZA_CLARO, container,0,2);
        addBotao("5", CINZA_CLARO, container,1,2);
        addBotao("6", CINZA_CLARO, container,2,2);
        addBotao("-", LARANJA, container,3,2);


        //LINHA 4
        addBotao("1", CINZA_CLARO, container,0,3);
        addBotao("2", CINZA_CLARO, container,1,3);
        addBotao("3", CINZA_CLARO, container,2,3);
        addBotao("+", LARANJA, container,3,3);

        //LINHA 5
        container.gridwidth = 2;
        addBotao("0", CINZA_CLARO, container,0,4);
        container.gridwidth = 1;
        addBotao(",", CINZA_CLARO, container,2,4);
        addBotao("=", LARANJA, container,3,4);

    }

    private void addBotao(String text, Color cor, GridBagConstraints c, int x, int y) {
        c.gridx = x;
        c.gridy = y;

        Botao bt = new Botao(text, cor);
        bt.addActionListener(this);

        add(bt, c);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof  JButton bt){
            Memoria.getInstance().processarComandos(bt.getText());
        }
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