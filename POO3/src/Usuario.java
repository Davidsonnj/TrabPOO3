import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Usuario implements Salvavel {

    protected String login, nome, senha;
    protected Local cidade;
    protected ArrayList<Postagem> posts;
    protected ArrayList<Usuario> seguindo, seguidores;
    protected ArrayList<Pessoa> interessados;

    public Usuario(String login, String nome, String senha) {
        this.login = login;
        this.nome = nome;
        this.senha = senha;

        this.posts = new ArrayList<>();
        this.seguindo = new ArrayList<>();
        this.seguidores = new ArrayList<>();
        this.interessados = new ArrayList<>();
    }

    public Usuario(BufferedReader r) {
        try {
            this.login = r.readLine();
            this.nome = r.readLine();
            this.senha = r.readLine();

            this.posts = new ArrayList<>();
            this.seguindo = new ArrayList<>();
            this.seguidores = new ArrayList<>();
            this.interessados = new ArrayList<>();

        } catch (IOException e) {
            System.out.println("ERRO AO LER USUARIO.");
        }
    }

    public abstract String toString();

    public String getLogin() {
        return login;
    }

    public boolean validarAcesso(String pwd){
        return this.senha.equals(pwd);
    }


    public void postarFoto(String foto, String legenda, Data hoje, String senha){
        if(validarAcesso(senha)){
            this.posts.add(new Postagem(foto, legenda, hoje));
            System.out.println("POSTAGEM ADICIONADA COM SUCESSO!");
        }
        else {
            System.out.println("** SENHA INVÁLIDA. Postagem não adicionada.\n");
        }
    }

    public void seguir(Usuario u)throws SeguirAlguemQueJaSegueException{
        if (this.seguindo.contains(u)) {
            throw new SeguirAlguemQueJaSegueException("Você já está seguindo esse usuário. Tente novamente.");
        }
        this.seguindo.add(u);
        u.seguidores.add(this);
    }

    public void mostrarPosts(){
        for(Postagem post : this.posts){
            System.out.println("—");
            System.out.println(this);
            post.mostrarDados();
        }
    }

    public void feed(){
        for(Usuario seguidor : this.seguindo){
            seguidor.mostrarPosts();
        }
    }

    public void salvarSeguimento(BufferedWriter b) throws IOException {
        for (Usuario seg : this.seguindo) {
            b.write("S\n");
            b.write(this.login + "\n");
            b.write(seg.getLogin() + "\n");
        }
    }

    public void salvarArq(BufferedWriter b) throws IOException {
        try {
            b.write(this.login + "\n");
            b.write(this.nome + "\n");
            b.write(this.senha + "\n");
        } catch (IOException e){
            System.out.println("Erro ao salvar arquivo de Usuário.");
        }
    }
}