import java.util.*;
import java.io.*;

public class Main {

	// make it false if Multiple test case is not in the question
	static boolean multipleTC = true;
	int TestCase = 1;

	// for pre processing if needed
	void pre() throws Exception {
	}

	public static void main(String[] args) throws Exception {

		new Main().run();
	}

	// input output handled here
	private String solve(int tc) throws Exception {
		// code

		return "";
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

		StringBuilder print = new StringBuilder("");
		pre();
		int T = (multipleTC) ? ni() : 1;
		for (int t = 1; t <= T; t++) {
			this.TestCase = t;
			print.append(solve(t)).append("\n");
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