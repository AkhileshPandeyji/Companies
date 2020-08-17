import java.util.Scanner;

public class Ques4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int locker[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                locker[i][j] = scn.nextInt();
            }
        }
        int[] lRot = new int[m / 2];
        for (int i = 0; i < lRot.length; i++) {
            lRot[i] = scn.nextInt();
        }
        lockerRotate(locker, lRot);
        display(locker);

        // int[] a = {1,2,3,4,5};
        // rotateRight(a, 13);
        // for(int i=0;i<a.length;i++){
        // System.out.print(a[i]+" ");
        // }
        
        scn.close();
    }

    public static void display(int[][] wall) {
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                System.out.print(wall[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void lockerRotate(int[][] locker, int[] lRot) {
        int n = locker.length;
        int m = locker[0].length;
        int rmin = 0, rmax = n - 1, cmin = 0, cmax = m - 1;

        for (int i = 1; i <= lRot.length; i++) {

            int[] layer = new int[2 * ((rmax-rmin) + (cmax-cmin))];
            int count = 0;
            
            // 2d to 1d
            for (int col = cmin; col <= cmax; col++) {
                layer[count++] = locker[rmin][col];

            }
            for (int row = rmin + 1; row <= rmax; row++) {
                layer[count++] = locker[row][cmax];
            }
            for (int col = cmax - 1; col >= cmin; col--) {
                layer[count++] = locker[rmax][col];
            }
            for (int row = rmax - 1; row >= rmin + 1; row--) {
                layer[count++] = locker[row][cmin];
            }
            // 1-d rotation;
            if (i % 2 != 0) {
                // anti-clock
                int k = lRot[i - 1];
                rotateLeft(layer, k);
            } else {
                // clock
                int k = lRot[i - 1];
                rotateRight(layer, k);
            }

            // 1-d to 2-d
            count = 0;
            for (int col = cmin; col <= cmax; col++) {
                locker[rmin][col] = layer[count++];
            }
            for (int row = rmin + 1; row <= rmax; row++) {
                locker[row][cmax] = layer[count++];
            }
            for (int col = cmax - 1; col >= cmin; col--) {
                locker[rmax][col] = layer[count++];
            }
            for (int row = rmax - 1; row >= rmin + 1; row--) {
                locker[row][cmin] = layer[count++];
            }

            rmax--;
            cmax--;
            rmin++;
            cmin++;
        }
    }

    public static void rotateLeft(int[] arr, int k) {
        if (k > arr.length) {
            k = k % arr.length;
        }
        if (k < 0) {
            k = Math.abs(k);
        }

        int left[] = new int[k];
        int right[] = new int[arr.length - k];
        int i;
        for (i = 0; i < k; i++) {
            left[i] = arr[i];
        }
        for (i = k; i < arr.length; i++) {
            right[i - k] = arr[i];
        }
        for (i = 0; i < right.length; i++) {
            arr[i] = right[i];
        }
        for (int j = 0; j < left.length; j++) {
            arr[i++] = left[j];
        }
    }

    public static void rotateRight(int[] arr, int k) {
        if (k > arr.length) {
            k = k % arr.length;
        }
        if (k < 0) {
            k = Math.abs(k);
        }

        int left[] = new int[arr.length - k];
        int right[] = new int[k];
        int i;
        for (i = 0; i < arr.length - k; i++) {
            left[i] = arr[i];
        }
        for (i = arr.length - k; i < arr.length; i++) {
            right[i - (arr.length - k)] = arr[i];
        }
        for (i = 0; i < right.length; i++) {
            arr[i] = right[i];
        }
        for (int j = 0; j < left.length; j++) {
            arr[i++] = left[j];
        }
    }
}