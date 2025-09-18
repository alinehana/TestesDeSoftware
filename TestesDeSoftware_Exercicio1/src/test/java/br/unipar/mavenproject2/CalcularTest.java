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
public class CalcularTest {
    
    private Calcular calc;
    
    public CalcularTest() {
        calc = new Calcular();
    }
    
    //deixar apenas o setup em outros projetos
    @BeforeEach
    public void setUp() {
    }

    //alterar para @Test em outros projetos
    @Test
    public void testSomarValores() {
        //retorna um valor específico
        assertEquals(4, calc.somarValores(2,2));  

    }

}
