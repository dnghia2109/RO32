package Demo_Inclass;

public class Question1 {
	public static void main(String[] args) {
		int[] numbers= {-1,1,3,5,-5,-8};
		int maxValue =getMaxValue(numbers);
		int mimValue =getMinValue(numbers);
		System.out.println("max value:"+maxValue);
		System.out.println("mimValue:"+mimValue);
	}

	private static int getMinValue(int[] numbers) {
		int min=numbers[0];
		for(int i=1; i<numbers.length; i++) {
			if (min>numbers[i]) min=numbers[i];
		}
		// TODO Auto-generated method stub
		return min;
	}
	private static int getMaxValue(int[] numbers) {
		int max=numbers[0];
		for(int i=1; i<numbers.length; i++) {
			if (max<numbers[i]) max=numbers[i];
		}
		// TODO Auto-generated method stub
		return max;
	}
	

}
