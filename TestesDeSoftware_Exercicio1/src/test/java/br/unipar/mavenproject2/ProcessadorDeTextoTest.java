/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.mavenproject2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class ProcessadorDeTextoTest {
    private final ProcessadorDeTexto processador = new ProcessadorDeTexto();

    public ProcessadorDeTextoTest() {
    }

    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testInverterPalavras() {
        String frase = "Eu gosto de Java";
        String resultado = processador.inverterPalavras(frase);
        assertEquals("Java de gosto Eu", resultado);
    }

    @Test
    public void testSubstituirPalavras() {
        String frase = "O cachorro correu rápido";
        String resultado = processador.substituirPalavras(frase, "cachorro", "gato");
        assertEquals("O gato correu rápido", resultado);
    }

    @Test
    public void testContarOcorrenciasDePalavra() {
        String frase = "gato cachorro gato pássaro gato";
        int ocorrencias = processador.contarOcorrenciasDePalavra(frase, "gato");
        assertEquals(3, ocorrencias);
    }

    @Test
    public void testComStringsVaziasOuNulas() {
        assertNull(processador.inverterPalavras(null));
        assertEquals("", processador.inverterPalavras(""));
        assertEquals("", processador.substituirPalavras("", "a", "b"));
        assertEquals(0, processador.contarOcorrenciasDePalavra(null, "teste"));
    }
}