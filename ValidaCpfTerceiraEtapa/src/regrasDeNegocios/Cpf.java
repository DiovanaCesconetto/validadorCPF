/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regrasDeNegocios;

import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Diovana
 */
public class Cpf {

    private int Cpf[];

    public boolean validarCpf(int[] vetorCpf) {
        int digCalc1 = 0, digCalc2 = 0, dig1 = 0, resto1 = 0, resto2 = 0, dig2 = 0;
        boolean valido = false;
        int[] validadorCpf1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] validadorCpf2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        if (vetorCpf.length == 11) {
            int digito1 = vetorCpf[9];
            int digito2 = vetorCpf[10];

            for (int i = 0; i < 9; i++) {
                digCalc1 += validadorCpf1[i] * vetorCpf[i];
            }
            resto1 = (digCalc1 % 11);
            if (resto1 < 2) {
                dig1 = 0;
            } else {
                dig1 = 11 - resto1;
            }

            for (int i = 0; i < 10; i++) {
                digCalc2 += validadorCpf2[i] * vetorCpf[i];
            }

            resto2 = (digCalc2 % 11);
            if (resto2 < 2) {
                dig2 = 0;
            } else {
                dig2 = 11 - resto2;
            }
            if (dig1 == digito1 && digito2 == dig2) {
                valido = true;
            }
        }
        return valido;
    }

    public int[] StringParaInt(String valor) {
        char[] vetorConverte = valor.toCharArray();
        int[] vetorInt = new int[vetorConverte.length];

        for (int i = 0; i < vetorConverte.length; i++) {
            vetorInt[i] = Integer.parseInt(String.valueOf(vetorConverte[i]));
        }
        return vetorInt;
    }

    public void VerificarCpf(boolean valido) {
        Mensagens m = new Mensagens("Validacao CPF");
        if (valido == true) {
            m.informacao("O CPF informado é válido");
        } else {
            m.alerta("O CPF informado é inválido");
        }
    }

    public String gerarDvCpf(int[] vetorCpf) {
        int digCalc1 = 0, digCalc2 = 0, dig1 = 0, resto1 = 0, resto2 = 0, dig2 = 0;
        String vetorString = "";

        int[] validadorCpf1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] validadorCpf2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] cpfPronto = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] vetorCpfAux = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        if (vetorCpf.length == 9) {
            System.arraycopy(vetorCpf, 0, vetorCpfAux, 0, Math.min(9, 11));

            for (int i = 0; i < 9; i++) {
                digCalc1 += validadorCpf1[i] * vetorCpfAux[i];
            }
            resto1 = (digCalc1 % 11);

            if (resto1 < 2) {
                dig1 = 0;
            } else {
                dig1 = 11 - resto1;
            }

            for (int x = 0; x < 10; x++) {
                if (x == 9) {
                    vetorCpfAux[x] = dig1;
                }

            }
            for (int j = 0; j < 10; j++) {
                digCalc2 += validadorCpf2[j] * vetorCpfAux[j];
            }

            resto2 = (digCalc2 % 11);
            if (resto1 < 2) {
                dig2 = 0;
            } else {
                dig2 = 11 - resto2;
            }

            for (int x = 0; x < 11; x++) {
                cpfPronto[x] = vetorCpfAux[x];
                if (x == 10) {
                    cpfPronto[x] = dig2;
                }
            }
            for (int x = 0; x < 11; x++) {
                //converter o vetor em uma String direta
                vetorString += Integer.toString(cpfPronto[x]);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário Informar 9 números para validar");
        }
        return vetorString;
    }

    public String gerarCpfAleatorio() {
        int digCalc1 = 0, digCalc2 = 0, dig1 = 0, resto1 = 0, resto2 = 0, dig2 = 0;
        boolean valido = false;
        String vetorString = "";
        int[] validadorCpf1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] validadorCpf2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] vetorCpf = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        Random ale = new Random();
        //Random classe para gerar números aleatórios
        for (int i = 0; i < 9; i++) {
            vetorCpf[i] = ale.nextInt(9);
        }

        for (int j = 0; j < 9; j++) {
            digCalc1 += validadorCpf1[j] * vetorCpf[j];
        }
        resto1 = (digCalc1 % 11);
        if (resto1 < 2) {
            dig1 = 0;
        } else {
            dig1 = 11 - resto1;
        }

        for (int x = 0; x < 10; x++) {
            if (x == 9) {
                vetorCpf[x] = dig1;
            }
            digCalc2 += validadorCpf2[x] * vetorCpf[x];

        }
        
        resto2 = (digCalc2 % 11);
        if (resto2 < 2) {
            dig2 = 0;
        } else {
            dig2 = 11 - resto2;
        }

        for (int x = 0; x < 11; x++) {
            if (x == 10) {
                vetorCpf[x] = dig2;
            }
        }
        for (int x = 0; x < 11; x++) {
            vetorString += Integer.toString(vetorCpf[x]);
        }

        return vetorString;
    }

}
