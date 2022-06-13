import java.util.ArrayList;

public class CaixaBanco {
    private String usuarioLogado;
    private Boolean logado = false;

//    private ArrayList<Object> usuarios = new ArrayList<>();

    Usuario user1 = new Usuario(50.00,"111.222.333-21","2123","cleiton");


    public Boolean verificaLogin(String cpf,String senha, String nomeDeUsuario) {
        if (logado) {
            if (user1.getCpf() == cpf) {
                return true;
            } else {
                logado = true;
                user1.setCpf(cpf) ;
                user1.setSenha(senha);
                this.usuarioLogado = user1.getNome();
                return true;
            }
        }

        logado = true;
        user1.setCpf(cpf);
        user1.setSenha(senha);
        this.usuarioLogado = user1.getNome();

        return true;
    }

    public void logar(String cpf, String senha, String nomeDeUsuario) {
        verificaLogin(cpf, nomeDeUsuario, senha);
        System.out.printf("usuario logado: %s", this.usuarioLogado);

    }

    public void depositar(Double valor) {
        user1.setSaldo(valor + user1.getSaldo());
        System.out.printf("\nsaldo atual: %.2f", user1.getSaldo());
    }

    public void sacar(Double valor) {
        if (user1.getSaldo() - valor < -600.00) {
            System.out.println("\nsaque não realizado, limite de crédito ultrapassado");
        } else {
            user1.setSaldo(user1.getSaldo() - valor);
            System.out.printf("\no valor atual: %.2f", user1.getSaldo());
        }
    }
}