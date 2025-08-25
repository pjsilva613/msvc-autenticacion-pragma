package co.com.bootcamp.pragma.model.usuario.gateways;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import reactor.core.publisher.Mono;

public interface UsuarioRepository {
    Mono<Usuario> findByNumeroDocumento(String numeroDocumento);
    Mono<Usuario> save(Usuario usuario);
}
