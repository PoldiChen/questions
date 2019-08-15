package question014;

/**
 * @author poldi.chen
 * @className Maze
 * @description TODO
 * @date 2019/7/11 16:45
 **/
public class Maze {

    private int[][] maze = {
            {0,0,1,1,1,1,1,1,1,1}, //0
            {1,0,0,1,1,0,0,1,0,1}, //1
            {1,0,0,1,0,0,0,1,0,1}, //2
            {1,0,0,0,0,1,1,0,0,1}, //3
            {1,0,1,1,1,0,0,0,0,1}, //4
            {1,0,0,0,1,0,0,0,0,1}, //5
            {1,0,1,0,0,0,1,0,0,1}, //6
            {1,0,1,1,1,0,1,1,0,1}, //7
            {1,1,0,0,0,0,0,0,0,0}, //8
            {1,1,1,1,1,1,1,1,1,0}
    };
    private Node exit = new Node(9,9);


    public void mazeTrace(int x, int y) {
        //
    }
}

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
