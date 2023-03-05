package array;

public class MinimumThreeArrayDistance {
    // Given three sorted integer arrays, pick one element from each of them, what is the min value of |x - y| + |y - z| + |z - x|.

    public int minDistance(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        int result = Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]);

        while(i < a.length && j < b.length && k < c.length){
            int tmp = Math.abs(a[i] - b[j]) + Math.abs(b[j] - c[k]) + Math.abs(c[k] - a[i]);
            result = Math.min(result, tmp);

            if(a[i] < b[j] && a[i] < c[k]){
                i++;
            }
            else if(b[j] < a[i] && b[j] < c[k]){
                j++;
            }
            else if(c[k] < a[i] && c[k] < b[j]){
                k++;
            }
            else if(a[i] == b[j] && a[i] < c[k]){
                i++;
                j++;
            }
            else if(a[i] == c[k] && a[i] < b[j]){
                i++;
                k++;
            }
            else if(b[j] == c[k] && b[j] < a[i]){
                j++;
                k++;
            }
            else{
                return 0;
            }
        }
        return result;
    }
}
