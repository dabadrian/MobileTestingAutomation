package todo.test;

import activity.toDo.CreateNoteForm;
import activity.toDo.DeleteNoteForm;
import activity.toDo.MainScreen;
import activity.toDo.UpdateNoteForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import singletonSession.Session;

public class DeleteNoteTest {

    MainScreen mainScreen = new MainScreen();
    UpdateNoteForm updateNoteForm = new UpdateNoteForm();
    CreateNoteForm createNoteForm = new CreateNoteForm();

    DeleteNoteForm deleteNoteForm = new DeleteNoteForm();


    @Test
    public void deleteNote(){
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

        mainScreen.textNote(titleUpdated).click();
        deleteNoteForm.trashButton.click();
        deleteNoteForm.acceptButton.click();

        Assertions.assertFalse(mainScreen.isNoteDisplayed(titleUpdated),
                "ERROR, the note was not deleted");
    }

    @AfterEach
    public void closeApp(){
        Session.getInstance().closeApp();
    }
}
