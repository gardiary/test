import java.util.Arrays;

/**
 * User: gardiary
 * Date: 17/11/15, 7:29
 */
public class WaterCamp {

    public static void main(String args[]) {

        Integer a1[] = {1,1,6};
        Integer a2[] = {2,2,4};

        WaterCamp camp = new WaterCamp();
        System.out.println("Array 1 : " + Arrays.asList(a1));
        System.out.println("Array 2 : " + Arrays.asList(a2));
        System.out.println("Start at index " + camp.calculateStart(a1, a2));
    }

    public int calculateStart(Integer[] arr1, Integer[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new IllegalArgumentException("Parameters must not null and should have same size");
        }

        int arrSize = arr1.length;

        Integer[] arrData1 = doubleArray(arr1);
        Integer[] arrData2 = doubleArray(arr2);

        int startIdx = -1;

        for(int i = 0; i < arrData1.length; i++) {

            if(i < arrSize) {

                Integer[] arrOffset1 = Arrays.copyOfRange(arrData1, i, i + arrSize + 1);
                Integer[] arrOffset2 = Arrays.copyOfRange(arrData2, i, i + arrSize + 1);

                boolean result = calculate(arrOffset1, arrOffset2);

                if(result) {
                    startIdx = i;
                    break;
                }

            }

        }

        if(startIdx < 0) {
            System.out.println("No start index found, unable to deliver water");
        }

        return startIdx;
    }

    public boolean calculate(Integer[] arr1, Integer[] arr2) {
        boolean result = false;
        int balanceOfWater = 0;
        int arrSize = arr1.length;
        int successCount = 0;

        for(int i = 0; i < arrSize - 1; i++) {

            int availableWater = arr1[i];
            int nextWater = arr2[i];

            balanceOfWater += availableWater;

            if (balanceOfWater >= nextWater) {
                balanceOfWater -= nextWater;
                successCount += 1;

                if (successCount == arrSize - 1) {
                    result = true;
                    break;
                }

            }

        }

        return result;
    }

    private Integer[] doubleArray(Integer[] arr) {
        int arrSize = arr.length * 2;
        Integer[] arrDouble = new Integer[arrSize];

        for(int i = 0; i < arr.length; i++) {
            arrDouble[i] = arr[i];
            arrDouble[i + arr.length] = arr[i];
        }

        return arrDouble;
    }

}
