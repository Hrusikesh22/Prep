package ds_n_algo.graph.problems;

/**
 * Optimized in terms of space.
 * Space - O(1)
 * Time - O(row*column)
 * @author hb670444
 *
 */
public class BiggestIsland {

	public static void main(String[] str) {

		int[][] arr = {
						{1,1,0,1,0},
						{1,0,0,0,1},
						{0,0,0,1,1},
						{1,0,1,0,1},
						{1,0,0,1,1}
					  };
		
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++ ){
				if(arr[i][j] != 2) {//If Not visited
					checkIsland(arr, i, j);
					
					System.out.println("Island : " + currIslandSize);

					maxIslandSize = Math.max(maxIslandSize, currIslandSize);
					currIslandSize = 0;//reset
				}
			}

		}

		System.out.println("Biggest Island size : " + maxIslandSize);
		System.out.println("T.C : " + noOfNodesExecuted);

	}

	static int maxIslandSize = 0;
	static int currIslandSize = 0;
	static int noOfNodesExecuted = 0;//Testing purpose: How many nodes are visited.
	
	static void checkIsland(int[][] arr, int x, int y) {

		if(x>=0 && x<=4 && y>=0 && y<=4) {//Within boundary
			
			if(arr[x][y] == 0) {
				//noOfNodesExecuted++;
				arr[x][y] = 2; //Mark Visited
				return;
			}

			if(arr[x][y] == 1) {

				//noOfNodesExecuted++;

				arr[x][y] = 2; //Mark Visited

				++currIslandSize;

				checkIsland(arr, x-1, y);//top
				checkIsland(arr, x+1, y);//Bottom
				checkIsland(arr, x, y-1);//Left
				checkIsland(arr, x, y+1);//Right
				
			} 
		}

	}

}
