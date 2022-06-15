import java.util.ArrayList;

public class CaixaBanco {
    private Integer usuarioLogado;
    private Boolean logado = false;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void setUsuarios(){
        usuarios.add(new Usuario(50.00,"111.222.333-21","2123","cleiton"));
    }

    public Integer verificaLogin(String cpf) {
        if (logado) {

            return -2;
        }

        Integer i = 0, userExist = -1;

        for (i=0; i<usuarios.size(); i++) {
            if (cpf.equals(usuarios.get(i).getCpf())) {
                userExist = i;
                break;
            }
        }
        return userExist;
    }

    public void logar(String cpf, String senha) {
        Integer userExist = verificaLogin(cpf);
        if (userExist == -1){
            System.out.println("o usuario digitado não existe.");
        }
        else if (userExist == -2) {
            System.out.println("já existe um usuario logado no sistema.\npor favor faça logout primeiro.");
        }
        else {
            if (senha.equals(usuarios.get(userExist).getSenha())) {
                usuarioLogado = userExist;
                logado = true;
                System.out.printf("usuario logado: %s",usuarios.get(usuarioLogado).getNome());
            }
            else{
                System.out.printf("senha incorreta");
            }
        }
    }

    public void depositar(Double valor) {
        usuarios.get(usuarioLogado).setSaldo(usuarios.get(usuarioLogado).getSaldo() + valor);
        System.out.printf("\nsaldo atual: %.2f", usuarios.get(usuarioLogado).getSaldo());
    }

    public void sacar(Double valor) {
        if ((usuarios.get(usuarioLogado).getSaldo() - valor) < -600) {
            System.out.println("\nsaque não realizado, limite de crédito ultrapassado");
        } else {
            usuarios.get(usuarioLogado).setSaldo(usuarios.get(usuarioLogado).getSaldo() - valor);
            System.out.printf("\no valor atual: %.2f", usuarios.get(usuarioLogado).getSaldo());
        }
    }

    public void registra(String cpf, String senha, String nome) {
        usuarios.add(new Usuario(00.00, cpf, senha, nome));
        System.out.printf("\no usuario: %s foi cadastrado com sucesso!", nome);
    }
}