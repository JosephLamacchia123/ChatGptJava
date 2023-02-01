import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAICoverLetterService {
    private static final String API_KEY = "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";


    public static CoverLetterResponse generateCoverLetter(String jobTitle, int yearsOfExperience, String companyName) throws UnirestException, JsonProcessingException {
        String prompt = "Please write a cover letter for a " + jobTitle + " position with " + yearsOfExperience + " years of experience, applying to " + companyName + ".";
        HttpResponse<JsonNode> response = Unirest.post("https://api.openai.com/v1/engines/text-davinci-003/completions")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_KEY)
                .body("{\"prompt\": \"" + prompt + "\",\"max_tokens\": 100}")
                .asJson();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(response.getBody().toString());
        return mapper.readValue(response.getBody().toString(), CoverLetterResponse.class);
    }
}