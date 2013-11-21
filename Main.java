import java.util.Scanner;

public class Kalah {
	
	static Player player1;
	static Player player2;
	static Board gameBoard;
	static int[] holes;
	static int initialSeed = 4;
	static boolean gameOver;
	

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		holes = new int[14];
		int storep1 = 6;
		int storep2 = 13;
		gameOver=false; //By default
		
		player1.setTurn(true);
		
		for(int i = 0; i < holes.length; i++){
			holes[i]=4;
			holes[storep1]= 0;
			holes[storep2]= 0;
		}
		for(int i = 0; i < holes.length; i++){
		System.out.println(holes[i]);
		}
		while(!gameOver){
			
			while(player1.getTurn()==true){
				
				System.out.println("Player 1's Turn.");
				System.out.print("Player 1, please select a house between 0 and 5 : ");
				int chosenp1 = in.nextInt();
				while(!(chosenp1==0||chosenp1==1 ||chosenp1==2 ||chosenp1==3 ||chosenp1==4 ||chosenp1==5)){ 
				//if(in.nextInt()==6 || in.nextInt()==7 || in.nextInt()==8 || in.nextInt()==9 || in.nextInt()==10 || in.nextInt()==11 || in.nextInt()==12 || in.nextInt()==13){
					System.out.println("try again");
					chosenp1=in.nextInt();
					player1.setChosen(chosenp1);
				}
				
				
				System.out.println(chosenp1);
				player1.setChosen(chosenp1);
				int numSeedsp1=holes[player1.getChosen()];
				
		
				for(int i = 1; i <= numSeedsp1; i++){
					if(player1.getChosen()+i == storep2){
						holes[player1.getChosen()+i+1]++; //TODO
						holes[player1.getChosen()]=0;
						
						if (holes[player1.getChosen()+numSeedsp1] == 0){
							holes[storep1]= holes[12-i]+holes[i];
							holes[12-i] =0;
							holes[i] =0;
						}
						
					}	
					else{
						holes[player1.getChosen()+i]+=1;
						holes[player1.getChosen()]=0;
						if (holes[player1.getChosen()+numSeedsp1] == 0){
							holes[storep1]= holes[12-i]+holes[i];
							holes[12-i] =0;
							holes[i] =0;
						}
					}
				
				
				player2.setTurn(true);
				
				for(int j = 0; j < holes.length; j++){
				System.out.println(holes[j]);
				}
				
			}
			
			//while(player2.getTurn()==true){
				
				
				
				System.out.println("Player 2's Turn.");
				System.out.print("Player 2, please select a house: ");
				
				
				player2.setChosen(in.nextInt());
				
				
				
				int numSeedsp2=holes[player2.getChosen()];
				for(int k = 1; k <= numSeedsp2; k++){
					if(player2.getChosen()+k == storep2){
						holes[player2.getChosen()+k+1]++;
						holes[player2.getChosen()]=0;
						if (holes[player2.getChosen()+numSeedsp2] == 0){
							holes[storep2]= holes[12-k]+holes[k];
							holes[12-k] =0;
							holes[k] =0;
						}
						
					}	
					else{
						holes[player2.getChosen()+k]+=1;
						holes[player2.getChosen()]=0;
						if (holes[player2.getChosen()+numSeedsp2] == 0){
							holes[storep2]= holes[12-k]+holes[k];
							holes[12-k] =0;
							holes[k] =0;
						}
					}
				}

				
				for(int l = 0; l < holes.length; l++){
					System.out.println(holes[l]);
					}
				
				
			
				
				}
			
		}
		
		
	}
		
		
	}
	
	
	



