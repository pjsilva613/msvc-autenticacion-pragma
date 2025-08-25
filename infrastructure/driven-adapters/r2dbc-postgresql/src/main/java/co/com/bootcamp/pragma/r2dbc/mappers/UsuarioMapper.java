package co.com.bootcamp.pragma.r2dbc.mappers;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import co.com.bootcamp.pragma.r2dbc.entities.UsuarioEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioEntity usuarioEntity) {
        if(Objects.isNull(usuarioEntity)) {
            return null;
        }

        return Usuario.builder()
                .tipoDocumento(usuarioEntity.getTipoDocumento())
                .numeroDocumento(usuarioEntity.getNumeroDocumento())
                .nombres(usuarioEntity.getNombres())
                .apellidos(usuarioEntity.getApellidos())
                .direccion(usuarioEntity.getDireccion())
                .telefono(usuarioEntity.getTelefono())
                .correoElectronico(usuarioEntity.getCorreoElectronico())
                .build();
    }
}
