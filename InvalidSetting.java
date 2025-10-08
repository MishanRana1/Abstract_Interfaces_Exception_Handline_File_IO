package Devices;

public class InvalidSetting extends RuntimeException {
    
    public InvalidSetting(){
        super("Invalid Exception");
    }

    public InvalidSetting(String message){
        super(message);
    }
}