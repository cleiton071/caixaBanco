import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CaixaBanco caixa1 = new CaixaBanco();
        Scanner scan = new Scanner(System.in);
        caixa1.setUsuarios();

        Integer escolha = -1;

        System.out.println("Caixa Eletronico");

        while (escolha != 5) {

            System.out.print("\n1- login\n2- registro\n3- saque\n4- deposito\n5- sair\n\n");
            escolha = scan.nextInt();
            scan.nextLine();

            switch (escolha) {

                case 1:
                    System.out.printf("cpf: ");
                    String cpf = scan.nextLine();

                    System.out.printf("senha: ");
                    String senha = scan.nextLine();

                    caixa1.logar(cpf, senha);
                    break;

                case 2:
                    System.out.printf("cpf: ");
                    String cpf_ = scan.nextLine();

                    System.out.printf("senha: ");
                    String senha_ = scan.nextLine();

                    System.out.printf("nome: ");
                    String nome_ = scan.nextLine();

                    caixa1.registra(cpf_, senha_, nome_);
                    break;

                case 3:
                    System.out.printf("informe o valor que deseja sacar: ");
                    Double saque = scan.nextDouble();
                    caixa1.sacar(saque);
                    break;

                case 4:
                    System.out.printf("informe o valor que vai ser depositado: ");
                    Double deposito = scan.nextDouble();
                    caixa1.depositar(deposito);
                    break;

                case 5:
                    System.out.println("Sistema finalizado");
                    break;
            }
        }
    }
}
