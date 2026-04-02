package org.dsa.binarySearch;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r-l) / 2;

            if(nums[m] == target){
                return m;
            }

            if(nums[l] == nums[m]) {
                l = m+1;
            } else if (nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        int pivot = l;
        l = 0;
        r = nums.length-1;

        if(target >= nums[pivot] && target <= nums[r]) {
            l = pivot;
        } else {
            r = pivot-1;
        }

        return binarySearch(nums, target, l, r);

//        int result = binarySearch(nums, target, 0, pivot - 1);
//        if (result != -1) {
//            return result;
//        }
//
//        return binarySearch(nums, target, pivot, nums.length - 1);

    }

    public int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {

            int mid = (l + r) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums [r]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }

        return -1;
    }

    private int binarySearch(int[] nums, int target, int left, int right) {

        while(left <= right) {
            int mid = left + (right-left)/2;

            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int val = searchInRotatedSortedArray.search(new int[]{3,3,1,3}, 1);
        System.out.println("Search In Rotated Sorted Array: "+val);
    }
}
