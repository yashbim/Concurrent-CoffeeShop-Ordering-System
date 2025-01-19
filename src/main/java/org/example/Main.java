// Source code available at https://github.com/yashbim/Concurrent-CoffeeShop-Ordering-System

package org.example;

public class Main {
    public static void main(String[] args) {

        CoffeeShop coffeeShop = new CoffeeShop(5);
        // customer threads
        Thread[] customerThreads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            customerThreads[i] = new Thread(new Customer(coffeeShop, "Customer : " + i));
            try {
                Thread.sleep(1000); //customer arrival time difference
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
            customerThreads[i].start();
        }

        //barista threads
        Thread[] baristaThreads = new Thread[2];
        for (int i = 0; i < 2; i++) {
            baristaThreads[i] = new Thread(new Barista(coffeeShop, "Barista : " + i));
            baristaThreads[i].start();
        }

        //wait for customer threads
        for (Thread customerThread : customerThreads) {
            try {
                customerThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }

        //wait for barista
        for (Thread baristaThread : baristaThreads) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }

        //stop barista threads to end

        for (Thread baristaThread : baristaThreads) {
            baristaThread.interrupt();
        }

        System.out.println("Orders completed");
    }
}