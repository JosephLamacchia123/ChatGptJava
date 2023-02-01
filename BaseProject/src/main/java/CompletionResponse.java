import lombok.Data;

import java.util.List;
@Data
public class CompletionResponse {
    private long created;
    private Usage usage;
    private String model;
    private String id;
    private List<Choice> choices;
    private String object;

    @Data
    static class Usage {
        private int completion_tokens;
        private int prompt_tokens;
        private int total_tokens;

    }
    @Data
    static class Choice {
        private String finish_reason;
        private int index;
        private String text;
        private Object logprobs;
    }
}
