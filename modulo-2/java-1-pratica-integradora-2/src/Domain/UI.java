package Domain;

import Exceptions.PermissaoNegadaException;

import java.util.Iterator;
import java.util.Scanner;

public class UI {
    private CircuitoPequeno circuitoPequeno;
    private CircuitoMedio circuitoMedio;
    private CircuitoAvancado circuitoAvancado;
    private Integer inscricaoCounter;
    private Scanner CONSOLE;

    public UI(CircuitoPequeno circuitoPequeno, CircuitoMedio circuitoMedio, CircuitoAvancado circuitoAvancado) {
        this.circuitoPequeno = circuitoPequeno;
        this.circuitoMedio = circuitoMedio;
        this.circuitoAvancado = circuitoAvancado;
        this.inscricaoCounter = 0;
        this.CONSOLE = new Scanner(System.in);
    }

    public void run(){
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
                    cadastrarInscricao(pessoa);
                    break;

                case 2:
                    exibirCategoria();
                    break;

                case 3:
                    cancelarInscricao();
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

    private void cancelarInscricao(){
        System.out.println("-------------------------");

        CircuitoBase circuito = null;

        while (circuito == null){
            System.out.println("Selecione categoria: ");
            System.out.println("1 - Circuito Pequeno");
            System.out.println("2 - Circuito Medio");
            System.out.println("3 - Circuito Avancado");
            System.out.print("Categoria: ");

            switch (CONSOLE.nextInt()){
                case 1:
                    circuito = circuitoPequeno;
                    break;
                case 2:
                    circuito = circuitoMedio;
                    break;
                case 3:
                    circuito = circuitoAvancado;
                    break;
                default: System.out.println("Opcao invalida.");
                    continue;
            }
        }

        System.out.println("ID do registro de inscricao: ");
        int registro = CONSOLE.nextInt();

        Iterator<Inscricao> iterator = circuito.getInscricoes().iterator();
        while(iterator.hasNext()){
            Inscricao inscricao = iterator.next();
            if(inscricao.getID().equals(registro)){
                iterator.remove();
                System.out.println("Participante " +
                        inscricao.getPessoa().getNome() +
                        " foi removido da categoria selecionada!"
                );

                return;
            }
        }

        System.out.println("O ID de registro informado nao foi encontrado nas inscricoes da categoria selecionada!");
        return;
    }

    private void exibirCategoria(){
        System.out.println("-------------------------");
        do {

            System.out.println("Selecione categoria: ");
            System.out.println("1 - Circuito Pequeno");
            System.out.println("2 - Circuito Medio");
            System.out.println("3 - Circuito Avancado");

            System.out.print("Categoria: ");

            switch (CONSOLE.nextInt()){
                case 1:
                    circuitoPequeno.getInscricoes().forEach(System.out::println);
                    return;
                case 2:
                    circuitoMedio.getInscricoes().forEach(System.out::println);
                    return;
                case 3:
                    circuitoAvancado.getInscricoes().forEach(System.out::println);
                    return;
                default: System.out.println("Opcao invalida.");
                    continue;
            }
        }while(true);
    }

    private Inscricao cadastrarInscricao(Pessoa pessoa){
        System.out.println("-------------------------");
        do{
            System.out.println("Selecione categoria: ");
            System.out.println("1 - Circuito Pequeno");
            System.out.println("2 - Circuito Medio");
            System.out.println("3 - Circuito Avancado");

            System.out.print("Categoria: ");
            Inscricao inscricao = null;
            try{
                switch (CONSOLE.nextInt()){
                    case 1:
                        inscricao = new Inscricao(generateId(),pessoa, circuitoPequeno.verificarValor(pessoa));
                        circuitoPequeno.addInscricao(inscricao);
                        return inscricao;

                    case 2:
                        inscricao = new Inscricao(generateId(), pessoa, circuitoMedio.verificarValor(pessoa));
                        circuitoMedio.addInscricao(inscricao);
                        return inscricao;

                    case 3:
                        inscricao = new Inscricao(generateId(), pessoa, circuitoAvancado.verificarValor(pessoa));
                        circuitoAvancado.addInscricao(inscricao);
                        return inscricao;

                    default: System.out.println("Opcao invalida.");
                        continue;
                }
            }catch (PermissaoNegadaException e){
                System.out.println(e.getMessage());
                continue;
            }
        }while (true);

    }

    private Pessoa cadastrarPessoa(){
        System.out.println("-------------------------");
        Pessoa.Builder pessoa = new Pessoa.Builder();

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

        return pessoa.build();
    }

    private Integer generateId(){
        return ++this.inscricaoCounter;
    }

}
