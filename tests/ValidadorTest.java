import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ValidadorTest {

    //Testa para ver se o cpf eh correto com ou sem a mascara
    @Test
    void deveValidarCPFValido() {
        assertTrue(Validador.validarCPF("529.982.247-25"));
        assertTrue(Validador.validarCPF("52998224725"));
    }

    //Rejeita o teste com entrada errada
    @Test
    void deveRejeitarEntradasInvalidas() {
        assertFalse(Validador.validarCPF(null));
        assertFalse(Validador.validarCPF(""));
        assertFalse(Validador.validarCPF("529.982.247-2X"));
        assertFalse(Validador.validarCPF("00000000000"));
    }

    //Rejeita com o cpf com tamanho que nao seja de 10 ou de 12 digitos
    @Test
    void deveRejeitarTamanhosIncorretos() {
        assertFalse(Validador.validarCPF("935.411.347-8"));   // 10 dígitos
        assertFalse(Validador.validarCPF("935.411.347-800")); // 12 dígitos
    }

    //Faz o calculo do DV e rejeita o incorreto
    @Test
    void deveRejeitarDVIncorreto() {
        assertFalse(Validador.validarCPF("529.982.247-24"));
        assertFalse(Validador.validarCPF("123.456.789-00"));
    }

}
