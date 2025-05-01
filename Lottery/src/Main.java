import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PapanLotre papan = new PapanLotre();
        boolean gameRunning = true;

        System.out.println("=== LOTRE GOSOK Pawwry ===");
        System.out.println("Tebak kotak dengan memasukkan baris (0-3) dan kolom (0-4).");
        System.out.println("Hindari 2 bom untuk menang!\n");

        while (gameRunning) {
            papan.displayBoard();
            System.out.print("Masukkan baris (0-3): ");
            int row = scanner.nextInt();
            System.out.print("Masukkan kolom (0-4): ");
            int col = scanner.nextInt();

            // Validasi input
            if (row < 0 || row > 3 || col < 0 || col > 4) {
                System.out.println("Posisi tidak valid. Coba lagi.");
                continue;
            }

            boolean result = papan.guess(row, col);

            if (!result) {
                System.out.println("\nBOOM! Kamu menemukan bom! Permainan berakhir.");
                papan.revealAllBombs();
                papan.displayBoard();
                gameRunning = false;
            } else if (papan.isGameOver()) {
                System.out.println("\nSelamat! Kamu membuka semua kotak aman!");
                papan.displayBoard();
                gameRunning = false;
            }
        }

        scanner.close();
    }
}
