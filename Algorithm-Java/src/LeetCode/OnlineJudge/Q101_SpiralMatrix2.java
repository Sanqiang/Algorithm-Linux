/**
 * Sanqiang Zhao Www.131X.Com Dec 25, 2012
 */
package LeetCode.OnlineJudge;

import java.io.FileWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Q101_SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int i, col, row, edge = n - 1, num = 1;
        for (i = 0; i <= edge / 2; i++) {
            for (row = i; row <= edge - i; ++row) {
                matrix[i][row] = num++;
            }
            for (col = i + 1; col <= edge - i; ++col) {
                matrix[col][edge - i] = num++;
            }
            if (edge - 2 * i >= 0) {
                for (row = edge - i - 1; row >= i; --row) {
                    matrix[edge - i][row] = num++;
                }
                for (col = edge - i - 1; col > i; --col) {
                    matrix[col][i] = num++;
                }
            }
        }
        return matrix;

    }

    public static void main(String[] args) {
        int n = 100;
        int matrix[][] = new Q101_SpiralMatrix2().generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        //File
        try {
            FileWriter fw = new FileWriter("SpiralMatrix.html");
            fw.write("<table>");
            for (int i = 0; i < n; i++) {
                fw.write("<tr>");
                for (int j = 0; j < n; j++) {
                    fw.write("<td>"+matrix[i][j]+"</td>");
                }
                fw.write("</tr>");
            }
            fw.write("</table>");
            fw.close();
        } catch (Exception ex) {
            Logger.getLogger(Q101_SpiralMatrix2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
