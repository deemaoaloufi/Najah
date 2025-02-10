
package najah1;

/**
 * Custom Exception class for Information errors extends the Exception class
 */
public class InfoException extends Exception {

    /**
     * Constructor for the InfoException class
     * Creates a new InfoException object with the given error message
     * @param error A String representing the error message
     */
     public InfoException(String error) {
         
         super(error);
    }
}