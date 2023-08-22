package com.sbk.api.controller;

import com.sbk.api.domain.user.*;
import com.sbk.api.infra.security.TokenJwtDataDto;
import com.sbk.api.infra.security.TokenService;
import com.sbk.api.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager maneger;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserDadosAutenticacao dados){
        var authToken = new UsernamePasswordAuthenticationToken(dados.nome(), dados.senha());
        var authentication = maneger.authenticate(authToken);

        var tokenJWT = tokenService.genereteToken((UserModel) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(new TokenJwtDataDto(tokenJWT));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarUser(@RequestBody @Valid UserDto userDto){
        var user = new UserModel(userDto);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserExibirDadosDto(user));
    }

    @GetMapping
    public ResponseEntity<Page<UserExibirDadosDto>> listarUsers(@PageableDefault Pageable pageable){
        var page = userRepository.findAll(pageable).map(UserExibirDadosDto::new);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibirDadosUser(@PathVariable(value = "id") Long id){
        var user = userRepository.getReferenceById(id);

        return ResponseEntity.status(HttpStatus.OK).body(new UserExibirDadosDto(user));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarDadosUser(@PathVariable(value = "id") Long id, @RequestBody @Valid UserEditarDadosDto dadosDto){
        var user = userRepository.getReferenceById(id);
        user.editarDados(dadosDto);

        return ResponseEntity.status(HttpStatus.OK).body(new UserExibirDadosDto(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirUser(@PathVariable(value = "id") Long id){
        var user = userRepository.getReferenceById(id);
        userRepository.delete(user);

        return ResponseEntity.status(HttpStatus.OK).body("User Excluido com Sucesso!");
    }
}
