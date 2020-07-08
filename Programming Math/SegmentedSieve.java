import java.util.*;
import java.io.*;

public class SegmentedSieve {

    // make it false if Multiple test case is not in the question
    static boolean multipleTC = false;
    int TestCase = 1;

    // for pre processing if needed
    void pre() throws Exception {
    }

    public static void main(String[] args) throws Exception {

        new SegmentedSieve().run();
    }

    // input output handled here
    final static int N = (int) 1e8;
    final static int block_size = (int) 1e4;
    StringBuilder primes = new StringBuilder((int) 1e8);

    private ArrayList<Integer> sieveOfEratosthenes(int n, ArrayList<Integer> arrayOfPrimes) {
        boolean helper[] = new boolean[n + 1];
        arrayOfPrimes.add(2);
        for (int i = 3; i <= n; i += 2)
            helper[i] = true;

        for (int i = 3; i <= n; i += 2) {
            if (helper[i]) {
                // arrayOfPrimes.add(i);
                for (int j = i * i; j <= n; j += i)
                    helper[j] = false;
            }
        }
        for (int i = 3; i <= n; i += 2)
            if (helper[i])
                arrayOfPrimes.add(i);

        return arrayOfPrimes;
    }

    private String segmentedSieve() throws Exception {
        // int n=ni();

        int nsqrt = (int) Math.sqrt(N);

        ArrayList<Integer> prime_sqrt = new ArrayList<>();

        sieveOfEratosthenes(nsqrt, prime_sqrt);

        int count = 0;
        boolean[] block = new boolean[block_size];

        for (int i = 0; i * block_size <= N; i++) {
            Arrays.fill(block, true);
            int start = i * block_size;
            for (int p : prime_sqrt) {
                int start_indx = (start + p - 1) / p;
                int j = Math.max(start_indx, p) * p - start;
                for (; j < block_size; j += p)
                    block[j] = false;
            }
            if (i == 0)
                block[0] = block[1] = false;
            for (int k = 0; k < block_size && start + k <= N; k++) {
                if (block[k]) {
                    count++;

                    primes.append((start + k) + "");
                }
            }

        }
        // return no of primes and builds primes stringbulder till N using segments
        return "" + count;
    }

    void run() throws Exception {
        // long start_time = System.nanoTime();

        try {
            in = new FastReader("in0.txt");
            out = new PrintWriter("out0.txt");
        } catch (Exception e) {
            in = new FastReader();
            out = new PrintWriter(System.out);
        }
        pre();
        StringBuilder print = new StringBuilder("");

        int T = (multipleTC) ? ni() : 1;
        for (int t = 1; t <= T; t++) {
            this.TestCase = t;
            print.append(segmentedSieve() + "\n");
        }

        p(print);
        // long end_time = System.nanoTime();
        // System.out.printf("Running Time in sec : %2.10f", (double) (end_time -
        // start_time) * (double) 1e-9);

        out.flush();
        out.close();
    }

    PrintWriter out;
    FastReader in;

    void p(Object o) {
        out.print(o);
    }

    void pln(Object o) {
        out.println(o);
    }

    void pnf(Object o) {
        out.println(o);
        out.flush();
    }

    void deb(Object x) {
        System.out.println("#" + TestCase + " = " + x);
    }

    void deb2(Object x, Object y) {
        System.out.println("#" + TestCase + " = " + x + " , " + y);
    }

    String n() throws Exception {
        return in.next();
    }

    String nln() throws Exception {
        return in.nextLine();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

    long nl() throws Exception {
        return Long.parseLong(in.next());
    }

    double nd() throws Exception {
        return Double.parseDouble(in.next());
    }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }

        String nextLine() throws Exception {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new Exception(e.toString());
            }
            return str;
        }
    }
}