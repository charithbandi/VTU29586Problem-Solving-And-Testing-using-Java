class Solution {
    public int pivotIndex(int[] arr) {
        int[] pre = new int[arr.length];

        pre[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            pre[i] = pre[i - 1] + arr[i - 1];
        }

        int[] sufFixArr = suffix(arr);

        int min = Math.min(pre.length, sufFixArr.length);

        for (int i = 0; i < min; i++) {
            if (pre[i] == sufFixArr[i]) {
                if (i == 0) {
                    return 0;
                }
                return i;
            }
        }

        return -1;
    }

    public int[] suffix(int[] arr) {

        int[] suff = new int[arr.length];

        suff[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + arr[i + 1];
            ;
        }

        return suff;
    }

}