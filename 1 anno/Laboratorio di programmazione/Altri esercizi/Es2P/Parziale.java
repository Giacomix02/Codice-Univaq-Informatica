package ParzialeProva.Es2P;

public class Parziale {
    public static void main(String[] args) {
        String[][] a = new String[][]{{"krjR"},{"ht"},{"gif","Z",""},{"hd"},{"xr","dif","jd","rq"},{"a","ww"}};
        int i = 0, j = 0, k = 0;
        boolean p = false;
        String s = "*";
        while (i < a.length && !p) {
            for (j = 0; j < a[i].length - 1; j++) {
                if (a[i][j].length() <= a[i][j + 1].length()) {
                    p = true;
                    s = a[i][j] + s;
                }
            }
            if (p)
                k = i;
            i++;
        }

        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
        System.out.println("p="+p);
        System.out.println("s="+s); 

    }
}
