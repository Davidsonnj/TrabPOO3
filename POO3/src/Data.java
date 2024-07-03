public class Data {

    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) throws DataInvalidaException {
        if (dia < 1 || dia > 31) {
            throw new DataInvalidaException("Dia invalido");
        }
        if (mes < 1 || mes > 12) {
            throw new DataInvalidaException("Mes invalido");
        }
        if (ano < 1900 || ano > 2023) {
            throw new DataInvalidaException("Ano invalido");
        }

        // Verificação específica para cada mês
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            throw new DataInvalidaException("Dia invalido para o mes especificado");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String toString(){
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

}
