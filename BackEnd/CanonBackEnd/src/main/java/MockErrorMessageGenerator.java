import codecrusaders.domain.nestedstructure.ErrorMessage;
import codecrusaders.domain.nestedstructure.TestStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockErrorMessageGenerator {

    public static List<TestStep> assignErrorMessages(List<TestStep> testSteps, List<ErrorMessage> messages){
        Random random = new Random();
        List<TestStep> errorMessagesWithAssignedTestStep = new ArrayList<>();
        for(int i = 0; i < testSteps.size(); i++){
            boolean assignError = random.nextBoolean();
            if(assignError == true){
                ErrorMessage errorMessage = messages.get(random.nextInt(messages.size()));
                testSteps.get(i).setMessage(errorMessage);
                errorMessagesWithAssignedTestStep.add(testSteps.get(i));
            }
            else{
                testSteps.get(i).setMessage(null);
                errorMessagesWithAssignedTestStep.add(testSteps.get(i));
            }
        }
        return errorMessagesWithAssignedTestStep;
    }

    public static List<ErrorMessage> generateErrorMessages() {
        List<ErrorMessage> errorMessages = new ArrayList<>();
        String[] keywords = {
                "Ink Cartridge Failure",
                "Paper Jam Detected",
                "Image Alignment Error",
                "Color Calibration Failed",
                "Print Head Misalignment",
                "Maintenance Kit Error",
                "Media Loading Error",
                "Communication Error",
                "Duplex Printing Problem",
                "Low Image Resolution"
        };

        for (int i = 0; i < keywords.length; i++) {
            String errorMessage = "Error: " + keywords[i];
            ErrorMessage e = ErrorMessage
                    .builder()
                    .id((long) i)
                    .message(errorMessage)
                    .build();
            errorMessages.add(e);
        }

        return errorMessages;
    }
}
