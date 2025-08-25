package co.com.bootcamp.pragma.api.controllers;

import co.com.bootcamp.pragma.model.usuario.dto.UsuarioDto;
import co.com.bootcamp.pragma.usecase.usuario.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class UsuariosController {

    private final UsuarioUseCase usuarioUseCase;

    @PostMapping
    public Mono<ResponseEntity<UsuarioDto>> registrar(@RequestBody UsuarioDto usuarioDto,
                                                              final ServerHttpRequest request) {
        return usuarioUseCase.registrar(usuarioDto)
                .map(usuario ->
                        ResponseEntity
                                .created(
                                        URI.create(request.getURI()
                                                .toString()
                                                .concat("/")
                                                .concat(
                                                        usuarioDto.tipoDocumento())))
                                .body(usuario)
                );
    }
}
