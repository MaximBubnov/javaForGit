package forOther;

import java.util.Arrays;

public class arrayMinMax {
    public static void main(String[] args) {
        int[] arrray = new int[10];

        for (int i = 0; i <arrray.length ; i++) {
            arrray[i] = (int) (Math.random() * 20);
        }

        Arrays.sort(arrray);

        for (int i = 0; i <arrray.length ; i++) {
            System.out.println(arrray[i]);
        }
    }
}
