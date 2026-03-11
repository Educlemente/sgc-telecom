package br.com.sgc.controller;

import br.com.sgc.domain.model.Usuario;
import br.com.sgc.dto.DadosLogin;
import br.com.sgc.repository.UsuarioRepository;
import br.com.sgc.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    // A rota que você já tinha testado antes
    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario novoUsuario) {
        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senhaCriptografada);
        return repository.save(novoUsuario);
    }

    // A NOVA ROTA DE LOGIN
    @PostMapping("/login")
    public String efetuarLogin(@RequestBody DadosLogin dados) {
        // Empacota o e-mail e a senha que o usuário digitou
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        
        // O Spring vai no banco, pega o hash e compara com a senha digitada. Se bater, ele aprova!
        var authentication = manager.authenticate(authenticationToken);
        
        // Se aprovou, chama a nossa fábrica e devolve o Token JWT
        return tokenService.gerarToken((Usuario) authentication.getPrincipal());
    }
}