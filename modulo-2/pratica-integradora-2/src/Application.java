import java.util.*;

public class Application {
    public static Scanner CONSOLE = new Scanner(System.in);
    
    public static Pessoa cadastrarPessoa(){
        System.out.println("-------------------------");
        Pessoa pessoa = new Pessoa();

        System.out.print("RG: ");
        pessoa.setRG(CONSOLE.next());
        CONSOLE.nextLine();
        System.out.print("Nome: ");
        pessoa.setNome(CONSOLE.nextLine());
        System.out.print("Sobrenome: ");
        pessoa.setSobrenome(CONSOLE.nextLine());
        System.out.print("Idade: ");
        pessoa.setIdade(CONSOLE.nextInt());
        System.out.print("Celular: ");
        pessoa.setCelular(CONSOLE.next("[0-9\\(\\)\\- ]+"));
        System.out.print("Numero para emergencia: ");
        pessoa.setNumEmergencia(CONSOLE.next("[0-9\\(\\)\\- ]+"));
        System.out.print("Tipo Sanguineo: ");
        pessoa.setTipoSanguineo(CONSOLE.next());

        return pessoa;
    }
    
    public static String selecinarCategoria(){
        System.out.println("-------------------------");
        do {

            System.out.println("Selecione categoria: ");
            System.out.println("1 - Circuito Pequeno");
            System.out.println("2 - Circuito Medio");
            System.out.println("3 - Circuito Avancado");

            System.out.print("Categoria: ");
            
            switch (CONSOLE.nextInt()){
                case 1:
                    return "circuito_pequeno";
                case 2:
                    return "circuito_medio";
                case 3:
                    return "circuito_avancado";
                default: System.out.println("Opcao invalida.");
                    continue;
            }
        }while(true);


    }

    public static Inscricao cadastrarInscricao(Pessoa pessoa){
        System.out.println("-------------------------");
        do{
            System.out.println("Selecione categoria: ");
            System.out.println("1 - Circuito Pequeno");
            System.out.println("2 - Circuito Medio");
            System.out.println("3 - Circuito Avancado");

            System.out.print("Categoria: ");
            Circuito circuito;

            switch (CONSOLE.nextInt()){
                case 1:
                    circuito = new CircuitoPequeno();
                    break;
                case 2:
                    circuito = new CircuitoMedio();
                    break;
                case 3:
                    circuito = new CircuitoAvancado();
                    break;

                default: System.out.println("Opcao invalida.");
                    continue;
            }
            try{
                circuito.verificarValor(pessoa);
                return new Inscricao(pessoa, circuito);
            }catch (PermissaoNegadaException e){
                System.out.println(e.getMessage());
                continue;
            }
        }while (true);

    }


    public static void main(String[] args) {
        Map<String, List<Inscricao>> circuitos = new HashMap<>();
        Integer id = 0;

        circuitos.put("circuito_pequeno", new ArrayList<>());
        circuitos.put("circuito_medio", new ArrayList<>());
        circuitos.put("circuito_avancado", new ArrayList<>());

        while(true){
            System.out.println("###########################");
            System.out.println("Selecione uma opcao: ");
            System.out.println("1 - Cadastrar um participante");
            System.out.println("2 - Exibir dados da categoria");
            System.out.println("3 - Cancelar inscricao");
            System.out.println("4 - Sair");

            switch(CONSOLE.nextInt()){
                case 1:
                    Pessoa pessoa = cadastrarPessoa();
                    pessoa.setID(++id);
                    Inscricao inscricao = cadastrarInscricao(pessoa);
                    circuitos.get(inscricao.getCircuito().getId()).add(inscricao);
                    break;
                    
                case 2:
                    String categoria = selecinarCategoria();
                    circuitos.get(categoria).forEach(System.out::println);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

            System.out.println("###########################");
        }
    }
}
