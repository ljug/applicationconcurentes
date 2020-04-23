
package syncwaitnotify;

/**
 *
 * @author pascal fqres
 */
public class Message {
    
    private String message;

    public Message(String message) {
        this.message = message;
    }

    
    /**
     * Get the value of message
     *
     * @return the value of message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set the value of message
     *
     * @param message new value of message
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
