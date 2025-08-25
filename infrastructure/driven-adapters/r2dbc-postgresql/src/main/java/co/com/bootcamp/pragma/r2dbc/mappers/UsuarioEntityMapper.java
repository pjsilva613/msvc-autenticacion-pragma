package co.com.bootcamp.pragma.r2dbc.mappers;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import co.com.bootcamp.pragma.r2dbc.entities.UsuarioEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioEntityMapper {

    public static UsuarioEntity toData(Usuario usuario) {
        if(Objects.isNull(usuario)) {
            return null;
        }

        return UsuarioEntity.builder().tipoDocumento(usuario.getTipoDocumento())
                .numeroDocumento(usuario.getNumeroDocumento())
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .correoElectronico(usuario.getCorreoElectronico())
                .build();
    }

}
