
import java.util.Arrays;
import java.util.function.*;

public class Lambda {

	
	public static void main(String[] args)
	{
		
		
		
		
		
		IntFunction<Integer> square = (x) -> x*x;
		
		BiFunction<Integer,Integer,Integer> toPower = (base,power) -> {
			int returnValue = 1;
			for(int i = 1; i<= power; i++)
			{
				returnValue = returnValue * base;
			}
			return returnValue;
		};
		
		Predicate<Integer> isEven = (x) -> {
			if(x%2 == 0)
				return true;
			else
				return false;
			
		};
		
		
		IntSupplier random = () -> (int)(Math.random()*1000000);
		
		Consumer<Integer[]> printArray = (input) -> {
			System.out.println("The Values of the Array are: ");
			for(int i = 0; i< input.length; i++)
			{
				System.out.print(input[i] + " ");
			}
			System.out.println();
		};
		
		// works with matrix's of different size
		BiFunction<Integer[][], Integer[][], Integer[][]> addMatrixs = (array1, array2) -> {
			int xlength = 0;
			int ylength = 0;
			if(array1.length >= array2.length)
				xlength = array1.length;
			else
				xlength = array2.length;
			if(array1[0].length >= array2[0].length)
				ylength = array1[0].length;
			else
				ylength = array2[0].length;
			Integer[][] returnMatrix = new Integer[xlength][ylength];
			for(int i = 0; i < xlength; i++)
			{
				for(int j = 0; j< ylength; j++)
				{
					returnMatrix[i][j] = 0;
					if(array1.length > i && array1[0].length > j)
						returnMatrix[i][j] = returnMatrix[i][j] + array1[i][j];
					if(array2.length > i && array2[0].length > j)
						returnMatrix[i][j] = returnMatrix[i][j] + array2[i][j];
				}
				
			}	
			return returnMatrix;
		};
		
		LongFunction factorial = (value) -> {
			long returnValue = 1;
			for(long i = value; i>1; i--)
			{
				returnValue = returnValue * i;
			}
			return returnValue;
		};
		
		BiPredicate<String,String> isSubstring = (subString, string) -> {
			for(int i = 0; i < string.length() - subString.length()+1; i++)
			{
				if(subString.equals(string.substring(i, i+subString.length())))
				{
					return true;
				}	
			}
			return false;
		};
		
		
		
		
		Integer[][] first = new Integer[][] {{3,2,3},{5,4,5}};
		Integer[][] second = new Integer[][] {{2,1},{5,4},{7,9}};
		
		Integer[] QuestionFiveTest = new Integer[] {0,22,5,37};
		System.out.println("The Square of 5 is " + square.apply(5));
		System.out.println("The 5th power of 5 is " + toPower.apply(5, 5));
		System.out.println("is 3 even: " + isEven.test(3));
		System.out.println("A random number: " + random.getAsInt());
		printArray.accept(QuestionFiveTest);
		System.out.println("Adding matrices of {3,2,3;5,4,5} and {2,1;5,4;7,9}: " + Arrays.deepToString(addMatrixs.apply(first,second)));
		System.out.println("The Factorial of 7 is: " + factorial.apply(7));
		System.out.println("Is 'ogo' a substring of 'bonogo': " + isSubstring.test("ogo", "bonogo"));
		
		
		
	}
}
