package co.com.bootcamp.pragma.model.exceptions.negocio;

import co.com.bootcamp.pragma.model.exceptions.tecnicas.BaseException;
import lombok.Getter;

public class BusinessException extends BaseException {
    public enum Tipo {
        ERROR_USUARIO_YA_EXISTE("Ya existe un usuario registrado con el mismo numero de Documento", 400);


        @Getter
        private final String message;

        @Getter
        private final int httpStatusCode;

        Tipo(String message, int httpStatusCode) {
            this.message = message;
            this.httpStatusCode = httpStatusCode;
        }

        public BusinessException build() {
            return new BusinessException(this);
        }
    }
    public BusinessException(Tipo tipo) {
        super(tipo.getMessage(), tipo.getHttpStatusCode());
    }
}
