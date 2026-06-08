import java.util.HashMap;

public class ChatBotLogic {

    private HashMap<String, String> faq;

    public ChatBotLogic() {
        faq = FAQData.getFAQ();
    }

    public String getResponse(String message) {

        message = preprocess(message);

        for(String key : faq.keySet()) {

            if(message.contains(key)) {
                return faq.get(key);
            }
        }

        return "Sorry, I don't understand. Please ask another question.";
    }

    private String preprocess(String text) {

        text = text.toLowerCase();
        text = text.replaceAll("[^a-zA-Z0-9 ]", "");

        return text;
    }
}