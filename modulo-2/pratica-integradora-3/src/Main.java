public class Main {
    public static void main(String[] args) {
        Pessoa pessoaConstrutorVazio = new Pessoa();
        Pessoa pessoaConstrutorPoucosParametros = new Pessoa("8qw7e8q", "Weverton Bruno", 25);
        Pessoa pessoaConstrutorFull = new Pessoa("9er8tsx", "Bruno", 25, 80.5F, 1.80F);

        System.out.println(pessoaConstrutorFull);
        //Error: Cannot resolve constructor 'Pessoa(java.lang.String, int)'
        //Pessoa pessoaConstrutorPoucosParametros = new Pessoa("Weverton Bruno", 25);
    }
}
