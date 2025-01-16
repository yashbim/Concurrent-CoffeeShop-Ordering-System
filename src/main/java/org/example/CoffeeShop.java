package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeShop {

    private Queue<String> coffeeOrders;
    private int maxOrders;

    public CoffeeShop(int maxOrders) {
        this.coffeeOrders = new LinkedList<>();
        this.maxOrders = maxOrders;
    }
}
