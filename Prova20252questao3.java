import java.util.Scanner;

public class Prova20252questao3 {
public static int inserirSortCliente(Conta[] v, int tam) {

    if (tam >= TAM_CONTAS) {
        System.out.println("Vetor de contas cheio!");
        return -1;
    }

    Conta nova = new Conta();

    System.out.print("Digite o ID: ");
    nova.id = sc.nextInt();
    sc.nextLine();

    System.out.print("Digite o nome do cliente: ");
    nova.cliente = sc.nextLine();

    System.out.print("Digite o saldo: ");
    nova.saldo = sc.nextDouble();

    do {
        System.out.print("Digite o limite: ");
        nova.limite = sc.nextDouble();

        if (nova.limite < 0) {
            System.out.println("Limite invalido!");
        }

    } while (nova.limite < 0);

    int pos = tam;

    while (pos > 0 &&
           v[pos - 1].cliente.compareToIgnoreCase(nova.cliente) > 0) {

        v[pos] = v[pos - 1];

        pos--;
    }

    v[pos] = nova;

    System.out.println("Conta inserida na posicao " + pos);

    return pos;
}

}
