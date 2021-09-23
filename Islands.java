package Assignment_2;

public class Islands {

	public static void main(String args[]) {
		int map[][] = new int[5][5];
		
		int maxValue = 100;
		int dropChance = 25;
		randomIslands(map, maxValue, dropChance);
		printIslands(map);
		System.out.println("There is an island with a value of " + maxValueIsland(map));
	}
	
	/**********Student Code Here**************************/
	
	public static int maxValueIsland(int map[][]) {
		//boolean visitedLand[][] = new boolean[map.length][map[0].length]; 
		int maxValue = 0;
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				if(map[r][c] != 0) {
					int value = getIslandValue(map, r, c);
					if(value > maxValue) {
						maxValue = value;
					}
				}
			}
		}
		return maxValue;
	}
	
	
	private static int getIslandValue(int map[][], int row, int col) {
		boolean visitedLand[][] = new boolean[map.length][map[0].length]; 
		return findIslandValue(map, visitedLand, row, col);

	}
	
	public static int findIslandValue(int map[][], boolean visitedLand[][], int row, int col) {
		int currentIsland = 0;
		
		if(map[row][col] == 0) {
			return 0;
		} else {
			visitedLand[row][col] = true;
			currentIsland += map[row][col];
			
			if (col + 1 < map[0].length && visitedLand[row][col+1] == false) {
				currentIsland += findIslandValue(map, visitedLand, row, col +1);
			}
			if (row + 1 < map.length && visitedLand[row+1][col] == false) {
				currentIsland += findIslandValue(map, visitedLand, row+1, col);
			}
			if (col - 1 > 0 && visitedLand[row][col-1] == false) {
				currentIsland += findIslandValue(map, visitedLand, row, col-1);
			}
			if (row - 1 > 0 && visitedLand[row-1][col] == false) {
				currentIsland += findIslandValue(map, visitedLand, row-1, col);
			}
		}
		
		return currentIsland;
	}
	
	/******************************************************************/
	
	public static void randomIslands(int map[][], int maxPossibleValue, int chance) {
		if(maxPossibleValue <= 0) {
			throw new IllegalArgumentException("The max possible value must be a positive integer.");
		}
		if(chance > 100 || chance < 0) {
			throw new IllegalArgumentException("The chance of money drop must be between 0 <= p <= 100");
		}
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				int possible = (int) (Math.random() * 100) + 1;
				if(possible <= chance) {
					map[r][c] = (int)(Math.random() * maxPossibleValue) + 1;
				}
			}
		}
	}
	
	public static void printIslands(int island[][]) {
		int maxDigits = getMaxDigits(island);
		for(int r = 0; r < island.length; r++) {
			for(int c = 0; c < island[r].length; c++) {
				int value = island[r][c];
				String s = "%"+maxDigits+"d";
				if(value != 0) {
					System.out.print(" |");
					System.out.printf(s, value);
					System.out.print("| ");
				} else {
					System.out.print("  ");
					System.out.printf("%"+maxDigits+"s", "-");
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
	}

	private static int getMaxDigits(int[][] arr) {
		int maxDigitSize = 0;
		for(int r = 0; r < arr.length; r++) {
			for(int c = 0; c < arr[r].length; c++) {
				int value = arr[r][c];
				int digits = 0;
				while(value != 0) {
					digits += 1;
					value /= 10;
				}
				if(digits > maxDigitSize) {
					maxDigitSize = digits;
				}
			}
		}
		return maxDigitSize;
	}
	
	
}
