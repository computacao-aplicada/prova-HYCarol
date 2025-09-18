public class Validador {

    public static boolean validarCPF(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) return false; //Verifica se o cpf eh nulo
        String limpo = cpf.trim().replaceAll("[.-]", ""); //remove espacos externos e mascaras
        if (!limpo.matches("\\d{11}")) return false; //Deve conter 11 digitos
        if (limpo.chars().distinct().count() == 1) return false; //Nao pode conter todos os digitos iguais
        // TODO: calcular DV
        return checarDigitos(limpo); //Chama o metodo para checar os digitos
    }

    private static boolean checarDigitos(String cpf) {
        int[] d = cpf.chars().map(c -> c - '0').toArray(); //converte a string em array de inteiros
        // DV1
        int s1 = 0;
        for (int i = 0; i < 9; i++) s1 += d[i] * (10 - i);
        int r1 = s1 % 11;
        int dv1 = (r1 < 2) ? 0 : 11 - r1;
        if (d[9] != dv1) return false;
        // DV2
        int s2 = 0;
        for (int i = 0; i < 10; i++) s2 += d[i] * (11 - i);
        int r2 = s2 % 11;
        int dv2 = (r2 < 2) ? 0 : 11 - r2;
        return d[10] == dv2;
    }
}
