package org.example.bonus;


import java.io.IOException;

public class ViewCommand extends Command {
    Document document;

    public ViewCommand(Document document)
    {
        this.document=document;
    }

    @Override
    public void implementCommand() throws CustomException {
        try {
            document.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
