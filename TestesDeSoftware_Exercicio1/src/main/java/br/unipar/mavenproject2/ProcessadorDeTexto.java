/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.mavenproject2;

/**
 *
 * @author aline
 */
public class ProcessadorDeTexto {
    public String inverterPalavras(String frase) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }
        String[] palavras = frase.split(" ");
        StringBuilder invertida = new StringBuilder();
        for (int i = palavras.length - 1; i >= 0; i--) {
            invertida.append(palavras[i]);
            if (i > 0) {
                invertida.append(" ");
            }
        }
        return invertida.toString();
    }

    public String substituirPalavras(String frase, String palavraAntiga, String palavraNova) {
        if (frase == null || frase.isEmpty()) {
            return frase;
        }
        return frase.replace(palavraAntiga, palavraNova);
    }

    public int contarOcorrenciasDePalavra(String frase, String palavra) {
        if (frase == null || frase.isEmpty() || palavra == null || palavra.isEmpty()) {
            return 0;
        }
        String[] palavras = frase.split(" ");
        int contador = 0;
        for (String p : palavras) {
            if (p.equals(palavra)) {
                contador++;
            }
        }
        return contador;
    }
}