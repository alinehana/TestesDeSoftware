/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware2;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.verify;

/**
 *
 * @author aline
 */
public class NotificacaoControllerTest {
    private EmailService emailServiceMock;
    private NotificacaoController controller;
    
    public NotificacaoControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        emailServiceMock = Mockito.mock(EmailService.class);
        controller = new NotificacaoController(emailServiceMock);
    }

    @Test
    public void testNotificarUsuario() {
        String email = "teste@exemplo.com";
        String nome = "Aline";

        controller.notificarUsuario(email, nome);

        // monta a mensagem esperada
        String mensagemEsperada = "Olá," + nome + "! Seja bem-vindo!";

        // verifica que o método enviarEmail foi chamado com os parâmetros corretos
        verify(emailServiceMock).enviarEmail(email, mensagemEsperada);
    }
}
