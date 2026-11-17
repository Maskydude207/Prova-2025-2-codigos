import java.util.Scanner;

public class Prova20252questao5 {
public static void extrato(
        Conta[] vContas,
        int tamConta,
        Operacao[] vOp,
        int tamOp,
        Operacao[] vOpFiltrado,
        int x) {


    int posConta = buscaIDConta(vContas, tamConta, x);

    if (posConta == -1) {
        System.out.println("Conta nao encontrada!");
        return;
    }

    Conta conta = vContas[posConta];

  
    int qtd = filtraOperacoes(vOp, tamOp, vOpFiltrado, x);

   
    int inicio = Math.max(0, qtd - 5);

    double saldo = 0;

 
    for (int i = 0; i < inicio; i++) {

        saldo += calcularVariacao(vOpFiltrado[i]);
    }

    DecimalFormat df = new DecimalFormat("0.00");

    System.out.println("\n========================================");
    System.out.println("                 CONTA");
    System.out.println("========================================");

    System.out.println("CLIENTE: " + conta.cliente);
    System.out.println("N.001: " + conta.id);

    System.out.println("----------------------------------------");
    System.out.println("ID | OPERACAO | VALOR | SALDO");
    System.out.println("----------------------------------------");

 
    for (int i = inicio; i < qtd; i++) {

        Operacao op = vOpFiltrado[i];

        double variacao = calcularVariacao(op);

        saldo += variacao;

        String descricao = "";

        switch (op.tipo) {

            case 'D':
                descricao = "Deposito";
                break;

            case 'S':
                descricao = "Saque";
                break;

            case 'T':
                descricao = "Transferencia";
                break;
        }

        String creditoDebito = (variacao >= 0) ? "C" : "D";

        System.out.println(
            op.id + " | " +
            descricao + " | " +
            df.format(Math.abs(op.valor)) + " " +
            creditoDebito + " | " +
            df.format(Math.abs(saldo)) +
            ((saldo >= 0) ? "C" : "D")
        );
    }

    System.out.println("----------------------------------------");
    System.out.println("Saldo Atual: " +
        df.format(Math.abs(saldo)) +
        ((saldo >= 0) ? "C" : "D"));

    System.out.println("========================================");


    conta.saldo = saldo;
}



}
