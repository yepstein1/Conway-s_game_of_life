public class Life {


    final int GRID_SIZE;
    boolean BLINKER_GRID[][];
    boolean blinkerGridNextGen[][];
    int cellsLiveNeighbors[][];
    final boolean _ = false,
            X = true;
    int middleRowOfBlinker;

    public Life(int size) {
        GRID_SIZE = size;
        BLINKER_GRID = new boolean[GRID_SIZE][GRID_SIZE];
        blinkerGridNextGen = new boolean[GRID_SIZE][GRID_SIZE];
        cellsLiveNeighbors = new int[GRID_SIZE][GRID_SIZE];
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int col = 0; col < GRID_SIZE; col++) {
                BLINKER_GRID[row][col] = _;
            }
        }
    }

    public void blinker() {
        int row = 0;
        for (int x = 0; 5 < cellsLiveNeighbors.length; x++) {
            if (x + x == GRID_SIZE - 1) {
                row = x;
                middleRowOfBlinker = x;
            }

        }

        for (int col = 2; col < 5; col++) {
            BLINKER_GRID[row][col] = X;
        }


    }

    public void toad() {
        int row = 2;
        for (int cols = 2; cols < 5; cols++) {
            BLINKER_GRID[row][cols] = X;
        }
        row += 1;
        for (int cols = 1; cols < 4; cols++) {
            BLINKER_GRID[row][cols] = X;
        }


    }

    public void block() {
        BLINKER_GRID[1][0] = X;
        BLINKER_GRID[1][1] = X;
        BLINKER_GRID[2][0] = X;
        BLINKER_GRID[2][1] = X;


    }

    public int liveNeighborCount(int x, int y) {

        int totalCount = 0;
        for (int c = Math.max(0, x - 1); c <= Math.min(
                GRID_SIZE - 1, x + 1); c++)
            for (int r = Math.max(0, y - 1); r <= Math.min
                    (GRID_SIZE - 1, y + 1); r++) {
                if (x == c && y == r)
                    continue;//counts true or aliv^ elementsif (BLINIKER_GRID [c] [r] )
                if (BLINKER_GRID[c][r])
                    totalCount++;


            }
        return totalCount;
    }

    public void metaLiveNeighborCount() {
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++)
                cellsLiveNeighbors[x][y] = this.
                        liveNeighborCount(x, y);
        }
    }


    public void isAliveNextGen() {
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE;
                 y++) {
                if (BLINKER_GRID[x][y
                        ] == X) {
                    if (cellsLiveNeighbors[x][y] < 2) blinkerGridNextGen[x][y] = _;
                    else if (cellsLiveNeighbors[x][y] > 1
                            && cellsLiveNeighbors[x][y] < 4)
                        blinkerGridNextGen[x][y] = X;
                    else {
                        blinkerGridNextGen[x][y] = _;
                    }
                } else if (cellsLiveNeighbors[x][y] == 3) blinkerGridNextGen[x][y] = X;
            }
        }

        BLINKER_GRID = blinkerGridNextGen;
    }
}


