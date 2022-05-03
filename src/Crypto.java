import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Crypto extends JFrame{
    private JPanel Main;
    private JTextField txtPlain1;
    private JLabel labelP1;
    private JTextField txtKey1;
    private JLabel labelK1;
    private JTextField txtCipher1;
    private JLabel labelC1;
    private JButton encryptC;
    private JButton encryptCCC;
    private JLabel labelC2;
    private JTextField txtKey2;
    private JLabel labelK2;
    private JButton DecryptC;
    private JButton DecryptCCC;
    private JLabel labelP2;
    private JLabel labelDecrypt;
    private JLabel labelEncrypt;
    private JTextField txtCipher2;
    private JTextField txtPlain2;

    public Crypto(){

        encryptC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String plainText = txtPlain1.getText();
                String key0 = txtKey1.getText();
                int key1 = Integer.parseInt(key0);

                if(key1>26){
                    key1 = key1%26;
                }
                else if(key1<0){
                    key1 = (key1%26)+26;
                }

                String cipherText = "";
                for(int i = 0; i<plainText.length(); i++){
                    //find specific character
                    char c =plainText.charAt(i);
                    //check if character is in the alphabet
                    if(Character.isLetter(c)) {
                        //need to check upper and lower case since corresponding numbers are different in ASCII table
                        if (Character.isUpperCase(c)) {
                            char c2 = (char) (c + key1);
                            //if c > 'Z' value in ASCII table will move to symbols and not loop back into alphabet
                            if (c2 > 'Z') {
                                cipherText += (char)(c-(26-key1));
                            } else {
                                cipherText += c2;
                            }
                        } else if (Character.isLowerCase(c)) {
                            char c2 = (char) (c + key1);
                            //if c > 'z' value in ASCII table will move to symbols and not loop back into alphabet
                            if (c2 > 'z') {
                                cipherText += (char)(c-(26-key1));
                            } else {
                                cipherText += c2;
                            }
                        }
                    }
                    //if character is not in alphabet take character and place at the end of cipherText
                    else{
                        cipherText += c;
                    }
                }

                txtCipher1.setText(cipherText);
                txtCipher1.setVisible(true);
                System.out.println(txtCipher1.getText());


            }
        });

        encryptCCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        DecryptC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cipherText = txtCipher2.getText();
                String key0 = txtKey2.getText();
                int key1 = Integer.parseInt(key0);

                if(key1>26){
                    key1 = key1%26;
                }
                else if(key1<0){
                    key1 = (key1%26)+26;
                }

                String plainText = "";
                for(int i = 0; i<cipherText.length(); i++){
                    //find specific character
                    char c =cipherText.charAt(i);
                    //check if character is in the alphabet
                    if(Character.isLetter(c)) {
                        //need to check upper and lower case since corresponding numbers are different in ASCII table
                        if (Character.isUpperCase(c)) {
                            char c2 = (char) (c - key1);
                            //if c < 'A' value in ASCII table will move to symbols and not loop back into alphabet
                            if (c2 < 'A') {
                                plainText += (char)(c+(26-key1));
                            } else {
                                plainText += c2;
                            }
                        } else if (Character.isLowerCase(c)) {
                            char c2 = (char) (c - key1);
                            //if c < 'a' value in ASCII table will move to symbols and not loop back into alphabet
                            if (c2 < 'a') {
                                plainText += (char)(c+(26-key1));
                            } else {
                                plainText += c2;
                            }
                        }
                    }
                    //if character is not in alphabet take character and place at the end of cipherText
                    else{
                        plainText += c;
                    }
                }

                txtPlain2.setText(plainText);
                txtPlain2.setVisible(true);
                System.out.println(txtCipher2.getText());
            }
        });

        DecryptCCC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }


    public static void main(String args[]){
        Crypto javaGUI = new Crypto();
        javaGUI.setContentPane(new Crypto().Main);
        javaGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        javaGUI.setVisible(true);
        javaGUI.pack();
    }
}
