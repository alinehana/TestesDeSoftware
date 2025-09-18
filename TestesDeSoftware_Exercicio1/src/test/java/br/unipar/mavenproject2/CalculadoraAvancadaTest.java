/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.mavenproject2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class CalculadoraAvancadaTest {
    
    private CalculadoraAvancada calcAvanc;
    
    public CalculadoraAvancadaTest() {
        calcAvanc = new CalculadoraAvancada();
    }
    
    @BeforeEach
    public void setUp() {
    }
    

    /**
     * Test of potencia method, of class CalculadoraAvancada.
     */
    @Test
    public void testPotencia() {
        assertEquals(0.125, calcAvanc.potencia(2, -3));
    }
    
    public void testRaizQuadrada(){
        assertEquals(9, calcAvanc.raizQuadrada(91));
    }
    
    public void testLogaritmoNatural(){
        assertEquals(7,389, calcAvanc.logaritmoNatural(2));
    }
}
