package crossTrainingDIY;

public class LargestContainer {
    // Given an array of non-negative integers, each of them representing the height of a board perpendicular to the horizontal line,
    // the distance between any two adjacent boards is 1.
    // Consider selecting two boards such that together with the horizontal line they form a container.
    // Find the volume of the largest such container.
    // 典型的双指针接雨水问题，只不过这里要找max，如果找总和也类似
    public int largest(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int max = 0;
        while(i < j){
            max = Math.max(max, Math.min(array[i], array[j]) * (j - i));
            if(array[i] <= array[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}
