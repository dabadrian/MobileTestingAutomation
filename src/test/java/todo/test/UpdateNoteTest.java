package todo.test;

import activity.toDo.CreateNoteForm;
import activity.toDo.MainScreen;
import activity.toDo.UpdateNoteForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

import java.util.Date;

public class UpdateNoteTest {

    MainScreen mainScreen = new MainScreen();
    UpdateNoteForm updateNoteForm = new UpdateNoteForm();
    CreateNoteForm createNoteForm = new CreateNoteForm();

    @Test
    public void modifyNote(){
        String title="Note title";
        String note="first line note";
        String titleUpdated = "Note title updated";
        String noteUpdated = "first line note updated";

        mainScreen.addNoteButton.click();
        createNoteForm.titleTxtBox.setText(title);
        createNoteForm.noteTxtBox.setText(note);
        createNoteForm.saveButton.click();

        mainScreen.textNote(title).click();
        updateNoteForm.titleTxtBox.setText(titleUpdated);
        updateNoteForm.noteTxtBox.setText(noteUpdated);
        updateNoteForm.saveButton.click();


        Assertions.assertTrue(mainScreen.isNoteDisplayed(titleUpdated),
                "ERROR, the note title was not modified");
        Assertions.assertTrue(mainScreen.isNoteDisplayed(noteUpdated),
                "ERROR, the note body was not modified");

    }

    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }
}
