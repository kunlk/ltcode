class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickselect(nums, 0, n - 1, k);
        return nums[k-1];
    }

    private void quickselect(int[] nums, int start, int end, int k) {
        if (start >= end)
            return;
        
        int pivot = median3(nums,start,end);
        int i = start;
        int j = end;
        
        while (i <= j) {
            while (nums[i] > pivot)
                i++;
            
            while (nums[j] < pivot)
                j--;
            
            if (i <= j)
                swap(nums, i++, j--);
        }
        
        if (k == i)
            return;
        if (k < i)
            quickselect(nums, start, i - 1, k);
        else
            quickselect(nums, i, end, k);    
    }

    private int median3(int[] arrs, int left, int right) {
        int center = (left + right) / 2;
        if(arrs[center] < arrs[left])
            swap(arrs,left,center);
        if(arrs[right] < arrs[left])
            swap(arrs,left,right);
        if(arrs[right] < arrs[center])
            swap(arrs,center,right);
        
        return arrs[center];
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
