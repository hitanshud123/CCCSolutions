import java.util.*;
import java.io.*;
class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String[] command = new String[2];
    int[][] map = new int[201][401];

    map[0][200] = 1;
    map[1][200] = 1;
    map[2][200] = 1;
    map[2][201] = 1;
    map[2][202] = 1;
    map[2][203] = 1;
    map[3][203] = 1;
    map[4][203] = 1;
    map[4][204] = 1;
    map[4][205] = 1;
    map[3][205] = 1;
    map[2][205] = 1;
    map[2][206] = 1;
    map[2][207] = 1;
    map[3][207] = 1;
    map[4][207] = 1;
    map[5][207] = 1;
    map[6][207] = 1;
    map[6][206] = 1;
    map[6][205] = 1;
    map[6][204] = 1;
    map[6][203] = 1;
    map[6][202] = 1;
    map[6][201] = 1;
    map[6][200] = 1;
    map[6][199] = 1;
    map[5][199] = 1;
    map[4][199] = 1;
    
    boolean exit = false;
    int row = 4;
    int col = 199;
    String out = "safe";
    while(!exit) {
      command = in.readLine().split(" ");
      if(command[0].equals("q")) {
        exit = true;
      }
      else {
        if(command[0].equals("d")) {
          for(int i = 0; i < Integer.parseInt(command[1]); i++) {
            row++;
            if(map[row][col] == 1) {
              exit = true;
              out = "DANGER";
            }
            else {
              map[row][col] = 1;
            }
          }
        } 
        else if(command[0].equals("u")) {
          for(int i = 0; i < Integer.parseInt(command[1]); i++) {
            row--;
            if(map[row][col] == 1) {
              exit = true;
              out = "DANGER";
            }
            else {
              map[row][col] = 1;
            }
          }
        }
        else if(command[0].equals("l")) {
          for(int i = 0; i < Integer.parseInt(command[1]); i++) {
            col--;
            if(map[row][col] == 1) {
              exit = true;
              out = "DANGER";
            }
            else {
              map[row][col] = 1;
            }
          }
        }
        else {
          for(int i = 0; i < Integer.parseInt(command[1]); i++) {
            col++;
            if(map[row][col] == 1) {
              exit = true;
              out = "DANGER";
            }
            else {
              map[row][col] = 1;
            }
          }
        }
            System.out.println((col-200) + " " + (-1 * (row +1)) + " " + out);

      }
    }
  }
}
