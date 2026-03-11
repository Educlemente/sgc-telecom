package br.com.sgc.domain.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String login; // Vamos usar o e-mail como login

    @Column(nullable = false)
    private String senha; // Aqui vai ficar a senha criptografada (hash)

    // Construtor vazio
    public Usuario() {}

    // Getters e Setters Padrões
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    // ====================================================================
    // MÉTODOS OBRIGATÓRIOS DO CONTRATO DO SPRING SECURITY (UserDetails)
    // ====================================================================

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Por enquanto, todo usuário cadastrado terá o perfil padrão "ROLE_USER"
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha; // Avisa o Spring onde está a senha
    }

    @Override
    public String getUsername() {
        return login; // Avisa o Spring onde está o login
    }

    // Daqui para baixo, estamos dizendo que as contas nunca expiram ou bloqueiam
    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }
}