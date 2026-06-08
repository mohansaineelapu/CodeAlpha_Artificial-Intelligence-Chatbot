import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBotGUI extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    private ChatBotLogic bot;

    public ChatBotGUI() {

        bot = new ChatBotLogic();

        setTitle("AI Chatbot");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane =
                new JScrollPane(chatArea);

        inputField = new JTextField();

        sendButton = new JButton("Send");

        JPanel bottomPanel =
                new JPanel(new BorderLayout());

        bottomPanel.add(inputField,
                BorderLayout.CENTER);

        bottomPanel.add(sendButton,
                BorderLayout.EAST);

        add(scrollPane,
                BorderLayout.CENTER);

        add(bottomPanel,
                BorderLayout.SOUTH);

        sendButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {
                        sendMessage();
                    }
                });

        inputField.addActionListener(
                new ActionListener() {
                    public void actionPerformed(
                            ActionEvent e) {
                        sendMessage();
                    }
                });
    }

    private void sendMessage() {

        String userMessage =
                inputField.getText();

        if(userMessage.trim().isEmpty()) {
            return;
        }

        chatArea.append(
                "You: " + userMessage + "\n");

        String response =
                bot.getResponse(userMessage);

        chatArea.append(
                "Bot: " + response + "\n\n");

        inputField.setText("");
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {

                        new ChatBotGUI()
                                .setVisible(true);
                    }
                });
    }
}