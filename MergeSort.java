import javax.swing.JOptionPane;

public class MergeSort {

    // Método principal que ordena o array usando Merge Sort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            // Encontra o meio
            int mid = (left + right) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Mescla as duas metades ordenadas
            merge(array, left, mid, right);
        }
    }

    // Mescla dois subarray
    private static void merge(int[] array, int left, int mid, int right) {
        // Tamanhos dos subarrays 
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Arrays temporários
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = array[mid + 1 + j];


        // Índices iniciais dos dois subarrays
        int i = 0, j = 0;

        // Índice inicial do array mesclado
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes de leftArray[] se houver algum
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copia os elementos restantes de rightArray[] se houver algum
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Método principal para testar o Merge Sort
    public static void main(String[] args) {
        String inputSize = JOptionPane.showInputDialog("Digite o tamanho do array:");
        int size = Integer.parseInt(inputSize);

        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            String inputValue = JOptionPane.showInputDialog("Digite o valor do elemento " + (i + 1) + ":");
            array[i] = Integer.parseInt(inputValue);
        }

        JOptionPane.showMessageDialog(null, "Array original:\n" + arrayToString(array));

        // Ordena o array usando Merge Sort
        mergeSort(array, 0, array.length - 1);

        JOptionPane.showMessageDialog(null, "Array ordenado:\n" + arrayToString(array));
    }

    // Método auxiliar para converter o array em uma string
    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i : array) {
            sb.append(i).append(" ");
        }
        return sb.toString().trim();
    }
}
