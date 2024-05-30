import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int NEIGHBOUR_NUMBER = 4;
    private final int bottomRowIndex;
    private final int tableSize;
    private final int topRowIndex;
    private int openedSites;
    private boolean[] table;
    private WeightedQuickUnionUF uf;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        tableSize = n;
        uf = new WeightedQuickUnionUF(n*n + 2);
        table = new boolean[n*n + 2];
        topRowIndex = tableSize * tableSize;
        bottomRowIndex = tableSize * tableSize + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row <= 0 || row > tableSize || col <= 0 || col > tableSize) {
            throw new IllegalArgumentException();
        }

        int siteIndex = index(row, col);
        if (table[siteIndex]) return;

        table[siteIndex] = true;

        if (row == 1) { // union with top element
            uf.union(topRowIndex, siteIndex);
        }

        if (row == tableSize) {
            uf.union(bottomRowIndex, siteIndex);
        }

        int[] neighbors = getNeighbors(row, col);
        for (int neighbor : neighbors) {
            if (neighbor != -1) {
                int[] rowCol = reverseIndex(neighbor);
                if (isOpen(rowCol[0], rowCol[1])) {
                    uf.union(neighbor, siteIndex);
                }
            }
        }

        openedSites += 1;
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row <= 0 || row > tableSize || col <= 0 || col > tableSize) {
            throw new IllegalArgumentException();
        }
        return table[index(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row <= 0 || row > tableSize || col <= 0 || col > tableSize) {
            throw new IllegalArgumentException();
        }
        int siteSet = uf.find(index(row, col));
        int topSet = uf.find(topRowIndex);
        return (siteSet == topSet);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openedSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(topRowIndex) == uf.find(bottomRowIndex);
    }

    // test client (optional)
    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);

        Percolation p = new Percolation(size);
        System.out.println(p.percolates());
    }

    private int index(int row, int col) {
        return (row-1) * this.tableSize + col - 1;
        // index = (row-1) * size + col - 1
        // (index - col + 1)/size + 1 = row
    }

    private int[] reverseIndex(int index) {
        int row = index / tableSize + 1;
        int col = index % tableSize + 1;
        return new int[]{row, col};
    }

    private int[] getNeighbors(int row, int col) {
        int[] neighbors = new int[NEIGHBOUR_NUMBER];
        neighbors[0] = (row > 1) ? index(row - 1, col) : -1;  // Neighbor above
        neighbors[1] = (col < tableSize) ? index(row, col + 1) : -1;  // Neighbor to the right
        neighbors[2] = (row < tableSize) ? index(row + 1, col) : -1;  // Neighbor below
        neighbors[3] = (col > 1) ? index(row, col - 1) : -1;  // Neighbor to the left
        return neighbors;
    }
}
