/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.unipar.testesdesoftware2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aline
 */
public class AuthControllerTest {
    private AuthController controller;
    
    // Mock simples do AuthDao para testes
    class MockAuthDao implements AuthDao {
        private final String existingUser  = "user1";
        private final String passwordHash = Integer.toString("password123".hashCode());
        @Override
        public boolean existsByUsername(String username) {
            return existingUser .equals(username);
        }
        @Override
        public String getPasswordHash(String username) {
            if (existingUser .equals(username)) {
                return passwordHash;
            }
            return null;
        }
    }
    
    @BeforeEach
    public void setUp() {
        AuthDao dao = new MockAuthDao();
        controller = new AuthController(dao);
    }

    @Test
    public void testLoginSuccess() {
        boolean result = controller.login("user1", "password123");
        assertTrue(result, "Login deve ser bem-sucedido para usuário existente com senha correta");
    }
    
    @Test
    public void testLoginUserNotExists() {
        boolean result = controller.login("nonexistent", "password123");
        assertFalse(result, "Login deve falhar para usuário que não existe");
    }
    
    @Test
    public void testLoginWrongPassword() {
        boolean result = controller.login("user1", "wrongpassword");
        assertFalse(result, "Login deve falhar para senha incorreta");
    }
    
}
