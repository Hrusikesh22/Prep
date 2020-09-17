package array;

public class RainWaterTrapping {

	public static void main(String[] args) {
		int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println("\nTrapped Rain water unit - " + getTrappedRainWater(arr));

	}
	
	public static int getTrappedRainWater(int[] arr){
		
		if(arr == null || arr.length ==0)//IMP
            return 0;
		
        int[] leftMax = new int[arr.length];
        int[] rightMax = new int[arr.length];

        leftMax[0] = arr[0];
        for(int i=1; i<arr.length; i++)
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);

        rightMax[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--)
        	rightMax[i] = Math.max(rightMax[i+1], arr[i]);
        
        System.out.print("Left-Max : ");
        for(int i = 0; i<arr.length; i++)
            System.out.print(leftMax[i] + " ");

        System.out.print("\nRight-Max : ");
        for(int i = 0; i<arr.length; i++)
            System.out.print(rightMax[i] + " ");

        int rainWater = 0;
        for(int i = 0; i<arr.length; i++)
            rainWater += Math.min(leftMax[i], rightMax[i]) - arr[i];

        return rainWater;
    }
}


