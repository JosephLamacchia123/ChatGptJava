import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws UnirestException, IOException {
       System.out.println(OpenAiUnitTestService.getUnitTests("public int addNumbers(int a, int b){return a + b;}").getChoices().get(0).getText());
    }


}
