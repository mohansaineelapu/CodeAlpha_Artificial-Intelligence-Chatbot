import java.util.HashMap;

public class FAQData {

    public static HashMap<String, String> getFAQ() {

        HashMap<String, String> faq = new HashMap<>();

        faq.put("hello", "Hello! How can I help you?");
        faq.put("hi", "Hi! Nice to meet you.");
        faq.put("how are you", "I am doing great!");
        faq.put("your name", "I am an AI Chatbot.");
        faq.put("java", "Java is an object-oriented programming language.");
        faq.put("python", "Python is popular for AI and Machine Learning.");
        faq.put("bye", "Goodbye! Have a nice day.");

        return faq;
    }
}