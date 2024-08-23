package br.com.guilhermekellermann.gestao_vagas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PrimeiroTeste {

    @Test
    public void deve_ser_possivel_calcular_dois_numeros() {
        var result = calculate(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void validar_valor_incorreto() {
        var result = calculate(2, 3);
        assertEquals(5, result);
    }
    
    public static int calculate(int num1, int num2) {
        return num1 + num2;
    }
}
