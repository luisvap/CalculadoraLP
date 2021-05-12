package br.uniso;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    static String textoDoDisplay = "";

    static int ultimo;
    static int soma;
    static int vezesClicadasBotaoSomar;
    static List<Integer> lista = new ArrayList<>();

    public static void main(String args[]){
        JFrame tela = new JFrame("Calculadora");
        tela.setSize(100, 300);
        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton buttonMais = new JButton("+");
        JButton limpar = new JButton("CE");
        JButton limparSoUltimo = new JButton("C");

        JPanel preenchimento = new JPanel();
        preenchimento.add(button1);
        preenchimento.add(button2);
        preenchimento.add(buttonMais);

        preenchimento.add(limpar);
        preenchimento.add(limparSoUltimo);
        JTextField texto = new JTextField();
        texto.setEditable(false);
        texto.setColumns(50);
        preenchimento.add(texto);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoDoDisplay = textoDoDisplay + 1;
                texto.setText(textoDoDisplay);
                //lista.add(Integer.valueOf(textoDoDisplay));
                ultimo = Integer.valueOf(textoDoDisplay);
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoDoDisplay = textoDoDisplay + 2;
                texto.setText(textoDoDisplay);
                //lista.add(Integer.valueOf(textoDoDisplay));
                ultimo = Integer.valueOf(textoDoDisplay);
            }
        });

        limpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoDoDisplay = "";
                texto.setText(textoDoDisplay);
                lista.clear();
            }
        });

        limparSoUltimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textoDoDisplay = textoDoDisplay.substring(0, textoDoDisplay.length() - 1);
                texto.setText(textoDoDisplay);
            }
        });



        buttonMais.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vezesClicadasBotaoSomar = vezesClicadasBotaoSomar + 1;
                //if(lista.size() > 1){
                 //   for(Integer i : lista){
                       soma = soma + ultimo;
                 //   }
                   if(vezesClicadasBotaoSomar % 2 == 0){

                       textoDoDisplay = String.valueOf(soma);
                       soma = 0;

                   }

             //   }
                else{
                    textoDoDisplay = "";
                }

                texto.setText((textoDoDisplay));
            }
        });

        tela.getContentPane().add(preenchimento);

        tela.setVisible(true);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
