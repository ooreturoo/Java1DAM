package ejerciciosArray;

public class Arrays2 {

	public static void main(String[] args) {
		int[] nums = {5, -1, 6 , -8, -20, 50};
		
		int negativo = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0) {
				negativo++;
			}
		}
		System.out.println(negativo);

	}

}
