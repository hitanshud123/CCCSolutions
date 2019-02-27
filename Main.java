import java.util.*;

public class Main {
    public static ArrayList<Integer> calc(int[] lens, int sum) {
        ArrayList<Integer> sums = new ArrayList<Integer>();
        ArrayList<Integer> is = new ArrayList<Integer>();
        int currentSum;
        for(int i = 0; i < lens.length -1; i++) {


            for(int j = i+1; j < lens.length; j++) {
                System.out.println("is: " + is);
                System.out.println(i +  " + " + j);
                currentSum = lens[i] + lens[j];
                if(currentSum == sum) {
                    is.add(i);
                    is.add(j);
                    sums.add(currentSum);
                }
                while(is.contains(j)) {
                    j++;
                }
                while (is.contains(i)){
                    i++;
                }
            }

        }
        return sums;
    }
    public static void main(String[]args) {
        int numWood;
        int[] lens;

        Scanner scan = new Scanner(System.in);

        numWood = scan.nextInt();

        lens = new int[numWood];
        for(int i = 0; i < numWood; i++) {
            lens[i] = scan.nextInt();
        }

        ArrayList<Integer> sums = new ArrayList<Integer>();
        ArrayList<Integer> sums2 = new ArrayList<Integer>();
        int currentSum;
        int len;
        int maxLen = 0;
        int numPoss = 0;
        int[] lens2 = new int[numWood - 2];
        for(int i = 0; i < numWood -1; i++) {
            for(int j = i + 1; j < numWood; j++) {
                len = 1;
                currentSum = lens[i] + lens[j];
                if (!sums.contains(currentSum)) {
                    sums.add(currentSum);
                    int index = 0;
                    System.out.println("ij: " + i + " " +j);
                    for(int k = 0; k < numWood; k++) {
                        if(k != i && k != j) {
                            System.out.println(index + " = " + lens[k]);
                            lens2[index] = lens[k];
                            index++;
                        }
                    }

                    System.out.println(Arrays.toString(lens) + Arrays.toString(lens2));
                    sums2 = calc(lens2, currentSum);
                    System.out.println(currentSum);
                    System.out.println(sums2);
                    for(int l : sums2) {
                        if(l == currentSum) {
                            len++;
                        }
                    }

                    if(len > maxLen){
                        maxLen = len;
                        numPoss = 0;
                    }
                    if(len == maxLen) {
                        numPoss++;
                    }
                }


            }
        }
        System.out.println(maxLen + " " + numPoss);
    }
}
