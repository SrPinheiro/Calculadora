package br.com.calculator.modelo;

import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando{
      ZERAR, NUMERO, DIVISAO, MULTIPLICACAO, SUB, SOMA, IGUAl, VIRGULA, TROCA;
    };

    private static final Memoria objeto = new Memoria();
    private final List<MemoriaObserver> observers = new ArrayList<>();

    private String textoAtual = "";
    private String textoCalculado = "";
    private boolean substituir = false;
    private TipoComando ultimaOperacao;

    private Memoria(){

    }

    public void addObservador(MemoriaObserver obs){
        observers.add(obs);
    }

    public static Memoria getInstance(){
        return objeto;
    }

    public String getTextoAtual(){
        return this.textoAtual.isEmpty() ? "0" : this.textoAtual;
    }

    public void processarComandos(String value){
        TipoComando tipo = detectarTipo(value);

        if(tipo != null){
            if(tipo.equals(TipoComando.NUMERO) || tipo.equals(TipoComando.VIRGULA)){
                this.textoAtual = substituir ? value :  this.textoAtual + value;
                this.substituir = false;

            }else if(tipo.equals(TipoComando.ZERAR)){
                this.textoAtual = "";
                this.textoCalculado = "";
                this.ultimaOperacao = null;
                this.substituir = false;

            }else if(!this.textoAtual.isEmpty()){
                if(tipo.equals(TipoComando.TROCA)){
                    if (this.textoAtual.contains("-")){
                        this.textoAtual.replace("-", "");
                    }else{
                        this.textoAtual = "-" + this.textoAtual;
                    }

                    /*double valorR = Double.parseDouble(textoAtual) * -1;
                    if(valorR / ((int) valorR) == 1){
                        // funcionou o numero é inteiro!
                         this.textoAtual = String.valueOf((int) valorR);
                    }else{
                        // o numero nao é inteiro (PORRA)
                        this.textoAtual = String.format("%.2f", valorR).replace(".", ",");
                    }*/

                }else{
                    this.substituir = true;
                    textoAtual = obterResultado();
                    textoCalculado = textoAtual;
                    ultimaOperacao = tipo;
                }

            }

            observers.forEach(c -> c.valorAlterado(this.getTextoAtual()));
        }
        //if(tipo.equals(TipoComando.))


    }

    private String obterResultado() {
        if (ultimaOperacao == null){
            return this.textoAtual;
        }

        double resultado = Double.parseDouble(this.textoCalculado.replace(",", "."));
        double atual = Double.parseDouble(this.textoAtual.replace(",", "."));

        double resultadoFinal = 0;

        switch (ultimaOperacao){
            case SOMA -> resultadoFinal = resultado + atual;
            case DIVISAO -> resultadoFinal = resultado / atual;
            case SUB -> resultadoFinal = resultado - atual;
            case MULTIPLICACAO -> resultadoFinal = resultado * atual;

        }

        if(resultadoFinal / ((int) resultadoFinal) == 1){
            return String.valueOf((int) resultadoFinal);
        }else{
            return String.format("%.2f", resultadoFinal).replace(".", ",");
        }

    }

    private TipoComando detectarTipo(String value) {

        if (textoAtual.isEmpty() && value.equals("0")){
            return null;
        }

        try{
            Integer.parseInt(value);
            return TipoComando.NUMERO;

        }catch (NumberFormatException e){

            if (value.equals("AC")){
                return TipoComando.ZERAR;
            }
            if (value.equals("±")){
                return TipoComando.TROCA;
            }

            if (value.equals("/")){
                return TipoComando.DIVISAO;
            }

            if (value.equals("X")){
                return TipoComando.MULTIPLICACAO;
            }

            if (value.equals("-")){
                return TipoComando.SUB;
            }

            if (value.equals("+")){
                return TipoComando.SOMA;
            }

            if (value.equals("=")){
                return TipoComando.IGUAl;
            }
            if(value.equals(",") && !this.textoAtual.contains(",")) {
                return TipoComando.VIRGULA;
            }
            return null;
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