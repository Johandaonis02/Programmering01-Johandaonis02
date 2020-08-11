import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;

public class ShapezOldNew {
	
	static ArrayList<String> shape = new ArrayList<String>();
	static boolean[] testIfShapeExist = new boolean [65536];
	static ArrayList<String> shapeText = new ArrayList<String>();
	static boolean[] shapeOnePointOne = new boolean [65536];
	static boolean[] shapeOnePointTwo = new boolean [65536];
	
	public static void main(String[] args) {
		
		//.size()
		//.get()
		//.add()
			
		for (int i = 3; i < testIfShapeExist.length; i++) {
			testIfShapeExist[i] = false;
		}
		
		testIfShapeExist[0] = true;
		shapeOnePointOne[0] = true;
		shapeOnePointTwo[0] = true;
		testIfShapeExist[1] = true;
		shapeOnePointOne[1] = true;
		shapeOnePointTwo[1] = true;
		testIfShapeExist[2] = true;
		shapeOnePointOne[2] = true;
		shapeOnePointTwo[2] = true;
		testIfShapeExist[4] = true;
		shapeOnePointOne[4] = true;
		shapeOnePointTwo[4] = true;
		testIfShapeExist[8] = true;
		shapeOnePointOne[8] = true;
		shapeOnePointTwo[8] = true;
		
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
		
		
		while(shapeSizeNew != shapeSizeOld) {
			int shapeSizeOldOld = shapeSizeOld;
			shapeSizeOld = shape.size() - 1;
			
			for (int i = 0; i <= shapeSizeOld; i++) {
				for (int j = 0; j <= shapeSizeOld; j++) {
					if((i >= shapeSizeOldOld)||(j >= shapeSizeOldOld)) {
						
						if(shapeOnePointTwo[getShapesNumber(shape.get(i))] == true && shapeOnePointTwo[getShapesNumber(shape.get(j))] == true && shapeOnePointOne[getShapesNumber(shape.get(i))] == true && shapeOnePointOne[getShapesNumber(shape.get(j))] == true) {
							String temporaryString = stackerOld(shape.get(i),shape.get(j));
							shapeOnePointOne[getShapesNumber(temporaryString)] = true;
							
							if(testIfShapeExist[getShapesNumber(temporaryString)] == false) {
								testIfShapeExist[getShapesNumber(temporaryString)] = true;
								shape.add(temporaryString);
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = " + shape.get(i) + " (" + i + ") + " + shape.get(j) + " (" + j + ")");
								System.out.println(i + " " + j + " " + (shape.size() - 1) + " " + temporaryString);	
							}
							
							temporaryString = stackerNew(shape.get(i),shape.get(j));
							shapeOnePointTwo[getShapesNumber(temporaryString)] = true;
							
							if(testIfShapeExist[getShapesNumber(temporaryString)] == false) {
								testIfShapeExist[getShapesNumber(temporaryString)] = true;
								shape.add(temporaryString);
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = " + shape.get(i) + " (" + i + ") + " + shape.get(j) + " (" + j + ")");
								System.out.println(i + " " + j + " " + (shape.size() - 1) + " " + temporaryString);	
							}
						}
						else if(shapeOnePointTwo[getShapesNumber(shape.get(i))] == true && shapeOnePointTwo[getShapesNumber(shape.get(j))] == true) {
							String temporaryString = stackerNew(shape.get(i),shape.get(j));
							shapeOnePointTwo[getShapesNumber(temporaryString)] = true;
							
							if(testIfShapeExist[getShapesNumber(temporaryString)] == false) {
								testIfShapeExist[getShapesNumber(temporaryString)] = true;
								shape.add(temporaryString);
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = " + shape.get(i) + " (" + i + ") + " + shape.get(j) + " (" + j + ")");
								System.out.println(i + " " + j + " " + (shape.size() - 1) + " " + temporaryString);	
							}
						}
						else if(shapeOnePointOne[getShapesNumber(shape.get(i))] == true && shapeOnePointOne[getShapesNumber(shape.get(j))] == true) {
							String temporaryString = stackerOld(shape.get(i),shape.get(j));
							shapeOnePointOne[getShapesNumber(temporaryString)] = true;
							
							if(testIfShapeExist[getShapesNumber(temporaryString)] == false) {
								testIfShapeExist[getShapesNumber(temporaryString)] = true;
								shape.add(temporaryString);
								shapeText.add(temporaryString + " (" + (shape.size() - 1) + ") = " + shape.get(i) + " (" + i + ") + " + shape.get(j) + " (" + j + ")");
								System.out.println(i + " " + j + " " + (shape.size() - 1) + " " + temporaryString);	
							}
						}
						
						
					}
				}
			}
			
			for (int i = shapeSizeOldOld; i <= shapeSizeOld; i++) {
				for (int j = 0; j <= 3; j++) {
					String temporaryString = splitter(shape.get(i), j);
					
					if(testIfShapeExist[getShapesNumber(temporaryString)] == false) {
						testIfShapeExist[getShapesNumber(temporaryString)] = true;
						shape.add(temporaryString);
						System.out.println(shape.size() + " " + temporaryString);
						
						
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
	
			shapeSizeNew = shape.size() - 1;
		}
		
		System.out.println("Its textfile time!");
		
		try {
			File file = new File("ShapezShapes.txt");
		      
			if (!file.exists()) {
				file.createNewFile();
			}  
			PrintWriter pw = new PrintWriter(file);
			
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
	
	public static String stackerOld(String shapeLeft, String shapeRight) {
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
