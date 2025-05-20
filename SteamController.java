package Ex10;
import java.io.*;

public class SteamController {

    public static void exibirJogosPorMedia(int ano, int mes, double mediaEsperada) {
        File file = new File("C:\\TEMP\\SteamCharts.csv");

        if (!file.exists()) {
            System.out.println("Arquivo SteamCharts.csv não encontrado.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linha = br.readLine(); // cabeçalho

            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                if (campos.length >= 5) {
                    String nome = campos[0];
                    int anoCsv = Integer.parseInt(campos[1]);
                    int mesCsv = Integer.parseInt(campos[2]);
                    double media = Double.parseDouble(campos[4]);

                    if (anoCsv == ano && mesCsv == mes && media >= mediaEsperada) {
                        System.out.printf("%s | %.2f%n", nome, media);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void exportarJogosPorMedia(int ano, int mes, String diretorio, String nomeArquivo) {
        File dir = new File(diretorio);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("Diretório inválido: " + diretorio);
            return;
        }

        File inputFile = new File("C:\\TEMP\\SteamCharts.csv");
        File outputFile = new File(diretorio + "\\" + nomeArquivo);

        try (
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFile))
        ) {
            String linha = br.readLine(); // cabeçalho
            while ((linha = br.readLine()) != null) {
                String[] campos = linha.split(",");

                if (campos.length >= 5) {
                    String nome = campos[0];
                    int anoCsv = Integer.parseInt(campos[1]);
                    int mesCsv = Integer.parseInt(campos[2]);
                    double media = Double.parseDouble(campos[4]);

                    if (anoCsv == ano && mesCsv == mes) {
                        writer.printf("%s;%.2f%n", nome, media);
                    }
                }
            }

            System.out.println("Arquivo gerado com sucesso em: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao processar arquivos: " + e.getMessage());
        }
    }
}
