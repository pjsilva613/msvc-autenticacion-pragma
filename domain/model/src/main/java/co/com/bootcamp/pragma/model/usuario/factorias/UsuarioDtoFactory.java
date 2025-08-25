package co.com.bootcamp.pragma.model.usuario.factorias;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import co.com.bootcamp.pragma.model.usuario.dto.UsuarioDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioDtoFactory {
    public static UsuarioDto crearUsuarioDto(Usuario usuario) {
        return UsuarioDto.builder()
                .tipoDocumento(usuario.getTipoDocumento())
                .numeroDocumento(usuario.getNumeroDocumento())
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .direccion(usuario.getDireccion())
                .telefono(usuario.getTelefono())
                .correoElectronico(usuario.getCorreoElectronico())
                .build();
    }
}
