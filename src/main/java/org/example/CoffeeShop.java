package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private Queue<String> orderQueue;
    private int Capacity;

    public CoffeeShop(int Capacity) {
        this.orderQueue = new LinkedList<>();
        this.Capacity = Capacity;
    }

    public synchronized void addOrder(String order) {
        while (orderQueue.size() >= Capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
        orderQueue.add(order);
        notifyAll();
        System.out.println("Order added: " + order + "\nRemaining orders: " + orderQueue.size() + "\nMaximal orders: " + Capacity);
    }

    public synchronized String makeOrder() {
        while (orderQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
                return null;
            }
        }
        String order = orderQueue.remove();
        notifyAll();
        return order;
    }

    public synchronized int getRemainingOrders(){
        return orderQueue.size();
    }
}
