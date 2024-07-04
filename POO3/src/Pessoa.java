import java.util.ArrayList;

public class Pessoa extends Usuario {

    private String cpf, bio;
    private Data nasc;
    private ArrayList<Usuario> interesses;

    public Pessoa(String login, String nome, String senha, String cpf, int dia, int mes, int ano) throws CPFInvalidoException, DataInvalidaException {
        super(login, nome, senha);
        if (!cpf.matches("[\\d.-]+")) {
            throw new CPFInvalidoException("CPF deve conter apenas números, pontos e traços.");
        }
        this.cpf = cpf;
        this.nasc = new Data(dia, mes, ano);
        this.interessados = new ArrayList<>();
        System.out.println("\n**   NOVA PESSOA CADASTRADA NO SISTEMA    **");
    }

    public String toString(){
        return String.format("%s (%s - %s)", nome, login, cpf);
    }
}
