import java.util.Scanner;

public class Ques1 {
	public static void main(String args[]) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String wall[][] = new String[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				wall[i][j] = scn.next();
			}
		}
		int res = findMaxWall(wall);
		System.out.println(res);
		scn.close();
	}
	public static void display(String[][] wall) {
		for(int i=0;i<wall.length;i++) {
			for(int j=0;j<wall[i].length;j++) {
				System.out.print(wall[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int findMaxWall(String[][] wall) {
		//after rotation and after heating
		String wall2[][] = rotate(wall);
		heat(wall2);
//		display(wall2);
		int res1 = checkMaxWall(wall2);
		
		// System.out.println();	
		
		//before rotation and after heating	
		heat(wall);
//		display(wall);
		int res2 = checkMaxWall(wall);
		return Math.max(res1, res2);
	}
	public static void heat(String wall[][]) {
		for(int i=0;i<wall.length;i++) {
			for(int j=0;j<wall[i].length;j++) {
				if(wall[i][j].equals("D")) {
					wall[i][j] = "_";
				}
			}
		}
		for(int i=0;i<wall.length;i++) {
			for(int j=0;j<wall[i].length;j++) {
				if(wall[i][j].equals("C")) {
					int row = wall.length-1;
					while(row>=i+1) {
						if(wall[row][j].equals("_")) {
							String temp = wall[row-1][j];
							wall[row-1][j] = wall[row][j];
							wall[row][j] = temp;
						}
						row--;
					}					
				}
			}
		}
	}
	public static int checkMaxWall(String[][] wall) {
		int ccount = 1;
		int rcount = 0;
		int mxCount = Integer.MIN_VALUE;
		boolean flag = false;
		for(int i=0;i<wall.length;i++) {
			for(int j=0;j<wall[i].length-1;j++) {
				if(wall[i][j].equals("_")) {
					flag = true;
					break;
				}
			}
		}
		if(flag == false) {
			return 0;
		}
		for(int i=0;i<wall.length;i++) {
			ccount = 1;
			rcount++;
			for(int j=0;j<wall[i].length-1;j++) {
				if(wall[i][j].equals("_")&& wall[i][j+1].equals("_")) {
					ccount++;
				}
				else {
					if(rcount == ccount) {
						mxCount = Math.max(mxCount, rcount);
					}
					ccount = 1;
				}			
			}			
			if(rcount == ccount) {
				mxCount = Math.max(mxCount, rcount);
			}
		}
		return mxCount;
	}
	public static String[][] rotate(String wall[][]){
		
		String wall2[][] = new String[wall[0].length][wall.length];
		
		for(int i=0;i<wall.length;i++) {			
			for(int j=wall[0].length-1;j>=0;j--) {
				wall2[(wall[0].length-1)-j][i] = wall[i][j];
			}
		}
		return wall2;
	}
}
