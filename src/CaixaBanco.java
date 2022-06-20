import java.util.ArrayList;

public class CaixaBanco {
    private Integer usuarioLogado;
    private Boolean logado = false;
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void setUsuarios(){
        usuarios.add(new Usuario(00.00, "324.360.618-74", "123", "Narciso"));
    }

    public Integer verificaLogin(String cpf) {
        if (logado) {
            return -2;
        }

        Integer i = 0, userExist = -1;
        for (i=0; i<usuarios.size(); i++){
            if (cpf.equals(usuarios.get(i).getCpf())){
               userExist = i;
               break;
            }
        }
        return userExist;

    }
    public void logar(String cpf, String senha) {
        Integer userExist = verificaLogin(cpf);
         if (userExist == -1){
             System.out.println("Usuario digitado nao exite");
         }
         else if (userExist == -2) {
             System.out.println("ja existe usuario logado no sistema. \n por favor");
         }
         else {
             if (senha.equals(usuarios.get(userExist).getSenha())){
               usuarioLogado = userExist;
               logado = true;
               System.out.printf("usuario logado: %s\n", usuarios.get(usuarioLogado).getNome());
             }
             else System.out.println("senha incorreta");
         }
    }

    public void depositar(Double valor){
        usuarios.get(usuarioLogado).setSaldo(valor + usuarios.get(usuarioLogado).getSaldo());
        System.out.printf("\nSaldo Atual: %.2f ", usuarios.get(usuarioLogado).getSaldo());
    }

    public void sacar(Double valor){
        if (usuarios.get(usuarioLogado).getSaldo()-valor<-600.00)
        {
            System.out.println("Saque nao realizado, voce ultrapassou seu limite de credito");

    }

        else {
            usuarios.get(usuarioLogado).setSaldo(usuarios.get(usuarioLogado).getSaldo() -valor);
            System.out.printf("saldo atual: %.2f", usuarios.get(usuarioLogado).getSaldo());
        }
    }

    public void registra(String cpf, String senha, String nome){
        usuarios.add(new Usuario(00.00, cpf, senha, nome));
        System.out.printf("usuario %s foi registrado!", nome);

    }
}