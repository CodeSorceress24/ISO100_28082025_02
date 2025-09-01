import java.util.Random;

public class SomaMatriz {

    public static void main(String[] args) {
        // Cria e preenche matriz 3x5 com números aleatórios
        int[][] matriz = new int[3][5];
        Random random = new Random();
        
        System.out.println("=== MATRIZ 3x5 ===");
        for (int i = 0; i < 3; i++) {
            System.out.print("Linha " + i + ": ");
            for (int j = 0; j < 5; j++) {
                matriz[i][j] = random.nextInt(100) + 1;
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        System.out.println("=== SOMAS DAS LINHAS ===");
        
        // Cria 3 threads (uma para cada linha)
        for (int i = 0; i < 3; i++) {
            final int linhaIndex = i; // final para usar dentro da lambda
            int[] linhaVetor = matriz[i]; // Vetor da linha
            
            new Thread(() -> {
                // Calcula soma da linha
                int soma = 0;
                for (int numero : linhaVetor) {
                    soma += numero;
                }
                
                System.out.println("Thread " + Thread.currentThread().threadId() + 
                                  " - Linha " + linhaIndex + ": " + soma);
            }).start();
        }
    }
}