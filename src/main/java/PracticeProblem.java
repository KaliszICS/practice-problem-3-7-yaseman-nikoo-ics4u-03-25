public class PracticeProblem {

	public static void main(String args[]) {
		searchMazeMoves(new String[][]{
			{"", "", "", "", ""},
			{"", "*", "", "", ""},
			{"", "*", "", "*", ""},
			{"S", "*", "", "", "F"},
		  });
	}
	public static int searchMazeMoves(String[][] arr){
		int row=arr.length-1;
		int col=0;
		int noOfMoves=0;
		return searchMazeHelper(row, col, noOfMoves, arr);
	}
	public static int searchMazeHelper(int row, int col, int moves, String[][] arr){
		
		if(row<0||row>arr.length-1 || col>arr[row].length-1 ||col<0|| arr[row][col].equals("*")){
			return -1;
		}
		if(arr[row][col].equals("F")){
			return moves;
		}
		String copy = arr[row][col];
		arr[row][col]= "*";
		int up = searchMazeHelper(row-1, col, moves+1, arr);
		int down = searchMazeHelper(row+1, col, moves+1, arr);
		int right = searchMazeHelper(row, col+1, moves+1, arr);
		int left = searchMazeHelper(row, col-1, moves+1, arr);
		arr[row][col]=copy;
		int[] num={up, down, right, left};
		int smallest=Integer.MAX_VALUE;
		for(int i=0; i<num.length; i++){
			if(smallest>num[i]&& num[i]>=0){
				smallest =num[i];
			}
		}
		if(smallest==Integer.MAX_VALUE){
			return -1;
		}
		return smallest;
	}

}
