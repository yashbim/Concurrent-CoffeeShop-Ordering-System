// Source code available at https://github.com/yashbim/Concurrent-CoffeeShop-Ordering-System

package org.example;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello, World!");

        CoffeeShop coffeeShop = new CoffeeShop(5);
        // customer threads
        Thread[] customerThreads = new Thread[10];
        for (int i = 0; i < customerThreads.length; i++) {
            customerThreads[i] = new Thread(new Customer(coffeeShop, "Customer : " + i));
            try {
                Thread.sleep(1000); //customer arrival time difference
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
            customerThreads[i].start();
        }
    }
}