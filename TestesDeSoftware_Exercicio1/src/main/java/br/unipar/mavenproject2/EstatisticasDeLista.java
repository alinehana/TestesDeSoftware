/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.mavenproject2;

import java.util.List;

/**
 *
 * @author aline
 */
public class EstatisticasDeLista {
    public double calcularMedia(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia ou nula.");
        }

        double soma = 0;
        int count = 0;

        for (Double num : numeros) {
            if (num != null) {
                soma += num;
                count++;
            }
        }

        if (count == 0) {
            throw new IllegalArgumentException("Lista não contém valores válidos.");
        }

        return soma / count;
    }

    public double calcularMediana(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia ou nula.");
        }

        List<Double> listaOrdenada = numeros.stream()
                .filter(n -> n != null)
                .sorted()
                .toList();

        if (listaOrdenada.isEmpty()) {
            throw new IllegalArgumentException("Lista não contém valores válidos.");
        }

        int size = listaOrdenada.size();
        if (size % 2 == 0) {
            return (listaOrdenada.get(size / 2 - 1) + listaOrdenada.get(size / 2)) / 2.0;
        } else {
            return listaOrdenada.get(size / 2);
        }
    }

    public double calcularDesvioPadrao(List<Double> numeros) {
        if (numeros == null || numeros.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia ou nula.");
        }

        List<Double> listaValida = numeros.stream()
                .filter(n -> n != null)
                .toList();

        if (listaValida.isEmpty()) {
            throw new IllegalArgumentException("Lista não contém valores válidos.");
        }

        double media = calcularMedia(listaValida);
        double somaQuadrados = 0;

        for (Double num : listaValida) {
            somaQuadrados += Math.pow(num - media, 2);
        }

        return Math.sqrt(somaQuadrados / listaValida.size());
    }
}