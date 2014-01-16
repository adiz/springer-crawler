package ro.cti.ssa.aossi.springer.web;

public class ControllerException extends Exception{

    private int httpStatusToRespond;
    private String[] messages;

    public ControllerException(String message, int httpStatusToRespond){
        super(message);
        messages = new String[] {message};
        this.httpStatusToRespond = httpStatusToRespond;
    }

    public ControllerException(String[] messages, int httpStatusToRespond){
        this.messages = messages;
        this.httpStatusToRespond = httpStatusToRespond;
    }

    public int getHttpStatusToRespond() {
        return httpStatusToRespond;
    }

    public String[] getMessages() {
        return messages;
    }

    public synchronized Throwable fillInStackTrace(){
        return this;
    }

}