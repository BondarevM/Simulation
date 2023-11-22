package bondarev;

public class ConsoleCleaner {

    public static void clearConsole() {
        try {
            final String os = System.getProperty("Windows");

            if (os.contains("Windows")) {
                // Если операционная система - Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Если операционная система - не Windows
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Обработка исключений
            e.printStackTrace();
        }
    }
}
