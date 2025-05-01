import java.util.Random;

public class PapanLotre {
    private char[][] board;         // Menyimpan tampilan papan saat ini
    private boolean[][] revealed;   // Menyimpan status apakah kotak sudah dibuka
    private int[][] data;           // Menyimpan posisi bom (1) dan aman (0)
    private final int ROWS = 4;
    private final int COLS = 5;

    public PapanLotre() {
        board = new char[ROWS][COLS];
        revealed = new boolean[ROWS][COLS];
        data = new int[ROWS][COLS];
        generateBoard();
    }

    // Menempatkan dua bom secara acak di papan
    public void generateBoard() {
        Random rand = new Random();

        // Inisialisasi semua kotak sebagai aman
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = '*';
                data[i][j] = 0;
                revealed[i][j] = false;
            }
        }

        // Tempatkan 2 bom secara acak
        int bombCount = 0;
        while (bombCount < 2) {
            int r = rand.nextInt(ROWS);
            int c = rand.nextInt(COLS);
            if (data[r][c] == 0) {
                data[r][c] = 1;
                bombCount++;
            }
        }
    }

    // Menampilkan papan ke layar
    public void displayBoard() {
        System.out.println("\nPapan Lotre:");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (revealed[i][j]) {
                    if (data[i][j] == 1) {
                        System.out.print("X ");  
                    } else {
                        System.out.print("O ");  
                    }
                } else {
                    System.out.print("* ");   
                }
            }
            System.out.println();
        }
    }

    // Proses tebakan pemain
    public boolean guess(int row, int col) {
        if (revealed[row][col]) {
            System.out.println("Kotak ini sudah dibuka. Coba yang lain.");
            return true;
        }

        revealed[row][col] = true;

        if (data[row][col] == 1) {
            
            board[row][col] = 'X';
            return false;
        } else {
            board[row][col] = 'O';
            return true;
        }
    }

    // Menampilkan semua bom di papan
    public void revealAllBombs() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (data[i][j] == 1) {
                    revealed[i][j] = true;  // paksa buka semua bom
                }
            }
        }
    }

    // Mengecek apakah permainan selesai
    public boolean isGameOver() {
        int safeRevealed = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (revealed[i][j] && data[i][j] == 0) {
                    safeRevealed++;
                }
                if (revealed[i][j] && data[i][j] == 1) {
                    return true; 
                }
            }
        }
        return safeRevealed == 18;
    }
}
