import java.util.*;

public class Main {
    public static void getReachablePages(Node node, ArrayList<Integer> reachPages) {

        if(!reachPages.contains(node.pageNum)) {
            reachPages.add(node.pageNum);
            for(Node i : node.children) {
                getReachablePages(i, reachPages);
            }
        }

    }

    public static int getShortestPath(ArrayList<Node> nodesToCheck, int level) {
        level++;
        ArrayList<Node> childNodes = new ArrayList<Node>();
        for(Node node : nodesToCheck) {
            if(node.children.length == 0) {
                return level;
            }
            else {
                for (Node child : node.children) {
                    childNodes.add(child);
                }
            }
        }
        return getShortestPath(childNodes, level);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Node[] pages;
        int numPages;
        int options;

        numPages = scan.nextInt();
        pages = new Node[numPages];

        for (int i = 0; i < numPages; i++) {
            pages[i] = new Node(i+1);
        }

        int inp;
        for (int i = 0; i < numPages; i++) {
            options = scan.nextInt();
            pages[i].children = new Node[options];
            for (int j = 0; j < options; j++) {
                inp = scan.nextInt();
                pages[i].children[j] = pages[inp-1];
            }
        }


        ArrayList<Integer> reachablePages = new ArrayList<Integer>();
        getReachablePages(pages[0], reachablePages);

        if (reachablePages.size() == numPages) {
            System.out.println("Y");
        }
        else {
            System.out.println("N");
        }

        ArrayList<Node> nodesToCheck = new ArrayList<Node>();
        nodesToCheck.add(pages[0]);
        int shortestPath = getShortestPath(nodesToCheck, 0);
        System.out.println(shortestPath);
    }
}

class Node {
    public int pageNum;
    public Node[] children;

    public Node(int num) {
        pageNum = num;
    }
}
