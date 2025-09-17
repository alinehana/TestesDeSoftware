/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.testesdesoftware2;

/**
 *
 * @author aline
 */
public class AuthController {
    private final AuthDao dao;
    
    public AuthController(AuthDao dao){
        this.dao = dao;
    }
    
    public boolean login(String username, String password) {
        if (!dao.existsByUsername(username)){
            return false;
        }
        String hash = dao.getPasswordHash(username);
        return password.hashCode() == Integer.parseInt(hash);
    }
}
