package org.gouveia.exception;

public class ParametrosInvalidosException extends RuntimeException {
    public ParametrosInvalidosException() {
        super("Erro: O segundo parâmetro deve ser maior que o primeiro.");
    }
}
