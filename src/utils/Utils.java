//import InvalidInputException;
/**
 * This class store the util funcitons
 */
public class Utils {
    public static Integer convertStringToInt(final String input) throws InvalidInputException{
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}