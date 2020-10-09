import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.*;
import java.lang.Math;

public class Shapez3 {
	
	static ArrayList<String> shape = new ArrayList<String>();
	static int[] testIfShapeExist = new int [65536];
	static ArrayList<String> shapeText = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		//.size()
		//.get()
		//.add()
			
		for (int i = 3; i < testIfShapeExist.length; i++) {
			testIfShapeExist[i] = 0;
		}
		
		testIfShapeExist[0] = 1;
		testIfShapeExist[1] = 1;
		testIfShapeExist[2] = 1;
		testIfShapeExist[4] = 1;
		testIfShapeExist[8] = 1;
		
		shape.add("0000:0000:0000:0000");
		shape.add("1000:0000:0000:0000");
		shape.add("0100:0000:0000:0000");
		shape.add("0010:0000:0000:0000");
		shape.add("0001:0000:0000:0000");
		
		shapeText.add("0000:0000:0000:0000 (0)"); 
		shapeText.add("1000:0000:0000:0000 (1)");
		shapeText.add("0100:0000:0000:0000 (2)");
		shapeText.add("0010:0000:0000:0000 (3)");
		shapeText.add("0001:0000:0000:0000 (4)");
		
		int shapeSizeNew = 1;
		int shapeSizeOld = 0;
		int testNumber = 0;
		
		
		while(shapeSizeNew != shapeSizeOld) {
			testNumber++; //Could remove
			int shapeSizeOldOld = shapeSizeOld;
			shapeSizeOld = shape.size() - 1;
			
			int myVariableNamesAreGood = -1;
			
			while(myVariableNamesAreGood != shape.size()) {
				myVariableNamesAreGood = shape.size();
				for (int i = 0; i <= shape.size() - 1; i++) {
					for (int j = 0; j <=shape.size() - 1; j++) {
						if((i >= shapeSizeOldOld)||(j >= shapeSizeOldOld)) {
							String temporaryString = stacker(shape.get(i),shape.get(j));
							
							if(testIfShapeExist[getShapesNumber(temporaryString)] == 0) {
								testIfShapeExist[getShapesNumber(temporaryString)] = 1;
								shape.add(temporaryString);
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = " + shape.get(i) + " (" + i + ") + " + shape.get(j) + " (" + j + ")");
								System.out.println(shapeSizeOldOld + " " + i + " " + j + " " + testNumber + " " + (shape.size() - 1) + " " + temporaryString);	
							}
						}
					}
				}
			}
			
			myVariableNamesAreGood = -1;
			
			while(myVariableNamesAreGood != shape.size()) {
				myVariableNamesAreGood = shape.size();
				for (int i = 0; i <= shape.size() - 1; i++) {
					for (int j = 0; j <= 3; j++) {
						String temporaryString = splitter(shape.get(i), j);
						
						if(testIfShapeExist[getShapesNumber(temporaryString)] == 0) {
							testIfShapeExist[getShapesNumber(temporaryString)] = 1;
							shape.add(temporaryString);
							System.out.println(testNumber + " " + shape.size() + " " + temporaryString);
							
							
							if(j == 0) {
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = Left part of " + shape.get(i) + " (" + i + ")");
							}
							else if(j == 1) {
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = Upper part of " + shape.get(i) + " (" + i + ")");
							}
							else if(j == 2) {
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = Right part of " + shape.get(i) + " (" + i + ")");
							}
							else {
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = Lower part of " + shape.get(i) + " (" + i + ")");
							}
							
						}
					}
				}
			}
	
			shapeSizeNew = shape.size() - 1;
		}
		
		int[] numberOfCorners = new int [17];
		
		for (int i = 0; i < shape.size(); i++) {
			int howMany1s = 0;
			for (int j = 0; j < 19; j++) {
				String tempString = shape.get(i);
				if(tempString.charAt(j) == '1') {
					howMany1s++;
				}
			}
			numberOfCorners[howMany1s]++;
		}
		
		
		System.out.println("Its textfile time!");
		
		try {
			File file = new File("ShapezShapesTest2.txt");
		      
			if (!file.exists()) {
				file.createNewFile();
			}  
			PrintWriter pw = new PrintWriter(file);
			
			for (int i = 0; i < 17; i++) {
				pw.println(i + ": " + numberOfCorners[i]);
			}
			
			pw.println("shapes:");
			
			for (int i = 0; i < shapeText.size(); i++) {
				pw.println(shapeText.get(i));
			}
			
			pw.close();	
		}
		catch (IOException e) {
			e.printStackTrace();
			System.out.println("Error");
		}
		
		System.out.println("Done!");
	}

	public static int getShapesNumber(String shape) {
		int output = 0;
		for (int layer = 0; layer <= 3; layer++) {
			for (int corner = 0; corner <= 3; corner++) {
				if(shape.charAt(corner + 5 * layer) == '1') {
					output += Math.pow(2, corner + 4 * layer);
				}
			}
		}
		return output;
	}
	
	public static String splitter(String shape, int direction) {
		char[] charArray = shape.toCharArray();
		 
		for (int layer = 0; layer <= 3; layer++) {
			 charArray[5 * layer + (direction)] = '0';
			 charArray[5 * layer + ((direction + 1) % 4)] = '0';
		}
		
		for (int i = 0; i <= 2; i++) {
			for (int layer = 2; layer >= 0; layer--) {
				if(charArray[5 * layer] == '0' && charArray[5 * layer + 1] == '0' && charArray[5 * layer + 2] == '0' && charArray[5 * layer + 3] == '0') {
					for (int corner = 0; corner <= 3; corner++) {
						charArray[5 * layer + corner] = charArray[5 * layer + corner + 5];
						charArray[5 * layer + corner + 5] = '0';
					}
				}
			}
		}
		
		return new String(charArray);
	}
	
	public static boolean testIfStringInArray(String testString) {
		//I dont use this.
		boolean stringIsInArray = false;
		for (int i = 0; i < shape.size(); i++) {
			if(shape.get(i).equals(testString)) {
				stringIsInArray = true;
				break;
			}
		}
		return(stringIsInArray);
	}
	
	public static String stacker(String shapeLeft, String shapeRight) {
		for (int layerLeft = 0; layerLeft <= 3; layerLeft++) {
			for (int layerRight = 0; layerRight <= 3; layerRight++) {
				boolean replace = true;
				for (int corner = 0; corner <= 3; corner++) {
					if(!((shapeLeft.charAt(corner + 5 * layerLeft) == '0') || (shapeRight.charAt(corner + 5 * layerRight) == '0'))){
						replace = false;
						break;
					}
				}
				if(replace) {
					for (int corner = 0; corner <= 3; corner++) {
						if((shapeLeft.charAt(corner + 5 * layerLeft) != '0')) {
							shapeRight = changeCharInPosition(corner + 5 * layerRight, shapeLeft.charAt(corner + 5 * layerLeft), shapeRight);
						}
					}
					break;
				}	
			}
		}
		return(shapeRight);
	}
	
	public static String changeCharInPosition(int position, char ch, String str){
	    char[] charArray = str.toCharArray();
	    charArray[position] = ch;
	    return new String(charArray);
	}
}
