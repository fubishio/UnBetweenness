import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class testing {
	
	public static void twenty(int constraints) {
		try {
			if (constraints < 6 || constraints > 500) {
				throw new Error("invalid constraints amount");
			}
			Path file = Paths.get("testingBatch\\input20.in");
			String newline = System.getProperty("line.separator");
			ArrayList<String> templist = new ArrayList<String>();
			templist.add("a");
			templist.add("b");
			templist.add("c");
			templist.add("d");
			templist.add("e");
			templist.add("f");
			templist.add("g");
			templist.add("h");
			templist.add("i");
			templist.add("j");
			templist.add("k");
			templist.add("l");
			templist.add("m");
			templist.add("n");
			templist.add("o");
			templist.add("p");
			templist.add("q");
			templist.add("r");
			Collections.sort(templist);
			Files.write(file, "18".getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			String tempstring;
			for (int k = 0; k < 18; k++){
				tempstring = templist.get(k) + " ";
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			
			Collections.shuffle(templist);
			String[] tempsorter;
			String[] tempprinter;
			Random randy = new Random();
			
			Files.write(file, String.valueOf(constraints).getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			for (int i = 0; i < 18; i = i +3){
				tempsorter = new String[] {templist.get(i), templist.get(i+1).toString(), templist.get(i+2).toString()};
				System.out.print("randyletter: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				Arrays.sort(tempsorter);
				System.out.print("lexisort: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			}
			for(int i = 0; i < constraints-6; i++){
				Collections.shuffle(templist);
				tempsorter = new String[] {templist.get(0), templist.get(1).toString(), templist.get(2).toString()};
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			
			
			}
		} catch (IOException e) {
			System.out.print("can't append");
		}	
	}
	
	
	
	
	public static void thirtyfive(int constraints) {
		try {
			if (constraints < 11 || constraints > 500) {
				throw new Error("invalid constraints amount");
			}
			Path file = Paths.get("testingBatch\\input35.in");
			String newline = System.getProperty("line.separator");
			ArrayList<String> templist = new ArrayList<String>();
			templist.add("a");
			templist.add("b");
			templist.add("c");
			templist.add("d");
			templist.add("e");
			templist.add("f");
			templist.add("g");
			templist.add("h");
			templist.add("i");
			templist.add("j");
			templist.add("k");
			templist.add("l");
			templist.add("m");
			templist.add("n");
			templist.add("o");
			templist.add("p");
			templist.add("q");
			templist.add("r");
			templist.add("s");
			templist.add("t");
			templist.add("u");
			templist.add("v");
			templist.add("w");
			templist.add("x");
			templist.add("y");
			templist.add("z");
			templist.add("aa");
			templist.add("ab");
			templist.add("ac");
			templist.add("ad");
			templist.add("ae");
			templist.add("af");
			templist.add("ag");
			Collections.sort(templist);
			Files.write(file, "33".getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			String tempstring;
			for (int k = 0; k < 33; k++){
				tempstring = templist.get(k) + " ";
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			Collections.shuffle(templist);
			
			String[] tempsorter;
			String[] tempprinter;
			Random randy = new Random();
			Files.write(file, String.valueOf(constraints).getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			for (int i = 0; i < 33; i = i +3){
				tempsorter = new String[] {templist.get(i), templist.get(i+1).toString(), templist.get(i+2).toString()};
				System.out.print("randyletter: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				Arrays.sort(tempsorter);
				System.out.print("lexisort: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			}
			
			for(int i = 0; i < constraints-11; i++){
				Collections.shuffle(templist);
				tempsorter = new String[] {templist.get(0), templist.get(1).toString(), templist.get(2).toString()};
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			
			
			}
			
		} catch (IOException e) {
			System.out.print("can't append");
		}

	}
	
	public static void fifty(int constraints) {
		try {
			if (constraints < 16 || constraints > 500) {
				throw new Error("invalid constraints amount");
			}
			Path file = Paths.get("testingBatch\\input50.in");
			String newline = System.getProperty("line.separator");
			ArrayList<String> templist = new ArrayList<String>();
			templist.add("a");
			templist.add("b");
			templist.add("c");
			templist.add("d");
			templist.add("e");
			templist.add("f");
			templist.add("g");
			templist.add("h");
			templist.add("i");
			templist.add("j");
			templist.add("k");
			templist.add("l");
			templist.add("m");
			templist.add("n");
			templist.add("o");
			templist.add("p");
			templist.add("q");
			templist.add("r");
			templist.add("s");
			templist.add("t");
			templist.add("u");
			templist.add("v");
			templist.add("w");
			templist.add("x");
			templist.add("y");
			templist.add("z");
			templist.add("aa");
			templist.add("ab");
			templist.add("ac");
			templist.add("ad");
			templist.add("ae");
			templist.add("af");
			templist.add("ag");
			templist.add("ah");
			templist.add("ai");
			templist.add("aj");
			templist.add("ak");
			templist.add("al");
			templist.add("am");
			templist.add("an");
			templist.add("ao");
			templist.add("ap");
			templist.add("aq");
			templist.add("ar");
			templist.add("as");
			templist.add("at");
			templist.add("au");
			templist.add("av");

			Collections.sort(templist);
			Files.write(file, "48".getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			String tempstring;
			for (int k = 0; k < 48; k++){
				tempstring = templist.get(k) + " ";
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
			}
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			Collections.shuffle(templist);
			
			String[] tempsorter;
			String[] tempprinter;
			Random randy = new Random();
			Files.write(file, String.valueOf(constraints).getBytes(), StandardOpenOption.APPEND);
			Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
			for (int i = 0; i < 48; i = i +3){
				tempsorter = new String[] {templist.get(i), templist.get(i+1).toString(), templist.get(i+2).toString()};
				System.out.print("randyletter: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				Arrays.sort(tempsorter);
				System.out.print("lexisort: "+tempsorter[0]+tempsorter[1]+tempsorter[2] + "\n");
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			}
			for(int i = 0; i < constraints-16; i++){
				Collections.shuffle(templist);
				tempsorter = new String[] {templist.get(0), templist.get(1).toString(), templist.get(2).toString()};
				if(randy.nextBoolean()){
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[0], tempsorter[1], tempsorter[2]};
					} else {
						tempprinter = new String[] {tempsorter[1], tempsorter[0], tempsorter[2]};
					}
				} else {
					if (randy.nextBoolean()) {
						tempprinter = new String[] {tempsorter[1], tempsorter[2], tempsorter[0]};
					} else {
						tempprinter = new String[] {tempsorter[2], tempsorter[1], tempsorter[0]};
					}
				}
				tempstring = tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2];
				Files.write(file, tempstring.getBytes(), StandardOpenOption.APPEND);
				Files.write(file, newline.getBytes(), StandardOpenOption.APPEND);
				System.out.print("constraint: "+tempprinter[0]+" "+tempprinter[1]+" "+tempprinter[2]+"\n");
			
			
			}
		} catch (IOException e) {
			System.out.print("can't append");
		}

	}
	public static void main(String[] args){
		try {
			byte[] empty = {};
			File tmpDir1 = new File("testingBatch\\input20.in");
			File tmpDir2 = new File("testingBatch\\input35.in");
			File tmpDir3 = new File("testingBatch\\input50.in");
			Path dir = new Path("testingBatch");
			if (!dir.exists()) {
				dir.mkdir();
			}
			if (!tmpDir1.exists()){
				Files.write(Paths.get("testingBatch\\input20.in"), empty);
			}
			if (!tmpDir2.exists()){
				Files.write(Paths.get("testingBatch\\input35.in"), empty);
			}
			if (!tmpDir3.exists()){
				Files.write(Paths.get("testingBatch\\input50.in"), empty);
			}
		} catch (IOException e) {
			System.out.print("couldnt init file");
		}
		
		for(int i = 0; i <= 500; i++){
			if (i >= 6 && i < 11) {
				twenty(i);
			} 
			if (i >= 11 && i < 16) {
				twenty(i);
				thirtyfive(i);
			}
			if (i >= 16) {
				twenty(i);
				thirtyfive(i);
				fifty(i);
			}
			
		}
		
	}
	
	
}


