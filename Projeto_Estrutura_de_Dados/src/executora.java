import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class executora {

    public static boolean isString(String input) {
        return input.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        List<Fabricante> fabricantes = new ArrayList<>();
        List<Sneaker> sneakers = new ArrayList<>();
        FabricanteDAO fabricante = new FabricanteDAO();
        SneakerDAO sneaker = new SneakerDAO();
        Scanner scanner = new Scanner(System.in);
        

        boolean switchOn;

        while (switchOn = true) {
            System.out.println("\n|-------------------------------------------------|");
            System.out.println("|          MENU INICIAL - [SNEAKERS]              |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  01   |    Cadastrar Fabricante                 |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  02   |    Cadastrar Produto                    |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  03   |    Entrar como cliente                  |");
            System.out.println("|-------------------------------------------------|");
            System.out.println("|  99   |    Sair do programa                     |");
            System.out.println("|-------------------------------------------------|\n");
            System.out.println("Digite uma opção");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da Fabricante: ");
                    String nome_fabri = scanner.nextLine();
                    while (!isString(nome_fabri)) {
                        System.out.println("Entrada invalida!. Por favor digite novamente!");
                        nome_fabri = scanner.next();
                    }

                    System.out.println("Digite o URL do site: ");
                    String site = scanner.nextLine();
                    while (!isString(site)) {
                        System.out.println("Entrada invalida!. Por favor digite novamente!");
                        site = scanner.next();
                    }

                    System.out.println("Digite o telefone: ");
                    int telefone;
                    do {
                        while (!scanner.hasNextInt()) {
                            System.out.println("Valor invalido!");
                        }
                        telefone = scanner.nextInt();
                    } while (telefone <= 0);
                    scanner.nextLine();

                    System.out.println("Digite o UF da : ");
                    String UF = scanner.nextLine();
                    while (!isString(UF)) {
                        System.out.println("Entrada invalida!. Por favor digite novamente!");
                        UF = scanner.next();
                    }

                    fabricante.addFabricante(nome_fabri, site, telefone, UF);

                    break;

                case 2:
                    System.out.println("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    while (!isString(nome)) {
                        System.out.println("Entrada invalida!. Por favor digite novamente!");
                        nome = scanner.next();
                    }

                    System.out.println("Digite o peso do produto: ");
                    double peso;
                    do {
                        while (!scanner.hasNextFloat()) {
                            System.out.println("Valor invalido!");
                        }
                        peso = scanner.nextDouble();
                    } while (peso <= 0);
                    scanner.nextLine();

                    System.out.println("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();
                    while (!isString(descricao)) {
                        System.out.println("Entrada invalida!. Por favor digite novamente!");
                        descricao = scanner.next();
                    }

                    System.out.println("Digite o valor do produto: ");
                    double valor;
                    do {
                        while (!scanner.hasNextFloat()) {
                            System.out.println("Valor invalido!");
                        }
                        valor = scanner.nextDouble();
                    } while (valor <= 0);
                    scanner.nextLine();

                    System.out.println("Digite o valor de venda do produto: ");
                    double valorVenda;
                    do {
                        while (!scanner.hasNextFloat()) {
                            System.out.println("Valor invalido!");
                        }
                        valorVenda = scanner.nextDouble();
                    } while (valorVenda <= 0);
                    scanner.nextLine();

                    System.out.println("Escolha a fabricante do produto: ");
                    int buscaId;
                    Fabricante criador;
                    fabricante.getFabricantes();
                    buscaId = scanner.nextInt();
                    criador = fabricante.getFabricanteId(buscaId);

                    sneaker.addSneaker(nome, peso, descricao, valor, valorVenda, criador);

                    break;

                case 3:
                    while (opcao != 0) {
                        System.out.println("\n|-------------------------------------------------|");
                        System.out.println("|          MENU INICIAL - [SNEAKERS]              |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  04   |    Listar Fabricantes                   |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  05   |    Listar Produtos                      |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  06   |    Listar Produtos de Determinado UF    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  07   |    Listar Produtos de Determinada Marca |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  08   |    Produto mais cara                    |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  09   |    Produto mais barato                  |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  10   |    Produtos em ordem crescente de valor |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  11   |    Listar produtos de maior lucro       |");
                        System.out.println("|-------------------------------------------------|");
                        System.out.println("|  00    |    Retorna                             |");
                        System.out.println("|-------------------------------------------------|\n");
                        System.out.println("Digite uma opção");
                        opcao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcao) {
                            case 4:
                                fabricante.getFabricantes();
                                break;
                            case 5:
                                sneaker.getSneaker();
                                break;

                            case 6:
                                System.out.println("Digite a sigla UF a ser procurada: ");
                                String sigla;
                                sigla = scanner.nextLine();
                                for (Sneaker s : sneakers) {
                                    Fabricante f = s.getFabricante();
                                    if (f.getUF().equals(sigla)) {
                                        System.out.println(s.getId() + s.getNome());
                                    }
                                }
                                break;

                            case 7:
                                System.out.println("Digite a marca que voce deseja: ");
                                String fabrica;
                                fabrica = scanner.nextLine();
                                for (Fabricante f : fabricantes) {
                                    if (f.getNome_fabricante().equals(fabrica)){
                                        System.out.println(f.getIdFabricante() + f.getNome_fabricante());
                                    }
                                }

                                break;

                            case 8:
                                double valorMaximo = 0;
                                Sneaker maisCaro = null;
                                for (Sneaker s : sneakers){
                                    if (s.getValor() > valorMaximo){
                                        valorMaximo = s.getValor();
                                        maisCaro = s;
                                    }
                                }

                                if (maisCaro != null){
                                    System.out.println("Produto mais caro: " + maisCaro.getNome());
                                    System.out.println("Valor: "+ maisCaro.getValor());
                                }else {
                                    System.out.println("Nao ha produtos cadastradoos");
                                }

                                break;

                            case 9:
                                double valorBaixo=0;
                                Sneaker maisBarato = null;
                                for (Sneaker s : sneakers){
                                    if (s.getValor() > valorBaixo){
                                        valorBaixo = s.getValor();
                                        maisBarato = s;
                                    }
                                }
                                if (maisBarato != null){
                                    System.out.println("Produto mais barato: "+ maisBarato.getNome());
                                    System.out.println("Valor: "+ maisBarato.getValor());
                                }else{
                                    System.out.println("Nao ha produtos cadastrados");
                                }

                                break;

                            case 10:
                            //ordenar a lista
                            Collections.sort(sneakers,(s1,s2)-> Double.compare(s1.getValor(), s2.getValor()));

                            //Exibir os sneakers
                            System.out.println("Produtos em ordem crescente de valor:");
                            for (Sneaker s : sneakers){
                                System.out.println(s.getNome() + " - R$ "+ s.getValor());
                            }
                                break;

                            case 11:
                                double lucroMaximo = 0;
                                List<Sneaker> produtosComMaiorLucro = new ArrayList<>();

                                for (Sneaker s : sneakers) {
                                    double lucro = s.getValorLucro();
                                    if (lucro > lucroMaximo) {
                                        lucroMaximo = lucro;
                                        produtosComMaiorLucro.clear();
                                        produtosComMaiorLucro.add(s);
                                    } else if (lucro == lucroMaximo) {
                                        produtosComMaiorLucro.add(s);
                                    }
                                }

                                if (produtosComMaiorLucro.isEmpty()) {
                                    System.out.println("Não há produtos cadastrados.");
                                } else {
                                    System.out.println("Produtos com maior lucro:");

                                    for (Sneaker s : produtosComMaiorLucro) {
                                        System.out.println(s.getId() + " - " + s.getNome() + " - Lucro: " + s.getValorLucro());
                                    }
                                }

                                break;

                            case 0:

                                break;
                            default:
                                break;
                        }
                    }

                default:
                    break;
            }
        }
    }
}
