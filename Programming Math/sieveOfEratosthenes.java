import java.util.*;
import java.io.*;

public class sieveOfEratosthenes {

    // make it false if Multiple test case is not in the question
    static boolean multipleTC = false;
    int TestCase = 1;

    // for pre processing if needed
    void pre() throws Exception {
    }

    public static void main(String[] args) throws Exception {

        new sieveOfEratosthenes().run();
    }

    // input output handled here
    void sieveOfEratosthenes(int n) {

        boolean[] prime = new boolean[n + 1];
        for (int i = 3; i <= n; i += 2) {
            prime[i] = true;
        }
        prime[2] = true;
        long count = 1;
        StringBuilder sb = new StringBuilder("2\n");

        for (long i = 3; i * i <= n; i += 2) {

            if (prime[(int) i]) {

                for (long j = i * i; j <= n; j += i) {
                    prime[(int) j] = false;
                }

            }
        }
        for (long i = 3; i <= n; i += 2) {
            if (prime[(int) i]) {
                count++;
                if (count % 100 == 1)
                    sb.append(i + "\n");

            }
        }

        p(sb);

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

        // StringBuilder print = new StringBuilder("");
        pre();

        sieveOfEratosthenes((int) 1e8);
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
        pln("#" + TestCase + " = " + x);
    }

    void deb2(Object x, Object y) {
        pln("#" + TestCase + " = " + x + " , " + y);
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