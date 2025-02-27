import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Path path = Path.of(str);
        if (!path.isAbsolute()) {
            path = path.toAbsolutePath();
        }
        System.out.println(path);
    }
}

