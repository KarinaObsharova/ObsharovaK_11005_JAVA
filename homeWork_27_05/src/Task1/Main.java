package Task1;

import java.util.Scanner;

public class Main {
    public static volatile long factorial = 1l;
    public static int n;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        if (n > 20 || n < 0){
            System.out.println("Incorrect number");
            System.exit(0);
        }
        if (n <= 5) {
            MyThread0 myThread = new MyThread0();
            myThread.start();
            myThread.join();
        } else if (n <= 10) {
            MyThread0 myThread = new MyThread0();
            myThread.start();
            myThread.join();
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            myThread1.join();
        } else if (n <= 15) {
            MyThread0 myThread = new MyThread0();
            myThread.start();
            myThread.join();
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            myThread1.join();
            MyThread2 myThread2 = new MyThread2();
            myThread2.start();
            myThread2.join();
        } else {
            MyThread0 myThread = new MyThread0();
            myThread.start();
            myThread.join();
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            myThread1.join();
            MyThread2 myThread2 = new MyThread2();
            myThread2.start();
            myThread2.join();
            MyThread3 myThread3 = new MyThread3();
            myThread3.start();
            myThread3.join();
        }
        System.out.println(factorial);
    }

    static class MyThread0 extends Thread {
        @Override
        public void run() {
            if (n > 5) {
                for (int i = 1; i <= 5; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            } else {
                for (int i = 1; i <= n; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            }
            try {
                MyThread0.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread1 extends Thread {
        @Override
        public void run() {
            if (n > 10) {
                for (int i = 6; i <= 10; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            } else {
                for (int i = 6; i <= n; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            }
            try {
                MyThread1.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread2 extends Thread {
        @Override
        public void run() {
            if (n > 15) {
                for (int i = 11; i <= 15; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            } else {
                for (int i = 11; i <= n; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            }
            try {
                MyThread1.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class MyThread3 extends Thread {
        @Override
        public void run() {
            if (n == 20) {
                for (int i = 16; i <= 20; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            } else {
                for (int i = 16; i <= n; i++) {
                    factorial = factorial * i;
                    System.out.println("Factorial of " + i + " = " + factorial);
                }
            }
            try {
                MyThread1.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
