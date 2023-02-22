package practice2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

public class I {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        br.close();

        long n = s.length;
        int[] sa = StringAC.suffixArray(s);
        int[] la = StringAC.lcpArray(s, sa);
        long ans = n * (n + 1) / 2;
        for (int x : la) {
            ans -= x;
        }
        System.out.println(ans);
    }
}

class StringAC {
    private static final int THRESHOLD_NAIVE = 50;

    public static int[] suffixArray(char[] s) {
        int n = s.length;
        int[] s2 = new int[n];
        for (int i = 0; i < n; i++) {
            s2[i] = s[i];
        }
        return sais(s2, 255);
    }

    public static int[] suffixArray(int[] s) {
        int n = s.length;
        int[] vals = Arrays.copyOf(s, n);
        Arrays.sort(vals);
        int p = 1;
        for (int i = 1; i < n; i++) {
            if (vals[i] != vals[i - 1]) {
                vals[p++] = vals[i];
            }
        }
        int[] s2 = new int[n];
        for (int i = 0; i < n; i++) {
            s2[i] = Arrays.binarySearch(vals, 0, p, s[i]);
        }
        return sais(s2, p);
    }

    public static int[] suffixArray(int[] s, int upper) {
        assert (0 <= upper);
        for (int d : s) {
            assert (0 <= d && d <= upper) : "d=" + d + ", upper=" + upper;
        }
        return sais(s, upper);
    }

    public static int[] lcpArray(char[] s, int[] sa) {
        int n = s.length;
        int[] s2 = new int[n];
        for (int i = 0; i < n; i++) {
            s2[i] = s[i];
        }
        return lcpArray(s2, sa);
    }

    public static int[] lcpArray(int[] s, int[] sa) {
        int n = s.length;
        assert (n >= 1);
        int[] rnk = new int[n];
        for (int i = 0; i < n; i++) {
            rnk[sa[i]] = i;
        }
        int[] lcp = new int[n - 1];
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (h > 0) h--;
            if (rnk[i] == 0) {
                continue;
            }
            int j = sa[rnk[i] - 1];
            for (; j + h < n && i + h < n; h++) {
                if (s[j + h] != s[i + h]) break;
            }
            lcp[rnk[i] - 1] = h;
        }
        return lcp;
    }

    public static int[] zAlgorithm(char[] s) {
        int n = s.length;
        if (n == 0) return new int[0];
        int[] z = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            int k = j + z[j] <= i ? 0 : Math.min(j + z[j] - i, z[i - j]);
            while (i + k < n && s[k] == s[i + k]) k++;
            z[i] = k;
            if (j + z[j] < i + z[i]) j = i;
        }
        z[0] = n;
        return z;
    }

    public static int[] zAlgorithm(int[] s) {
        int n = s.length;
        if (n == 0) return new int[0];
        int[] z = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            int k = j + z[j] <= i ? 0 : Math.min(j + z[j] - i, z[i - j]);
            while (i + k < n && s[k] == s[i + k]) k++;
            z[i] = k;
            if (j + z[j] < i + z[i]) j = i;
        }
        z[0] = n;
        return z;
    }

    private static int[] sais(int[] s, int upper) {
        int n = s.length;
        if (n == 0) return new int[0];
        if (n == 1) return new int[]{0};
        if (n == 2) {
            if (s[0] < s[1]) {
                return new int[]{0, 1};
            } else {
                return new int[]{1, 0};
            }
        }
        if (n < THRESHOLD_NAIVE) {
            return saNaive(s);
        }

        int[] sa = new int[n];
        boolean[] ls = new boolean[n];
        for (int i = n - 2; i >= 0; i--) {
            ls[i] = s[i] == s[i + 1] ? ls[i + 1] : s[i] < s[i + 1];
        }

        int[] sumL = new int[upper + 1];
        int[] sumS = new int[upper + 1];

        for (int i = 0; i < n; i++) {
            if (ls[i]) {
                sumL[s[i] + 1]++;
            } else {
                sumS[s[i]]++;
            }
        }

        for (int i = 0; i <= upper; i++) {
            sumS[i] += sumL[i];
            if (i < upper) sumL[i + 1] += sumS[i];
        }

        Consumer<int[]> induce = lms -> {
            Arrays.fill(sa, -1);
            int[] buf = new int[upper + 1];
            System.arraycopy(sumS, 0, buf, 0, upper + 1);
            for (int d : lms) {
                if (d == n) continue;
                sa[buf[s[d]]++] = d;
            }
            System.arraycopy(sumL, 0, buf, 0, upper + 1);
            sa[buf[s[n - 1]]++] = n - 1;
            for (int i = 0; i < n; i++) {
                int v = sa[i];
                if (v >= 1 && !ls[v - 1]) {
                    sa[buf[s[v - 1]]++] = v - 1;
                }
            }
            System.arraycopy(sumL, 0, buf, 0, upper + 1);
            for (int i = n - 1; i >= 0; i--) {
                int v = sa[i];
                if (v >= 1 && ls[v - 1]) {
                    sa[--buf[s[v - 1] + 1]] = v - 1;
                }
            }
        };

        int[] lmsMap = new int[n + 1];
        Arrays.fill(lmsMap, -1);
        int m = 0;
        for (int i = 1; i < n; i++) {
            if (!ls[i - 1] && ls[i]) {
                lmsMap[i] = m++;
            }
        }

        int[] lms = new int[m];
        {
            int p = 0;
            for (int i = 1; i < n; i++) {
                if (!ls[i - 1] && ls[i]) {
                    lms[p++] = i;
                }
            }
        }

        induce.accept(lms);

        if (m > 0) {
            int[] sortedLms = new int[m];
            {
                int p = 0;
                for (int v : sa) {
                    if (lmsMap[v] != -1) {
                        sortedLms[p++] = v;
                    }
                }
            }
            int[] recS = new int[m];
            int recUpper = 0;
            recS[lmsMap[sortedLms[0]]] = 0;
            for (int i = 1; i < m; i++) {
                int l = sortedLms[i - 1], r = sortedLms[i];
                int endL = (lmsMap[l] + 1 < m) ? lms[lmsMap[l] + 1] : n;
                int endR = (lmsMap[r] + 1 < m) ? lms[lmsMap[r] + 1] : n;
                boolean same = true;
                if (endL - l != endR - r) {
                    same = false;
                } else {
                    while (l < endL && s[l] == s[r]) {
                        l++;
                        r++;
                    }
                    if (l == n || s[l] != s[r]) same = false;
                }
                if (!same) {
                    recUpper++;
                }
                recS[lmsMap[sortedLms[i]]] = recUpper;
            }

            int[] recSA = sais(recS, recUpper);

            for (int i = 0; i < m; i++) {
                sortedLms[i] = lms[recSA[i]];
            }
            induce.accept(sortedLms);
        }
        return sa;
    }

    private static int[] saNaive(int[] s) {
        int n = s.length;
        int[] sa = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = i;
        }
        insertionsort(sa, (l, r) -> {
            while (l < n && r < n) {
                if (s[l] != s[r]) return s[l] - s[r];
                l++;
                r++;
            }
            return -(l - r);
        });
        return sa;
    }

    private static void insertionsort(int[] a, IntBinaryOperator comparator) {
        final int n = a.length;
        for (int i = 1; i < n; i++) {
            final int tmp = a[i];
            if (comparator.applyAsInt(a[i - 1], tmp) > 0) {
                int j = i;
                do {
                    a[j] = a[j - 1];
                    j--;
                } while (j > 0 && comparator.applyAsInt(a[j - 1], tmp) > 0);
                a[j] = tmp;
            }
        }
    }
}