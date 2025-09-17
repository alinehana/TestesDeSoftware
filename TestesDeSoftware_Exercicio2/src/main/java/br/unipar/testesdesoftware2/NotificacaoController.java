/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public class NotificacaoController {
    private final EmailService emailService;

    public NotificacaoController (EmailService emailService) {
        this.emailService = emailService;
    }

    public void notificarUsuario (String email, String nome) {
        String mensagem = "Olá," + nome+ "! Seja bem-vindo!";
        emailService.enviarEmail (email, mensagem);
    }
}
