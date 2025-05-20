package Ex10;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escolha a operação:");
        System.out.println("1 - Processar frutas do arquivo generic_food.csv");
        System.out.println("2 - Exibir jogos Steam por média mínima");
        System.out.println("3 - Exportar jogos Steam por ano e mês");
        int opcao = sc.nextInt();

        switch (opcao) {
            case 1:
                GenericFoodReader.processFruits();
                break;
            case 2:
                System.out.print("Ano: ");
                int ano = sc.nextInt();
                System.out.print("Mês: ");
                int mes = sc.nextInt();
                System.out.print("Média mínima de jogadores: ");
                double media = sc.nextDouble();
                SteamController.exibirJogosPorMedia(ano, mes, media);
                break;
            case 3:
                System.out.print("Ano: ");
                int anoArq = sc.nextInt();
                System.out.print("Mês: ");
                int mesArq = sc.nextInt();
                sc.nextLine(); // limpar buffer
                System.out.print("Diretório de saída (ex: C:\\\\TEMP): ");
                String dir = sc.nextLine();
                System.out.print("Nome do arquivo (ex: jogos.csv): ");
                String nomeArq = sc.nextLine();
                SteamController.exportarJogosPorMedia(anoArq, mesArq, dir, nomeArq);
                break;
            default:
                System.out.println("Opção inválida");
        }

        sc.close();
    }
}
