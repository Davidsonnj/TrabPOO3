import java.io.BufferedWriter;
import java.io.IOException;

public class Data{

    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) throws DataInvalidaException {
        if (dia < 1 || dia > 31) {
            throw new DataInvalidaException("DIA INVÁLIDO");
        }
        if (mes < 1 || mes > 12) {
            throw new DataInvalidaException("MÊS INVÁLIDO");
        }
        if (ano < 1900 || ano > 2023) {
            throw new DataInvalidaException("ANO INVÁLIDO");
        }

        // Verificação específica para cada mês
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
            throw new DataInvalidaException("DIA INVÁLIDO PARA O MÊS ESPECIFICADO");
        }

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;


    }

    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }


    public String toString(){
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

}
