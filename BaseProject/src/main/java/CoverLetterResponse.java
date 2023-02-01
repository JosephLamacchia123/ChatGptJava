import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CoverLetterResponse {

    private long created;
    private Usage usage;
    private String model;
    private String id;
    private Choice[] choices;
    private String object;



    @Data
    public static class Usage {
        private int completion_tokens;
        private int prompt_tokens;
        private int total_tokens;
    }

    @Data
    public static class Choice {
        private String finish_reason;
        private int index;
        private String text;
        @JsonProperty("logprobs")
        private Object logProbs;
    }

}
