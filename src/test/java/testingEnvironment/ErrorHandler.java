package testingEnvironment;

public class ErrorHandler {

    public static void warning(String errorMessage,  String testName, int errorLine,long startTestTime, long endTestTime) {
            float testTimeInSeconds = getTestTime(startTestTime, endTestTime);
            String extractedErrorMessage = extractErrorMessage(errorMessage);
            displayErrorInfo(extractedErrorMessage, errorLine, testName, testTimeInSeconds);
    }

    private static void displayErrorInfo(String error,int errorLine , String testName, float testTimeInSeconds) {
        System.out.println("############");
        System.out.println("Failed test: " + testName);
        System.out.println(error+" | line:"+errorLine);
        System.out.println("Test executed in: "+testTimeInSeconds+"s");
        System.out.println("############");
    }

    public static Float getTestTime(long startTime, long endTime) {
        long testDuration = (endTime-startTime);
        return (float)testDuration/1000;
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
