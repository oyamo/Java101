import java.util.Scanner;

public class EvenOrOdd {
    public static int[] convertToIntArray(String input,int count){
        String[] inputArr = input.trim().split("\\s+");
        int[] converted = new int[count];
        int i = 0;
        for (String num: inputArr) {
            int tempInt = Integer.parseInt(num);
            if(num.equalsIgnoreCase("")) break;
            converted[i] = tempInt;
            i++;
        }
        return converted;
    }
    public static int get_even(int num){
        return num%2==0?1:0;
    }
    public static void main(String[] args) {
        int count = 0;
        int[] inputArray = null;
        String rawInputOfInts = "";
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter The number of integers:");
        count = Integer.parseInt(scanner.nextLine());
        System.out.print(String.format("Enter the %d integers seperated by a space:",count));
        rawInputOfInts = scanner.nextLine();
        inputArray = convertToIntArray(rawInputOfInts,count);
        for (int i:inputArray) {
            String msg = "%d is an %s number ";
            msg = String.format(msg, i, get_even(i) == 1 ? "even" : "odd");
            System.out.println(msg);
            sum+=i;
        }
        System.out.println(String.format("The sum is %d",sum));

    }
}
