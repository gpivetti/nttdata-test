package br.com.nttdata.devtest.application.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GetExceptionMessageHelper {
    public static String getErrorMessage(String errorMessage) {
        if (errorMessage != null && errorMessage.contains(":")) {
            var errorMessageArray = errorMessage.split(":");
            List<String> errorMessageList = Arrays.stream(errorMessageArray).collect(Collectors.toList());
            errorMessageList.remove(0);
            if (!errorMessageList.isEmpty()) {
                return String.join("", errorMessageList).trim();
            }
        }
        return errorMessage;
    }
}
