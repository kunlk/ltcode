class Solution {
    public int findKthLargest(int[] nums, int k) {
        partition(nums, 0, nums.length-1, k);
        return nums[k-1];
    }
    
    void partition(int[] nums, int start, int end, int k){
        if(start >= end)
            return;
        
        int i = start;
        int j = end;
        int pivot = median3(nums, start, end);
        
        while(i <= j){
            while(nums[i] > pivot)
                i++;
            while(nums[j] < pivot)
                j--;
            if(i <= j){
                swap(nums, i++, j--);
            }
        }
        
        if(k <= i){
            partition(nums, start, i - 1, k);
        }else{
            partition(nums, i, end, k);
        }
    }
    
    void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    
    int median3(int[] nums, int left, int right){
        int center = (right + left) / 2;
        if(nums[left] < nums[center]){
            swap(nums, left, center);
        }else if (nums[left] < nums[right]){
            swap(nums, left, right);
        }else if (nums[center] < nums[right]){
            swap(nums, center, right);
        }
        return nums[center];
    }
}
