import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Sistema {

    private ArrayList<Pessoa> pessoas;
    private ArrayList<Empresa> empresas;
    private ArrayList<Salvavel> salvaveis;


    public Sistema() {
        this.pessoas = new ArrayList<>();
        this.empresas = new ArrayList<>();
        salvaveis = new ArrayList<>();
    }

    public void novaPessoa(Pessoa p){
        this.pessoas.add(p);
        salvaveis.add(p);
    }

    public void novaEmpresa(Empresa e){
        this.empresas.add(e);
        salvaveis.add(e);
    }

    public void listarUsuarios(){
        System.out.println("\n**          USUÁRIOS DISPONÍVEIS        **");

        for(Pessoa pessoa : pessoas){
            System.out.println(pessoa);
        }

        for(Empresa empresa : empresas){
            System.out.println(empresa);
        }
    }

    public Usuario buscarUsuario(String login)  {
        for (Usuario pessoa : pessoas) {
            if (pessoa.getLogin().equals(login)) {
                return pessoa;
            }
        }

        for (Usuario empresa : empresas) {
            if (empresa.getLogin().equals(login)) {
                return empresa;
            }
        }

        return null;
    }

    public void salvarArq(Sistema s){

        try {
            FileWriter f = new FileWriter("dados.txt");
            BufferedWriter b = new BufferedWriter(f);

            for (Salvavel p : this.salvaveis ) {
                p.salvarArq(b);
            }

            for (Salvavel p : this.salvaveis) {
                if (p instanceof Usuario) {
                    ((Usuario) p).salvarSeguimento(b);
                }
            }

            b.write("F");

            b.close();
        }
        catch (IOException e) {
            System.out.println("ERRO AO SALVAR ARQUIVO.");
        }
    }

    public void read_file(BufferedReader r){
        try {
            FileWriter r = new FileWriter("dados.txt");

        }
        catch (IOException e) {
            System.out.println("ERRO AO SALVAR ARQUIVO.");
        }
    }

}