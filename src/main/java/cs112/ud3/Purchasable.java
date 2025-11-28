package cs112.ud3;

public interface Purchasable {
    public double getCost();
    public double purchase(double money, double costInc);
    public int getCount();
}
