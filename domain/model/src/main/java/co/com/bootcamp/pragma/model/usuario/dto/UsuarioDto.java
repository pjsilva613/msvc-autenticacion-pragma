package co.com.bootcamp.pragma.model.usuario.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record UsuarioDto(
        String tipoDocumento,
        String numeroDocumento,
        String nombres,
        String apellidos,
        String direccion,
        String telefono,
        String correoElectronico,
        Boolean estado) implements Serializable {
}
