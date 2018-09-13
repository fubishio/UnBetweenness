import java.util.*;
import java.io.*;

public class PreProcessor {
	public static HashMap<Set<Integer>, Integer> map;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("examples\\examplepreprocessorinput.in"));
		PrintWriter writer = new PrintWriter("examples\\result.cnf", "UTF-8");
		int w = Integer.parseInt(sc.nextLine());
		int c = Integer.parseInt(sc.nextLine());
		
		int numVariables = w * (w - 1) / 2;
		int numDAGClauses = 2 * (2 * w * (w - 1) * (w - 2) / 24);
		int numClauses = numDAGClauses + 2 * c;
		writer.println("p cnf " + numVariables + " " + numClauses);
		// Setup mapping of people pairs to SAT variables
		map = new HashMap<Set<Integer>, Integer>();
		int mapCount = 1;
		for (int i = 0; i < w; i++) {
			for (int j = i + 1; j < w; j++) {
				Set<Integer> s = new HashSet<Integer>();
				s.add(i);
				s.add(j);
				map.put(s, mapCount);
				mapCount++;
			}
		}
		int people_counter = 0;
		HashMap<String, Integer> people = new HashMap<String, Integer>();
		String[] people_names = new String[w];
		// Process all constraints to get people names and input constraints
		for (int i = 0; i < c; i++) {
			String[] names = sc.nextLine().split(" ");
			int[] nums = new int[3];
			for (int j = 0; j < 3; j++) {
				if (!people.containsKey(names[j])) {
					people.put(names[j], people_counter);
					people_names[people_counter] = names[j];
					people_counter++;
				}
				nums[j] = people.get(names[j]);
			}
			// Generate Input Constraints
			Set<Integer> s_ik = new HashSet<Integer>();
			Set<Integer> s_jk = new HashSet<Integer>();
			s_ik.add(nums[0]);
			s_ik.add(nums[2]);
			s_jk.add(nums[1]);
			s_jk.add(nums[2]);
			int x_ik = map.get(s_ik);
			int x_jk = map.get(s_jk);
			// Correct for reversed ordering caused by set
			if (nums[0] > nums[2])
				x_ik *= -1;
			if (nums[1] > nums[2])
				x_jk *= -1;
			int nx_ik = -x_ik;
			int nx_jk = -x_jk;
			writer.println(x_ik + " " + nx_jk + " 0");
			writer.println(nx_ik + " " + x_jk + " 0");
		}
		// Generate DAG Constraints
		for (int i = 0; i < w; i++) {
			for (int j = i + 1; j < w; j++) {
				for (int k = j + 1; k < w; k++) {
					Set<Integer> s_ij = new HashSet<Integer>();
					Set<Integer> s_ik = new HashSet<Integer>();
					Set<Integer> s_jk = new HashSet<Integer>();
					s_ij.add(i);
					s_ij.add(j);
					s_ik.add(i);
					s_ik.add(k);
					s_jk.add(j);
					s_jk.add(k);
					int x_ij = map.get(s_ij);
					int x_ik = map.get(s_ik);
					int x_jk = map.get(s_jk);
					int nx_ij = -x_ij;
					int nx_ik = -x_ik;
					int nx_jk = -x_jk;
					writer.println(nx_ij + " " + nx_jk + " " + x_ik + " 0");
					writer.println(x_ij + " " + x_jk + " " + nx_ik + " 0");
				}
			}
		}
		writer.close();
	}
}
