import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private double[] percThresholds;
    private int t;
    private int tableSize;
    private static final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Please make sure n and trials are greater than zero.");
        }
        percThresholds = new double[trials];
        t = trials;
        tableSize = n;

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(tableSize);
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(1, tableSize + 1);
                int col = StdRandom.uniformInt(1, tableSize + 1);
                p.open(row, col);
            }
            percThresholds[i] = (double) p.numberOfOpenSites() / (tableSize * tableSize);
        }
    }
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(percThresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(percThresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONFIDENCE_95 * stddev()/ Math.sqrt(t));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (CONFIDENCE_95 * stddev()/ Math.sqrt(t));
    }

    // test client (see below)
    public static void main(String[] args) {
        int tableSize = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        PercolationStats ps = new PercolationStats(tableSize, trials);

        System.out.println("mean \t\t = " + ps.mean());
        System.out.println("stddev \t\t = " + ps.stddev());
        System.out.println("95% confidence interval \t = " + "[" + ps.confidenceLo() + ", " + ps.confidenceHi() + "]");
    }
}
