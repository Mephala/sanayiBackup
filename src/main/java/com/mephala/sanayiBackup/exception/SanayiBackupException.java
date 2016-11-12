package com.mephala.sanayiBackup.exception;

/**
 * Created by Mephalay on 11/12/2016.
 */
public class SanayiBackupException extends Exception {

    private Throwable innerCause;

    private String promptMessage;

    public SanayiBackupException(String msg, Throwable innerCause) {
        super(msg);
        this.innerCause = innerCause;
    }


    public Throwable getInnerCause() {
        return innerCause;
    }

    public void setInnerCause(Throwable innerCause) {
        this.innerCause = innerCause;
    }

    public String getPromptMessage() {
        return promptMessage;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }
}
