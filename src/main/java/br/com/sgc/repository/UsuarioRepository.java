package br.com.sgc.repository;

import br.com.sgc.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // O Spring Data lê o "findByLogin" e automaticamente cria o SQL: 
    // SELECT * FROM usuarios WHERE login = ?
    UserDetails findByLogin(String login);
    
}