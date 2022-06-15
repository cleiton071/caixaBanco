import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner  scan = new Scanner(System.in);
        CaixaBanco caixa1 = new CaixaBanco();
        caixa1.setUsuarios();
        caixa1.logar("111.222.333-21", "2123");
        caixa1.registra("222.333.444-1", "222", "alex");
    }
}
