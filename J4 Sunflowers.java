import java.util.*;
class Main {
  public static void rotate(int[][] table) {
    int[] convertArr = new int[table.length * table[0].length];
    int index;

    index = 0;
    for(int i = 0; i < table[0].length; i++) {
      for(int j = table.length - 1; j >= 0; j--) {
        convertArr[index] = table[j][i];
        index++;
      }
    }
    
    index = 0;
    for(int i = 0; i < table.length; i++) {
      for(int j = 0; j < table[i].length; j++) {
        table[i][j] = convertArr[index];
        index++;
      }
    }    
  }

  public static boolean check(int[][] table) {
    boolean valid = true;
    int min;

    for(int i = 0; i < table.length && valid; i++) {
      min = table[i][0];
      for(int j = 0; j < table[i].length && valid; j++) {
        if(table[i][j] < min) {
          valid = false;
        }
      }
    }

    for(int i = 0; i < table[0].length && valid; i++) {
      min = table[0][i];
      for(int j = 0; j < table.length && valid; j++) {
        if(table[j][i] < min) {
          valid = false;
        }
      }
    }

    return valid;
  }

  public static void main(String[] args) {
    Scanner scanInt = new Scanner(System.in);
    int numPlants;
    boolean valid = false;

    System.out.println("Input:");
    numPlants = scanInt.nextInt();
    int[][] table = new int[numPlants][numPlants];
    for(int i = 0; i < numPlants; i++) {
      for(int j = 0; j < numPlants; j++) {
        table[i][j] = scanInt.nextInt();
      }
    }

    
    System.out.println("\n");
    for(int i = 0; i < 4 && !valid; i++) {
      rotate(table);
      valid = check(table);
      if (valid) {
        for(int j = 0; j < table.length; j++) {
          for(int k = 0; k < table[j].length; k++) {
            System.out.print(table[j][k] + " ");
          }
          System.out.println();
        }
      }
    }


  }
}
