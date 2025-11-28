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


    Image blackBackground = new Image("black.png");
    double CPS = 0;
    double money = 0;
    double clickCooldown = 2; //second
    double numPerUserClick = 1;
    double numPerAutoClick = 1;
    double secondSinceClick = clickCooldown;

    @FXML
    private ImageView B1Image, B2Image, B3Image, B4Image, B5Image, B6Image, computerImage, backgroundImage;

    @FXML
    private Button up1, up2, up3, up4, up5, up6;

    @FXML
    private Text PointInfo;

    Upgrade u1 = new Upgrade(5, 0.1); //increment CPS by 0.1 each time


    @FXML
    protected void GetPoint() {
        //increment points
        if (secondSinceClick >= clickCooldown) {
            System.out.println("GotPoints");
            money += numPerUserClick;
            secondSinceClick = 0;
        } else System.out.println(clickCooldown-secondSinceClick + " seconds left");
    }

    @FXML
    protected void U1() {
        try {
            double oldcost = u1.getCost();
            double result = u1.purchase(money, 1.2);
            if (result > -1) { //CPS upgrade
                CPS += result;
                money -= oldcost;
            }
            else throw new InsufficientMoneyException("Insufficient funds to buy Upgrade 1");
        }
        catch (InsufficientMoneyException e) {
            System.out.println(e.toString());
        }
    }
    @FXML
    protected void U2() {
        //second upgrade
    }
    @FXML
    protected void U3() {
        //...
    }
    @FXML
    protected void U4() {
        //...
    }
    @FXML
    protected void U5() {
        //...
    }
    @FXML
    protected void U6() {
        //...
    }

    @FXML
    protected void B1() {
        //Building 1
    }
    @FXML
    protected void B2() {
        //Building 2
    }
    @FXML
    protected void B3() {
        //...
    }
    @FXML
    protected void B4() {
        //...
    }
    @FXML
    protected void B5() {
        //...
    }
    @FXML
    protected void B6() {
        //...
    }

    protected void updateText() {
        PointInfo.setText("\n" + Math.round(money*10000)/10000.0 + " > points\n" + Math.round(CPS*10000)/10000.0 + " > points per second\n");
        up1.setText("Upgrade 1\n#"+u1.getCount()+"\nCPS +0.1\n($"+u1.getCost()+")");
    }


    public void everySecond() {
        this.updateText();
        secondSinceClick+=1;
        money += numPerAutoClick*CPS;
    }
}
