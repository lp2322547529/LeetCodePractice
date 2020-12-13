package ArrayProblems;

/**
 * @author:linpeng
 * @date:20201213
 * @version:v1.0
 */
public class RemoveDuplicatesOfArray {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) {
            return nums.length;
        }

        int current = nums[0];
        int pos = 0;
        int temp;
        for(int i = 1; i < nums.length; i++) {
            temp = nums[i];
            if(temp == current) {
                continue;
            }

            nums[pos + 1] = temp;
            current = temp;
            pos++;
        }

        return pos + 1;
    }

    public int removeElement(int[] nums, int val) {
        int pos = -1;
        int current;
        for(int i = 0; i < nums.length; i++) {
            current = nums[i];
            if(current == val) {
                continue;
            }

            nums[++pos] = current;
        }

        return pos + 1;
    }
}
