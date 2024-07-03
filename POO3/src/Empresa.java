public class Empresa extends Usuario {

    private String cnpj, endereco, site, descricao;
    private Area area;


    public Empresa(String login, String nome, String senha, String cnpj) throws CNPJInvalidoException{
        super(login, nome, senha);
        if (!cnpj.matches("\\d+")) {
            throw new CNPJInvalidoException("CNPJ deve conter apenas números.");
        }
        this.cnpj = cnpj;
        System.out.println("\n**   NOVA EMPRESA CADASTRADA NO SISTEMA    **");
    }

    public String toString() {
        return String.format("%s (%s - %s)", nome, login, cnpj);
    }
}