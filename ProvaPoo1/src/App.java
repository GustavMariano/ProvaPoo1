import java.io.IOException;
import java.util.Scanner;
import modelo.Piloto;

public class App {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 20;
        int opcao, qtdCadastrados = 0;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }

                //Cadastre seu piloto aqui
                Piloto piloto = new Piloto();

                in.nextLine();
                System.out.println("Informe o nome do piloto: ");
                piloto.setNome(in.nextLine());

                System.out.println("Informe o cpf do piloto: ");
                piloto.setCpf(in.nextLine());

                qtdCadastrados ++;
                pilotos[qtdCadastrados] = piloto;
                

                System.out.println("\nPiloto cadastrado com sucesso.");
                voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                System.out.println("O nome do piloto cadastrado é : " + pilotos[qtdCadastrados].getNome());
                System.out.println("O cpf do piloto cadastrado é : " + pilotos[qtdCadastrados].getCpf());
                System.out.println();
                System.out.println("---------------------------------------------------------------");
                System.out.println();

                voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("Digite o cpf:");
                int pesqcpf = in.nextInt();
                    in.nextLine();
                    for(int i = 0; i < pilotos.length; i++){
                    if(pilotos[qtdCadastrados].getCpf() == pesqcpf){
                        System.out.println("O cpf pesquisado é do piloto : " + pilotos[i].getNome());

            } else if (opcao == 4) {
                int tamanho = 0;
                System.out.println("Qual novo tamanho do vetor?");
                tamanho = in.nextInt();
                Piloto[] pilotos2 = new Piloto[MAX_ELEMENTOS + tamanho];
                for(int i = 0; i < pilotos.length; i++){
                    pilotos2[i] = pilotos[i];
                    System.out.println(pilotos2[i] + " ");
                }
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
            } while (opcao != 0);

                System.out.println("Fim do programa!");

                in.close();
        }


    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}