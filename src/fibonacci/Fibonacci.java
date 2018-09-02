package fibonacci;

/**
 * 斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144,...
 */
public class Fibonacci {

    public static int fibonacciByRecursion(int month) {
        if (month < 1) {
            return 0;
        }
        if (month == 1 || month == 2) {
            return 1;
        }
        return fibonacciByRecursion(month - 1) + fibonacciByRecursion(month - 2);
    }

    public static int fibonacciByLoop(int month) {
        if (month == 1 || month == 2) {
            return 1;
        }

        int f0 = 1;
        int f1 = 1;
        int f2 = 0;

        for (int i = 2; i < month; i++) {
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    /**
     * f(n)       f(n - 1)    1     1
     * =           ^(n - 1)
     * f(n - 1)   f(n - 2)    1     0
     *
     * @param month
     * @return
     */
    public static int fibonacciByMatrix(int month) {
        if (month < 1) {
            return 0;
        }
        if (month == 1) {
            return 1;
        }
        return matrixPower(month - 1)[0][0];//matrix[0][0]即为f(n)
    }

    /**
     * 利用分治法求矩阵的幂
     * a^n = a^(n/2) * a^(n/2)              n=2k
     *     = a^((n-1)/2) * a^((n-1)/2) * a  n=2k-1
     * @param n
     * @return
     */
    public static int[][] matrixPower(int n) {
        int[][] matrix = {{1, 1}, {1, 0}};
        if (n == 1) {
            return matrix;
        } else if (n % 2 == 0) {
            matrix = matrixPower(n / 2);
            matrix = matrixMultiply(matrix, matrix);
        } else if (n % 2 == 1) {
            matrix = matrixPower((n - 1) / 2);
            matrix = matrixMultiply(matrix, matrix);
            matrix = matrixMultiply(matrix, new int[][]{{1, 1}, {1, 0}});
        }
        return matrix;

    }

    /**
     * 2 * 2矩阵乘法
     * @param matrixOne
     * @param matrixTwo
     * @return
     */
    public static int[][] matrixMultiply(int[][] matrixOne, int[][] matrixTwo) {
        int[][] matrix = {{1, 1}, {1, 0}};
        matrix[0][0] = matrixOne[0][0] * matrixTwo[0][0] + matrixOne[0][1] * matrixTwo[1][0];
        matrix[0][1] = matrixOne[0][0] * matrixTwo[0][1] + matrixOne[0][1] * matrixTwo[1][1];
        matrix[1][0] = matrixOne[1][0] * matrixTwo[0][0] + matrixOne[1][1] * matrixTwo[1][0];
        matrix[1][1] = matrixOne[1][0] * matrixTwo[0][1] + matrixOne[1][1] * matrixTwo[1][1];
        return matrix;
    }
}
