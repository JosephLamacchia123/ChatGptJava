import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JSONUtil {
    public static  <T> CompletionResponse convertFromJson(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, CompletionResponse.class);
    }
}
