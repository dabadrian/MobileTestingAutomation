package activity.toDo;

import appiumControl.Button;
import appiumControl.TextBox;
import org.openqa.selenium.By;


public class DeleteNoteForm {
    public Button trashButton = new Button(By.id("com.vrproductiveapps.whendo:id/deleteItem"));
    public Button acceptButton = new Button(By.id("android:id/button1"));
}
