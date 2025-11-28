package cs112.ud3;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class Upgrade implements Purchasable {
    public static ArrayList<Upgrade> upgrades = new ArrayList<>(4);
    private double cost;
    private int count = 0;
    private final double incrementer;
    private final String name;
    private final String description;
    private Button button;


    public Upgrade(double cost, double incrementer, String name, String description) {
        upgrades.add(this);
        this.cost = cost;
        this.incrementer = incrementer;
        this.name = name;
        this.description = description;
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

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Button getButton() {
        return button;
    }
    public void setButton(Button button) {
        this.button = button;
    }

}
