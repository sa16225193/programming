package fibonacci;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        testFibonacci();
    }

    public static void testFibonacci() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入月数：");
        int month = scanner.nextInt();
        System.out.println(month + "个月后，兔子的总对数为：" + Fibonacci.fibonacciByRecursion(month));
//        System.out.println(month + "个月后，兔子的总对数为：" + Fibonacci.fibonacciByLoop(month));
//        System.out.println(month + "个月后，兔子的总对数为：" + Fibonacci.fibonacciByMatrix(month));
    }
}
