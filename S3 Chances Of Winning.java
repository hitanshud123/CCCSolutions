

import java.util.*;
import java.io.*;

class Team {
  int points = 0;
  int games = 0;
  ArrayList<Integer> outcomes;

  public Team() {
    outcomes = new ArrayList<Integer>();
  } 
}
class Main {
  public static int index(ArrayList<int[]> list, int[] key) {
    for(int i = 0; i < list.size(); i++) {
      if(Arrays.equals(key, list.get(i))) {
        return i;
      }
    }
    return -1;
  } 

  public static ArrayList<int[]> getOutcomes(ArrayList<int[]> outcomes, int game, int gamesDone, ArrayList<int[]> games) {
    game++;
    ArrayList<int[]> newOutComes = new ArrayList<int[]>();
    int[] temp;
    for(int[] i : outcomes) {
      temp = i.clone();
      temp[games.get(game - gamesDone - 1)[0]-1] += 3;
      newOutComes.add(temp);
      temp = i.clone();
      temp[games.get(game - gamesDone - 1)[1]-1] += 3;
      newOutComes.add(temp);
      temp = i.clone();
      temp[games.get(game - gamesDone - 1)[0]-1] += 1;
      temp[games.get(game - gamesDone - 1)[1]-1] += 1;
      newOutComes.add(temp);
    }

    for(int[] i : newOutComes) {
      System.out.println(game + ": " + Arrays.toString(i));
    }

    if(game == 6) {
      return newOutComes;
    }
    else {
      return getOutcomes(newOutComes, game, gamesDone, games);
    }
    
  }

  public static void main(String[] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int favTeam = Integer.parseInt(in.readLine());
    int numGames = Integer.parseInt(in.readLine());

    int[][] input = new int[numGames][4];
    String[] inp = new String[4];
    for(int i = 0; i < input.length; i++) {
      inp = in.readLine().split(" ");
      for(int j = 0; j < 4; j++) {
        input[i][j] = Integer.parseInt(inp[j]);
      }
    }
    ArrayList<int[]> games = new ArrayList<int[]>(
      Arrays.asList(new int[]{1,2}, new int[]{1,3}, new int[]{1,4}, new int[]{2,3}, new int[]{2,4}, new int[]{3,4}));

    int pos;
    for(int[] i : input) {
      pos = index(games, Arrays.copyOfRange(i, 0, 2));
      games.remove(pos);
    }


    int temp1 = 0;
    int temp2 = 0;
    ArrayList<int[]> outcomes = new ArrayList<int[]>();
    outcomes.add(new int[4]);
    for(int i = 0; i < input.length; i++) {
      for(int j = 2; j < 4; j++) {
        temp1 = temp2;
        temp2 = input[i][j];
      }
      if(temp1 > temp2) {
        outcomes.get(0)[input[i][0] - 1] += 3;
      }
      else if (temp2 > temp1) {
        outcomes.get(0)[input[i][1] - 1] += 3;
      }
      else {
        outcomes.get(0)[input[i][0] - 1]++;
        outcomes.get(0)[input[i][1] - 1]++;
      }
    }
      System.out.println(Arrays.toString(outcomes.get(0)));

    ArrayList<int[]> finalOutcomes = getOutcomes(outcomes, numGames, numGames, games);
  }
}
