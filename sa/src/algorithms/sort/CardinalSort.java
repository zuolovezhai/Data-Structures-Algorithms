package algorithms.sort;

/**
 * 基数排序
 * 时间复杂度O(n)
 * 空间复杂度0(n)
 * 稳定排序
 */
public class CardinalSort {
    public static void main(String[] args) {
        String[] data = {"19147841900", "14658464211",
                "19567147636", "16752249407",
                "19535136468", "15540760165",
                "14765356755", "17071330672",
                "15540760165", "19535136468",
                "18742402690", "14346071576",
                "17713236546", "19665773009",
                "14658464211", "17071330672",
        };
        sort(data);
    }

    public static void sort(String[] data) {
        for (int i = 10; i >= 0; i--) {
            int[] c = new int[10];
            String[] r = new String[data.length];
            for (int j = 0; j < data.length; j++) {
                c[data[j].charAt(i)-48]++ ;
            }

            for (int k = 1; k < c.length; k++) {
                c[k] += c[k-1];
            }

            for (int m = data.length-1; m >= 0; m--) {
                r[c[data[m].charAt(i)-48]-1] = data[m];
                c[data[m].charAt(i)-48] --;
            }
            data = r;
            printStringAll(r);
        }


    }

    public static void printIntAll(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

    public static void printStringAll(String[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
        System.out.println();
    }

}
