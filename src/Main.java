import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);

        CaixaBanco caixa1 = new CaixaBanco();



//        caixa1.logar("111.222.333-11",  "22", "cleiton");
//        caixa1.depositar(50.07);
//        caixa1.sacar(650.08);
        System.out.printf("cpf: %s\nvalor: %.2f", caixa1.user1.getCpf(), caixa1.user1.getSaldo());
    }
}
