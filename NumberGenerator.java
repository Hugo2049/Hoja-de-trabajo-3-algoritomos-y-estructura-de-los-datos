import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumberGenerator {

    // Método para generar números aleatorios y escribirlos en un archivo
    public static void generateToFile(String filename, int count) throws IOException {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                int number = random.nextInt(100000); // número aleatorio entre 0 y 99999
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        }
    }

    // Método para leer números desde un archivo y devolver un arreglo de enteros
    public static int[] readFromFile(String filename) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filename));
        return lines.stream().mapToInt(Integer::parseInt).toArray();
    }
}

