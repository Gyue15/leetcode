package easy;

public class Bits {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            if ((n & 1) == 1)
                ans++;
            n >>= 1;
        }
        return ans;

    }

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Bits().hammingWeight(11));
    }
}
