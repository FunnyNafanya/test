import java.util.Arrays;

public class Squirrel {
    
    private int[] nuts;

    public Squirrel(int[] nuts) {
        this.nuts = Arrays.copyOf(nuts,nuts.length);
    }

    public int maxNuts (){
        int nutsCount = 0;

        if (nuts.length > 1) {
            for (int i = 0; i < nuts.length - 1; i++) {
                if (nuts[i] > 0 || nuts[i + 1] < nuts[i]) {
                    nutsCount += nuts[i];
                    if (nutsCount < 0)
                        nutsCount = 0;
                } else {
                    nutsCount += nuts[++i];
                    if (nutsCount < 0)
                        nutsCount = 0;
                }
            }
            if (nuts[nuts.length - 1] > 0 && nuts[nuts.length - 2] > 0)
                nutsCount += nuts[nuts.length - 1];
            if (nutsCount < 0)
                nutsCount = 0;
        }else {
            if (nuts[0] > 0)
                nutsCount += nuts[0];
        }
        return nutsCount;
    }

    public int getNuts(int n) {
        return nuts[n];
    }
}
