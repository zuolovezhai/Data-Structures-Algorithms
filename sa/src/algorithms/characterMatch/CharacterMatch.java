package algorithms.characterMatch;

/**
 * 字符串匹配算法
 */
public class CharacterMatch {
    public static String mainString = "abcacabcbcbacabc";
    public static String modeString = "cbacabc";
    private static final int SIZE = 256;
    public static void main(String[] args) {
        CharacterMatch cm = new CharacterMatch();
        int index = cm.bm(mainString.toCharArray(), mainString.length(), modeString.toCharArray(), modeString.length());
        System.out.println(index);
        System.out.println(cm.bfMatch(mainString.toCharArray(), mainString.length(), modeString.toCharArray(), modeString.length()));
    }

    /**
     * bf算法
     * @return
     */
    public int bfMatch(char[] a, int n, char[] b, int m) {
        int i = 0;//模式串在主串中匹配时的起始下标
        while (i <= n-m) {
            int j;
            for (j = 0; j < m; j++) {
                if (b[j] != a[i+j]) break;
            }
            if (j == m) return i;
            i++;
        }
        if (i == n-m+1) return -1;
        else return i;
    }

    //a,b表示主串和模式串；n,m表示主串和模式串的长度
    public int bm(char[] a, int n, char[] b, int m) {
        int[] bc = new int[SIZE]; //记录模式串中每个字符最后出现的位置
        generateBC(b, m, bc); //构建坏字符哈希表
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGC(b, m, suffix, prefix);
        int i = 0;//j表示主串与模式串匹配起始地址
        while (i <= n-m) {
            int j;//当前匹配的字符在模式串中的位置
            for (j = m-1;j >= 0; j--) { //模式串从后往前匹配
                if (a[i+j]!=b[j]) {
                    break; //坏字符对应模式串中的下标j
                }
            }

            if (j < 0) {
                return i;//匹配成功，返回主串与模式串第一个匹配的字符的位置
            }

            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if (j < m - 1) {//如果有好后缀的话
                y = moveByGS(j, m, suffix, prefix);
            }
            i += Math.max(x, y);
        }
        return -1;
    }

    private void generateBC(char[] b, int m, int[] bc) {
        //初始化散列表
        for (int i = 0; i < SIZE; i++) {
            bc[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            //计算b[i]的ascii码
            int ascii = (int)b[i];
            bc[ascii] = i;
        }
    }

    private void generateGC(char[] b, int m, int[] suffix, boolean[] prefix) {
        //初始化
        for (int i = 0; i < m; i++) {
            suffix[i] = -1;
            prefix[i] = false;
        }

        //求公共后缀子串
        for (int i = 0; i < m-1; i++) {
            int k = 0;
            int j = i;
            while (j >= 0 && b[j]==b[m-1-k]) {
                --j;
                ++k;
                suffix[k] = j+1;
            }
            if (j == -1) {
                prefix[k] = true;
            }
        }
    }

    // j 表示坏字符对应的模式串中的字符下表
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        int k = m - 1 - j;
        if (suffix[k] != -1) return j-suffix[k]+1;
        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }
}
