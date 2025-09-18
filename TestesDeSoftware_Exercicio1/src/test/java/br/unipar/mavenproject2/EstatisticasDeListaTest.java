/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.mavenproject2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class EstatisticasDeListaTest {
private EstatisticasDeLista estatisticas;

    @BeforeEach
    public void setUp() {
        estatisticas = new EstatisticasDeLista();
    }

    @Test
    public void testCalcularMedia() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 6.0, 8.0);
        double media = estatisticas.calcularMedia(numeros);
        assertEquals(5.0, media);
    }

    @Test
    public void testCalcularMedianaListaImpar() {
        List<Double> numeros = Arrays.asList(3.0, 1.0, 2.0);
        double mediana = estatisticas.calcularMediana(numeros);
        assertEquals(2.0, mediana);
    }

    @Test
    public void testCalcularMedianaListaPar() {
        List<Double> numeros = Arrays.asList(1.0, 2.0, 3.0, 4.0);
        double mediana = estatisticas.calcularMediana(numeros);
        assertEquals(2.5, mediana);
    }

    @Test
    public void testCalcularDesvioPadrao() {
        List<Double> numeros = Arrays.asList(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0);
        double desvio = estatisticas.calcularDesvioPadrao(numeros);
        assertEquals(2.0, desvio, 0.0001); // tolerância de precisão
    }

    @Test
    public void testListaVaziaLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> {
            estatisticas.calcularMedia(Collections.emptyList());
        });
    }

    @Test
    public void testListaComValoresNulos() {
        List<Double> numeros = Arrays.asList(1.0, null, 3.0, null, 5.0);
        double media = estatisticas.calcularMedia(numeros);
        assertEquals(3.0, media);
    }

    @Test
    public void testListaSomenteComNulos() {
        List<Double> numeros = Arrays.asList(null, null, null);
        assertThrows(IllegalArgumentException.class, () -> {
            estatisticas.calcularMedia(numeros);
        });
    }
}