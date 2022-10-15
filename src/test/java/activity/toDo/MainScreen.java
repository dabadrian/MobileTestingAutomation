package activity.toDo;

import appiumControl.Button;
import appiumControl.Label;
import appiumControl.TextBox;
import org.openqa.selenium.By;

public class MainScreen {
    public Button addNoteButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));

    public MainScreen(){}
    public boolean isNoteDisplayed(String title){
        Label note= new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        return note.isControlDisplayed();
    }

    public Label textNote(String title){
        Label text= new Label(By.xpath("//android.widget.TextView[@text='"+title+"']"));
        return  text;
    }


}
