/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTPModif;

import static OTPModif.OTPModifCipher.decrypt;
import static OTPModif.OTPModifCipher.encrypt;
import static OTPModif.OTPModifCipher.removeDuplicate;
import static OTPModif.OTPModifCipher.setNewKey;
import static OTPModif.OTPModifCipher.setNewPlainText;
import java.util.Scanner;

/**
 *
 * @author Susi Purba
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        //plaintext from user
        System.out.println("Enter the message (Plain text): ");
        String plaintext = sc.next();
        
        char[] stringToCharArray = plaintext.toCharArray();
        for (int i=0; i<stringToCharArray.length; i++){
            System.out.println(i+" : "+stringToCharArray[i]);
        }
        
        
        //removing duplicate of plaintext
        String message = removeDuplicate(plaintext);
        
        //user input length of key
        System.out.println("Enter the length of key: ");
        int lengthOfKey = sc.nextInt();
        
        //to create new plaintext depend on length of key
        String a = setNewPlainText(message, lengthOfKey);
        String c = a;
        char[] np = c.toCharArray();
        
        System.out.println("New Plaintext: "+c);
        for(char output: np){
            System.out.println(output);
        }
        
        //to create key
        String b = setNewKey(message, lengthOfKey);
        String d = b;
        System.out.println("New Key: "+d);
        
        
        //encryption 
        System.out.println("++--Enkripsi--++");
        System.out.println("Ciphertext: ");
        int[] encrypted = encrypt(c,d);
        for(int i = 0; i < encrypted.length; i++){
            System.out.printf("%d ", encrypted[i]);
        }
        
        
        //decryption
        System.out.println("\n++--Dekripsi--++");
        System.out.println("\nPlaintext: ");
        System.out.println(decrypt(encrypted,d));  
        
        sc.close();
    }
    
    
}
