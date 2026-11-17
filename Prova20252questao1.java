import java.util.Scanner;

public class Prova20252questao1 {
  static final int TAM_CONTAS = 10;
  static Scanner sc = new Scanner(System.in);

  public static int cadastrarConta(Conta[] v,  int tam) {

    if (tam >= TAM_CONTAS) {
        System.out.println("Vetor de contas cheio!");
        return -1;
    }

    Conta nova = new Conta();

    System.out.print("Digite o ID da conta:  ");
    nova.id = sc.nextInt();
    sc.nextLine();

    System.out.print("Digite o nome do cliente:  ");
    nova.cliente = sc.nextLine();

    System.out.print("Digite o saldo:  ");
    nova.saldo = sc.nextDouble();

    do {
        System.out.print("Digite o limite:  ");
        nova.limite = sc.nextDouble();

        if (nova.limite < 0) {
            System.out.println("O limite nao pode ser negativo!");
        }

    } while (nova.limite < 0);

    v[tam] = nova;

    System.out.println("Conta cadastrada com sucesso!");

    return tam;
}

  public static void main(String[] args) {
    Conta[] contas = new Conta[TAM_CONTAS];
    int indice = cadastrarConta(contas, 0);
    System.out.println("Indice: " + indice);
  }
}

class Conta {
  int id;
  String cliente;
  double saldo;
  double limite;
}
