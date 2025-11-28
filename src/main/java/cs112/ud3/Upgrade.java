package cs112.ud3;

import java.util.ArrayList;

public class Upgrade implements Purchasable {
    public static ArrayList<Upgrade> upgrades = new ArrayList<>(6);
    private double cost;
    private int count = 0;
    private final double incrementer;


    public Upgrade(double cost, double incrementer) {
        upgrades.add(this);
        this.cost = cost;
        this.incrementer = incrementer;
    }

    @Override
    public double getCost() {
        return Math.round(cost*100)/100.00;
    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public double purchase(double money, double costInc) {
        if (money >= this.getCost()) {
            cost*=costInc;
            count += 1;
            return incrementer;
        }
        return -1;
    };

}
