package co.com.bootcamp.pragma.r2dbc;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import co.com.bootcamp.pragma.model.usuario.gateways.UsuarioRepository;
import co.com.bootcamp.pragma.r2dbc.entities.UsuarioEntity;
import co.com.bootcamp.pragma.r2dbc.helper.ReactiveAdapterOperations;
import co.com.bootcamp.pragma.r2dbc.mappers.UsuarioMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class MyReactiveRepositoryAdapter extends ReactiveAdapterOperations<
        Usuario,
        UsuarioEntity,
    String,
    MyReactiveRepository
> implements UsuarioRepository {
    public MyReactiveRepositoryAdapter(MyReactiveRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Usuario.class));
    }

    @Override
    public Mono<Usuario> findByNumeroDocumento(String numeroDocumento) {
        return repository.findByNumeroDocumento(numeroDocumento).map(entity -> UsuarioMapper.toUsuario(entity));
    }
}
