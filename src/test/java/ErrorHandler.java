

public class ErrorHandler {

    public static void warning(String errorMessage, String testName, Long testTime) {
            float testTimeInSeconds = getTestTime(testTime);
            String extractedErrorMessage = extractErrorMessage(errorMessage);
            displayErrorInfo(extractedErrorMessage, testName, testTimeInSeconds);
    }

    private static void displayErrorInfo(String error, String testName, float testTimeInSeconds) {
        System.out.println("############");
        System.out.println("Failed test: " + testName);
        System.out.println(error);
        System.out.println("Test executed in: "+testTimeInSeconds+"s");
        System.out.println("############");
    }

    public static Float getTestTime(Long startTime) {
        long testDuration = (System.currentTimeMillis()-startTime);
        return (float)testDuration/100;
    }
    private static String extractErrorMessage(String fullErrorMessage) {
        int endIndex = fullErrorMessage.indexOf("\n");
        if (endIndex >= 0) {
            return fullErrorMessage.substring(0, endIndex);
        } else {
            return fullErrorMessage;
        }
    }
}
