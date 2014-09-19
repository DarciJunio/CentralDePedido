
import java.util.Scanner;

public class CentralDePedidosMain {

    public static boolean validarLogin(Usuario[] usuarios) {
        Scanner sc = new Scanner(System.in);
        String user = "";
        String password = "";
        System.out.println("Digite seu login: ");
        user = sc.nextLine();
        System.out.println("Digite sua senha: ");
        password = sc.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario != null) {
                if (usuario.login.equals(user) && usuario.senha.equals(password)) {
                    System.out.println("Seja bem vindo " + usuario.nome + " !");
                    return true;
                }
            } else {
                break;
            }
        }
        System.out.println("Usuário não encontrado.");
        return false;
    }

    public static void incluirItem(Pedido pedido) {
        String item;
        String itens = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Itens para o evento " + pedido.descricao);
        System.out.println("1 - Projetor");
        System.out.println("2 - Computador");
        System.out.println("3 - Reserva de sala");
        System.out.println("4 - Refeições");
        System.out.println("5 - Passagem");
        System.out.println("6 - Reserva de Hotel");
        System.out.println("7 - Impressão de material");
        System.out.println("8 - Outros");

        while (pedido.itens.size() < 100) {

            System.out.println("Digite o número do item que deseja incluir ao evento:");
            item = sc.nextLine();
            itens += itens = item + ", ";
            switch (item) {
                case "1":
                    //incluir projetor
                    Projetor projetor = new Projetor();
                    pedido.itens.add(projetor);

                    break;
                case "2":
                    //incluir Computador
                    Computador computador = new Computador();
                    pedido.itens.add(computador);
                    break;
                case "3":
                    //incluir reserva de sala
                    ReservaDeSala sala = new ReservaDeSala();
                    System.out.println("Digite a quantidade de assentos: ");
                    sala.numeroAssentos = Integer.parseInt(sc.nextLine());
                    pedido.itens.add(sala);

                    break;
                case "4":
                    //incluir refeições
                    Refeicoes refeicoes = new Refeicoes();
                    System.out.println("Informe a quantidade de refeicoes: ");
                    refeicoes.quantidade = Integer.parseInt(sc.nextLine());
                    pedido.itens.add(refeicoes);
                    break;
                case "5":
                    //incluir passagem
                    Passagem passagem = new Passagem();
                    System.out.println("Informe a origem: ");
                    passagem.origem = sc.nextLine();
                    System.out.println("Informe o destino: ");
                    passagem.destino = sc.nextLine();
                    System.out.println("Informe o tipo da passagem: \n"
                            + "1 - Rodoviario"
                            + "2 - Aerea");
                    passagem.tipoPassagem = Integer.parseInt(sc.nextLine());
                    System.out.println("Informe a data da viagem: ");
                    passagem.data = sc.nextLine();
                    System.out.println("Informe o valor da passagem: ");
                    passagem.valor = Float.parseFloat(sc.nextLine());
                    
                    break;
                case "6":
                    //incluir reserva de hotel
                    ReservaDeHotel hotel =new ReservaDeHotel();
                    System.out.println("Informe Informe o tipo do Hotel: \n"
                            + "-3 estrelas"
                            + "-4 estrela");
                    break;
                case "7":
                    //incluir impressão de material
                    break;
                case "8":
                    //incluir outros
                    break;
                default:
                    System.out.println("Opção inválida!");
                    System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String op = "";
        Usuario usuarios[] = new Usuario[10];
        usuarios[0] = new Usuario();
        usuarios[0].nome = "João Henrique";
        usuarios[0].login = "joao";
        usuarios[0].senha = "w12r";
        usuarios[1] = new Usuario();
        usuarios[1].nome = "Maria Aparecida";
        usuarios[1].login = "maria";
        usuarios[1].senha = "ad45a";
        String sair = "S";
        Pedido[] pedido = new Pedido[99];

        while (true) {
            System.out.println("=====MENU=====");
            System.out.println("1) Registrar Pedido");
            System.out.println("2) Atender Pedido");
            System.out.println("3) Sair");

            op = s.nextLine();

            switch (op) {
                case "1"://opção para registrar pedido
                    if (validarLogin(usuarios)) {
                        System.out.println("Acessar função de registrar pedido.");

                        for (int i = 0; i < pedido.length; i++) {
                            if (pedido[i] == null) {
                                pedido[i] = new Pedido();
                                //pedido[i].usuario = usuarios;//preencher usuário responsável pelo cadastro
                                //pedido[i].dataCriacao = s.nextLine();//preencher data do cadastro
                                System.out.println("Informar a descricao do evento:");
                                pedido[i].descricao = s.nextLine();
                                System.out.println("Informar o local do evento: ");
                                pedido[i].local = s.nextLine();
                                System.out.println("Informar o nome do palestrante: ");
                                pedido[i].nomePalestrante = s.nextLine();
                                System.out.println("Informar a data do evento: ");
                                pedido[i].dataEvento = s.nextLine();
                                incluirItem(pedido[i]);

                            } else {
                                break;
                            }

                        }
                    }
                    break;

                case "2"://opção para atender pedido
                    if (validarLogin(usuarios)) {
                        System.out.println("Acessar função de atender pedido.");
                    }
                    break;

                case "3"://opção para encerrar aplicação
                    System.out.println("Pressione a tecla 's' para encerrar a aplicação.");
                    String exit = s.nextLine().trim().toUpperCase();
                    if (exit.equals(sair)) {
                        System.out.println("Aplicação encerrada.");
                        System.exit(0);
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
