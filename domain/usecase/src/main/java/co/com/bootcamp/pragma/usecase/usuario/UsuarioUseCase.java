package co.com.bootcamp.pragma.usecase.usuario;

import co.com.bootcamp.pragma.model.usuario.dto.UsuarioDto;
import co.com.bootcamp.pragma.model.usuario.factorias.UsuarioDtoFactory;
import co.com.bootcamp.pragma.model.usuario.factorias.UsuarioFactory;
import co.com.bootcamp.pragma.model.usuario.gateways.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static co.com.bootcamp.pragma.model.exceptions.negocio.BusinessException.Tipo.ERROR_USUARIO_YA_EXISTE;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    public Mono<UsuarioDto> registrar(UsuarioDto usuarioDto) {{
        return Mono.just(usuarioDto.numeroDocumento())
                .flatMap(usuarioRepository::findByNumeroDocumento)
                .doOnNext( usuarioExiste -> {
                    throw ERROR_USUARIO_YA_EXISTE.build();
                })
                .switchIfEmpty(Mono.just(UsuarioFactory.crearUsuario(usuarioDto)))
                .flatMap(usuarioRepository::save)
                .map(UsuarioDtoFactory::crearUsuarioDto);
    }
    }
}
