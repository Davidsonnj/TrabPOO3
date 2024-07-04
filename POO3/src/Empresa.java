import java.io.BufferedWriter;
import java.io.IOException;

public class Empresa extends Usuario implements Salvavel {

    private String cnpj, endereco, site, descricao;
    private Area area;


    public Empresa(String login, String nome, String senha, String cnpj) throws CNPJInvalidoException{
        super(login, nome, senha);
        if (!cnpj.matches("[\\d.-]+")) {
            throw new CNPJInvalidoException("CNPJ deve conter apenas números, pontos e hífen.");
        }
        this.cnpj = cnpj;
        System.out.println("\n**   NOVA EMPRESA CADASTRADA NO SISTEMA    **");
    }

    public void salvarArq(BufferedWriter b) throws IOException
    {
        b.write(this.login + "\n");
        b.write(this.nome + "\n");
        b.write(this.cnpj + "\n");

        salvarArq(b);
    }

    public String toString() {
        return String.format("%s (%s - %s)", nome, login, cnpj);
    }
}