import java.util.*;
import java.io.*;

public class PostProcessor {
	
	public static void main(String[] args) throws IOException {
		Scanner sc1 = new Scanner(new File("20.in"));
		Scanner sc2 = new Scanner(new File("satresult.txt"));
		PrintWriter writer = new PrintWriter("finalresult.txt", "UTF-8");
		int w = Integer.parseInt(sc1.nextLine());
		int c = Integer.parseInt(sc1.nextLine());
		
		int numVariables = w * (w - 1) / 2;
		
		// Setup reverse mapping of SAT variables back to people
		int[][] vars = new int[numVariables + 1][2];
		int mapCount = 1;
		for (int i = 0; i < w; i++) {
			for (int j = i + 1; j < w; j++) {
				vars[mapCount][0] = i;
				vars[mapCount][1] = j;
				mapCount++;
			}
		}
		
		int people_counter = 0;
		HashMap<String, Integer> people = new HashMap<String, Integer>();
		String[] people_names = new String[w];
		// Process all constraints to get people names
		for (int i = 0; i < c; i++) {
			String[] names = sc1.nextLine().split(" ");
			for (int j = 0; j < 3; j++) {
				if (!people.containsKey(names[j])) {
					people.put(names[j], people_counter);
					people_names[people_counter] = names[j];
					people_counter++;
				}
			}
		}
		
		int[][] order = new int[w][w];
		String[] values = sc2.nextLine().split(" ");
		assert(values.length == numVariables);
		for (String var : values) {
			int v = Integer.parseInt(var);
			int i = vars[Math.abs(v)][0];
			int j = vars[Math.abs(v)][1];
			
			// i > j
			if (v > 0) {
				order[i][j] = 1;
				order[j][i] = -1;
			}
			// j > i
			else {
				order[i][j] = -1;
				order[j][i] = 1;
			}
		}
		
		// Run topological sort on resultant ordering to get final order
		Queue<Integer> q = new LinkedList<Integer>();
		int[] inDegrees = new int[w];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < w; j++) {
				if (order[i][j] == -1)
					inDegrees[i]++;
			}
		}
		for (int i = 0; i < w; i++) {
			if (inDegrees[i] == 0)
				q.offer(i);
		}
		while (!q.isEmpty()) {
			int head = q.poll();
			System.out.print(people_names[head] + " ");
			for (int i = 0; i < w; i++) {
				if (order[head][i] == 1) {
					inDegrees[i]--;
					if (inDegrees[i] == 0)
						q.offer(i);
				}
			}
		}
		
		writer.close();
	}
}