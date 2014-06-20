import java.util.ArrayList;
import java.util.List;

public class Question3 {

    public void printReport(List<Integer> numbers) {
        for(Integer number : numbers) {
            System.out.println(report(number, numbers));
        }
    }

    private String report(Integer number, List<Integer> numbers) {
        int lessThanOrEqualsCount = 0;

        for(Integer num : numbers) {
            if(num <= number) {
                lessThanOrEqualsCount += 1;
            }
        }

        return (lessThanOrEqualsCount * 100/numbers.size()) + "% of the numbers are less than or equal to " + number;

    }

    public static void main(String args[]) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(8);
        numbers.add(6);
        numbers.add(20);
        numbers.add(9);
        numbers.add(1);
        numbers.add(12);
        numbers.add(16);
        numbers.add(3);
        numbers.add(16);
        numbers.add(22);
        numbers.add(2);

        Question3 app = new Question3();
        app.printReport(numbers);
    }

}
