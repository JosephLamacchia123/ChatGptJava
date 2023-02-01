import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.FileWriter;
import java.io.IOException;

public class OpenAiUnitTestService {
    private static final String API_KEY = "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";
    private static final String MODEL = "text-davinci-002";

    public static CompletionResponse getUnitTests(String method) throws UnirestException, IOException {
        String requestBody = "{\"prompt\":\"" + "Write me 5 unit tests for the method " + method +" in Java" + "\",\"max_tokens\":3000,\"temperature\":0.5}";
        HttpResponse<JsonNode> response = Unirest.post("https://api.openai.com/v1/engines/text-davinci-003/completions")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .body(requestBody)
                .asJson();
        return JSONUtil.convertFromJson(response.getBody().toString());
    }

    public void writeToFile(String fileName, String text) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file");
            e.printStackTrace();
        }
    }



}

