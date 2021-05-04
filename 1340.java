class Solution {
    Map<Integer, Integer> map = new HashMap();
    public int maxJumps(int[] arr, int d) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(i)) continue;
            max = Math.max(max, jumpFrom(arr, d, i));
        }
        return max;
    }
    
    private int jumpFrom(int[] arr, int d, int start) {
        if (start < 0 || start > arr.length - 1) return 0;
        if (map.containsKey(start)) return map.get(start);
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        int height = 0;
        for(int i = start + 1; i <= start + d && i < arr.length; i++) {
            if (arr[i] >= arr[start]) break;
            if (arr[i] > height) {
                height = arr[i];
                right.clear();
                right.add(i);
            }
            else if (arr[i] == height) {
                right.add(i);
            }
        }
        height = 0;
        for(int i = start - 1; i >= start - d && i >= 0; i--) {
            if (arr[i] >= arr[start]) break;
            if (arr[i] > height) {
                height = arr[i];
                left.clear();
                left.add(i);
            }
            else if (arr[i] == height) {
                left.add(i);
            }
        }
        int leftSum = 0;
        for(int l : left) {
            leftSum = Math.max(leftSum,jumpFrom(arr, d, l));
        }
        int rightSum = 0;
        for(int r : right) {
            rightSum = Math.max(rightSum,jumpFrom(arr, d, r));
        }
        int res = 1 + Math.max(leftSum, rightSum);
        map.put(start, res);
        return res;
    }
}