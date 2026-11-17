import java.util.Scanner;

public class Prova20252questao2 {
public static int buscaBinariaCliente(Conta[] v, int tam, String x) {

    int inicio = 0;
    int fim = tam - 1;

    while (inicio <= fim) {

        int meio = (inicio + fim) / 2;

        int resultado = v[meio].cliente.compareToIgnoreCase(x);

        if (resultado == 0) {
            return meio;
        }

        if (resultado < 0) {
            inicio = meio + 1;
        } else {
            fim = meio - 1;
        }
    }

    return -1;
}

}
