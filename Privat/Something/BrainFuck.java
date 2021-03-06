
import java.util.ArrayList;
import java.util.Scanner;

public class BrainFuck {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<Byte> addressSpace = new ArrayList<Byte>();
		String brainFuckInput = input.nextLine();
		int address = 0;
		int repeatValue = -1;
		addressSpace.add((byte)(0));
		String stringOutput = "";
        //>++++++++++>+>+[[+++++[>++++++++<-]>.<++++++[>--------<-]+<<<]>.>>[[-]<[>+<-]>>[<<+>+>-]<[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>+<-[>[-]>+>+<<<-[>+<-]]]]]]]]]]]+>>>]<<<]
		
		
		for(int i = 0; i < brainFuckInput.length(); i++) {
			
			if(brainFuckInput.charAt(i) == '+') {
				addressSpace.set(address, (byte)(addressSpace.get(address) + 1));
			}
			
			else if(brainFuckInput.charAt(i) == '-') {
				addressSpace.set(address, (byte)(addressSpace.get(address) - 1));
			}
			
			else if(brainFuckInput.charAt(i) == '<' && address != 0) {
				
				if(address == 0) {
					System.out.println("error");
				}
				address--;
				
				display(address, addressSpace);	
			}
			
			else if(brainFuckInput.charAt(i) == '>') {
				if(address == addressSpace.size() - 1) {
					addressSpace.add((byte)(0));
				}
				address++;
				
				display(address, addressSpace);
			}
			
			else if (brainFuckInput.charAt(i) == '[') {
				
				if(addressSpace.get(address) == 0) {
					
					while(repeatValue < 0) {
						i++;
						if(brainFuckInput.charAt(i) == ']') {
							repeatValue++;
						}
						
						else if (brainFuckInput.charAt(i) == '['){
							repeatValue--;
						}
					}
					repeatValue = -1;
				}
			}
			
			else if(brainFuckInput.charAt(i) == ']') {
				
				if(addressSpace.get(address) != 0) {
					
					while(repeatValue < 0) {
						i--;
						if(brainFuckInput.charAt(i) == '[') {
							repeatValue++;
						}
						
						else if (brainFuckInput.charAt(i) == ']'){
							repeatValue--;
						}
					}
					repeatValue = -1;
				}
			}	
			
			else if(brainFuckInput.charAt(i) == '.') {
				stringOutput += (char)(int)addressSpace.get(address);
//				System.out.print((char)(int)addressSpace.get(address));
			}
			
			else if(brainFuckInput.charAt(i) == ',') {
				addressSpace.set(address, (byte)input.next().charAt(0));
			}
			
			else {
				System.out.println("error");
			}
		}
		
		System.out.println(stringOutput);
	}
	
	public static void display(int address, ArrayList addressSpace) {
		for(int j = 0; j < address; j++) {
			System.out.print(addressSpace.get(j) + " ");
		}
		
		System.out.print("[" + addressSpace.get(address) + "] ");
		
		for(int j = address + 1; j < addressSpace.size(); j++) {
			System.out.print(addressSpace.get(j) + " ");
		}
		
		System.out.println();
	}
}
