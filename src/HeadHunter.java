import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class HeadHunter {

    static int[] A = new int[]{5,2,4,7,6,3,2,1};
    static int p = 1;

    private static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = new BigDecimal(p + (r - p) / 2)            // срединное значение на промежутке p;r
                    .setScale(0, RoundingMode.HALF_DOWN)
                    .intValue();
            sort(A, p, q);
            sort(A, q + 1, r);          // делим массив на промежутки
            merge(A, p, q, r);             // слияние и сортировка промежутков массива
        }
    }

    public static void merge(int[] A, int p, int q, int r) {

        int[] buf = Arrays.copyOf(A, A.length);

        int i = p, j = q + 1;
        for (int k = p; k <= r; k++) {

            if (i > q) {
                A[k] = buf[j];
                j++;
            } else if (j > r) {
                A[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                A[k] = buf[j];
                j++;
            } else {
                A[k] = buf[i];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        sort(A,p-1,A.length-1);
        System.out.println(Arrays.toString(A));
    }

}
