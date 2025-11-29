package cs112.ud3;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class FinalController {
    InnerController inner = new InnerController();

    private double CPS = 0;
    private double money = 0;
    private double clickCooldown = 10; //second
    private double numPerUserClick = 1;
    private double numPerAutoClick = 1;
    private double secondSinceClick = clickCooldown;

    @FXML
    private ImageView B1Image, B2Image, B3Image, B4Image, computerImage, backgroundImage;

    @FXML
    private Button up1, up2, up3, up4, bu1, bu2, bu3, bu4;

    @FXML
    private Text PointInfo;

    @FXML
    protected void GetPoint() {
        //increment points
        if (secondSinceClick >= clickCooldown) {
            System.out.println("GotPoints");
            money += numPerUserClick;
            secondSinceClick = 0;
        } //else System.out.println(clickCooldown-secondSinceClick + " seconds left");
    }

    @FXML
    protected void U1() {
        try {
            double oldcost = inner.u1.getCost();
            double result = inner.u1.purchase(money, 1.2);
            if (result > -1) { //CPS upgrade
                CPS += result;
                money -= oldcost;
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.u1.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void U2() {
        try {
            double oldcost = inner.u2.getCost();
            double result = inner.u2.purchase(money, 3); //cost *3 more
            if (result > -1) { //CPS upgrade
                numPerAutoClick += result;
                money -= oldcost;
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.u2.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void U3() {
        try {
            double oldcost = inner.u3.getCost();
            double result = inner.u3.purchase(money, 5); //cost *5 more
            if (result > -1) { //CPS upgrade
                numPerAutoClick += result;
                money -= oldcost;
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.u3.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void U4() {
        try {
            double oldcost = inner.u4.getCost();
            double result = inner.u4.purchase(money, 12); //cost *12 more
            if (result > -1) { //CPS upgrade
                clickCooldown += result;
                money -= oldcost;
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.u4.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    protected void B1() {
        try {
            double oldcost = inner.b1.getCost();
            double result = inner.b1.purchase(money, 5); //cost *20 more
            if (result > -1) { //CPS upgrade
                CPS += result;
                money -= oldcost;
                inner.b1.openImage();
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.b1.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void B2() {
        try {
            double oldcost = inner.b2.getCost();
            double result = inner.b2.purchase(money, 10); //cost *50 more
            if (result > -1) { //CPS upgrade
                numPerAutoClick += result;
                money -= oldcost;
                inner.b2.openImage();
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.b2.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void B3() {
        try {
            double oldcost = inner.b3.getCost();
            double result = inner.b3.purchase(money, 50); //cost *200 more
            if (result > -1) { //CPS upgrade
                numPerUserClick += result;
                money -= oldcost;
                inner.b3.openImage();
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.b3.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    protected void B4() {
        try {
            double oldcost = inner.b4.getCost();
            double result = inner.b4.purchase(money, 50); //cost *200 more
            if (result > -1) { //CPS upgrade
                clickCooldown += result;
                money -= oldcost;
                inner.b4.openImage();
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy " + inner.b4.getName());
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.getMessage());
        }
    }

    private class InnerController {
        Upgrade u1 = new Upgrade(5, 0.1, "Auto Clickers", "CPS +0.1"); //increment CPS by 0.1 each time
        Upgrade u2 = new Upgrade(20, 1, "Smart Clickers", "Auto click worth +1"); //increment CPS worth by 1
        Upgrade u3 = new Upgrade(100, 2, "Upgraded Comp.", "Your click worth +20"); //increment Manual click worth by 20
        Upgrade u4 = new Upgrade(500, -.05, "- Cooldown", "cooldown -0.05s"); //decrease Manual click cooldown by .05

        Building b1 = new Building(2000, 5, "Factory", "CPS +5", new Image("Factory.png")); //+5 CPS
        Building b2 = new Building(8000, 20, "Clicker School", "Auto click worth +20", new Image("School.png")); //increment CPS worth by 20
        Building b3 = new Building(20000, 500, "Gym", "Your click worth +500", new Image("Gym.png")); //increment Manual click worth by 500
        Building b4 = new Building(100000, -.5, "Time Adjuster", "decrease click cooldown by .5s", new Image("Reactor.png")); //decrease Manual click cooldown by .5

        public void oneTimeCall() {
            u1.setButton(up1);
            u2.setButton(up2);
            u3.setButton(up3);
            u4.setButton(up4);

            b1.setButton(bu1);
            b1.setRef(B1Image);
            b2.setButton(bu2);
            b2.setRef(B2Image);
            b3.setButton(bu3);
            b3.setRef(B3Image);
            b4.setButton(bu4);
            b4.setRef(B4Image);

            updateText();
        }

        public void updateText() {
            PointInfo.setText("\n" + Math.round(money*10000)/10000.0 + " > points\n" + Math.round(CPS*numPerAutoClick*10000)/10000.0 + " > points per second\n");

            for (Upgrade u : Upgrade.upgrades) if (u != null) u.getButton().setText(u.getName() + "\n#"+u.getCount()+"\n"+u.getDescription()+"\n($"+u.getCost()+")");
            for (Building u : Building.buildings) if (u != null) u.getButton().setText(u.getName() + "\n#"+u.getCount()+"\n"+u.getDescription()+"\n($"+u.getCost()+")");

        }

        public void everySecond() {
            this.updateText();
            secondSinceClick+=1;
            money += numPerAutoClick*CPS;
        }
    }

    public void everySecond() {
        inner.everySecond();
    }
    public void oneTimeCall() {
        inner.oneTimeCall();
    }

}
