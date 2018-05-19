package easy;

public class Prime {

    public int countPrimesSlow(int n) {
        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i * i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrimes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrimes[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrimes[j] = false;
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                res++;
            }
        }
        return res;

    }
}
