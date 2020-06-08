import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class MyApplication {
    public static void main(String[] args) throws JsonProcessingException {
        final String source = "[{\n" +
                "        \"expectedInput\": \"hello\",\n" +
                "        \"expectedResponse\": \"how can i help you?\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"expectedInput\": \"need sip support\",\n" +
                "        \"expectedResponse\": \"ok, let me check \"\n" +
                "    }\n" +
                "]";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(source);

        List<MessageDetails> list = Arrays.asList(mapper.treeToValue(node, MessageDetails[].class));
        for (MessageDetails messageDetail : list) {
            System.out.println(messageDetail.getExpectedInput() + ": " + messageDetail.getExpectedResponse());
        }
    }
}
