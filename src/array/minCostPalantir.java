package array;

import java.io.*;

public class minCostPalantir {


	/**
	 * This method takes the initial position of each employee and calculates
	 *  min cost to reach the destination.
	 * @param cost : The complete cost grid.
	 * @param m : starting row
	 * @param n : starting col
	 * @return the minimum cost
	 */
	public static int minCost(int[][] cost, int m, int n) {
		int i, j;

		int totalCostRows = cost.length;
		int totalCostCols = cost[0].length;
		int totalCost[][] = new int[totalCostRows][totalCostCols];

		totalCost[m][n] = cost[m][n];

		for (i = m+1; i < totalCostRows; i++)
			totalCost[i][n] = totalCost[i - 1][n] + cost[i][n];

		for (j = n+1; j < totalCostCols; j++)
			totalCost[m][j] = totalCost[m][j - 1] + cost[m][j];

		for (i = m+1; i < totalCostRows; i++)
			for (j = n+1; j < totalCostCols; j++)
				totalCost[i][j] = Math.min(totalCost[i - 1][j],
						totalCost[i][j - 1]) + cost[i][j];

		return totalCost[totalCostRows - 1][totalCostCols - 1];
	}

	public static void main(String args[]) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String[] mn = reader.readLine().split("\\s");
		int m = Integer.parseInt(mn[0]);
		int n = Integer.parseInt(mn[1]);
		int mnGrid[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			String[] row = reader.readLine().split("\\s");
			for (int j = 0; j < row.length; j++) {
				mnGrid[i][j] = Integer.parseInt(row[j]);
			}
		}

		int numberOfEmployees = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numberOfEmployees; i++) {
			String[] startPosition = reader.readLine().split("\\s");
			int startRow = Integer.parseInt(startPosition[0]);
			int startCol = Integer.parseInt(startPosition[1]);
			int result = minCost(mnGrid, startRow, startCol);
			System.out.println(result);

		}

		System.out.println();

	}
}