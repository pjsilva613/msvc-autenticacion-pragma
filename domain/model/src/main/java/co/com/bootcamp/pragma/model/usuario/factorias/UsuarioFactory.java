package co.com.bootcamp.pragma.model.usuario.factorias;

import co.com.bootcamp.pragma.model.usuario.Usuario;
import co.com.bootcamp.pragma.model.usuario.dto.UsuarioDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsuarioFactory {

    public static Usuario crearUsuario(UsuarioDto usuarioDto) {

        return Usuario.builder()
                .tipoDocumento(usuarioDto.tipoDocumento())
                .numeroDocumento(usuarioDto.numeroDocumento())
                .nombres(usuarioDto.nombres())
                .apellidos(usuarioDto.apellidos())
                .direccion(usuarioDto.direccion())
                .telefono(usuarioDto.telefono())
                .correoElectronico(usuarioDto.correoElectronico())
                .build();
    }
}
