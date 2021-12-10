package ParzialeProva.Es2P;

public class Esercizio2P {
    public static void main(String[] args) {
        int[][] a = new int[][]{{5},{15,4,2},{},{10,6,1,-2},{23,12,3,1,-5}};
        int k=7;
        int i = 0, j = 0;
        boolean q = true;
        String t = "";
        while (i < a.length) {
            j = 1;
            q = true;
            while (j < a[i].length && q) {
                if (a[i][j - 1] - a[i][j] < k) {
                    q = false;
                    t = t + "x" + a[i][j];
                }
                j++;
            }
            i++;
        }

        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("q="+q);
        System.out.println("q="+t);
    }
}
