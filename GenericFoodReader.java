package Ex10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GenericFoodReader {
    public static void processFruits() {
        File file = new File("C:\\temp\\generic_food.csv");

        if (!file.exists()) {
            System.out.println("Arquivo não encontrado em C:\\TEMP\\generic_food.csv");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine(); // cabeçalho
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length >= 5) {
                    String group = fields[3].trim();
                    if (group.equalsIgnoreCase("Fruits")) {
                        String foodName = fields[0];
                        String scientificName = fields[1];
                        String subGroup = fields[4];
                        System.out.printf("%s\t%s\t%s%n", foodName, scientificName, subGroup);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
