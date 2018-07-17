/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OTPModif;

/**
 *
 * @author Susi Purba
 */
public class OTPModifCipher {
    public static String removeDuplicate(String s){
        int len = s.length();
        for(int i=0;i<len-1;i++){
            char c = s.charAt(i);
            String preString = s.substring(0,i+1);
            String temp = s.substring(i+1);
            temp = temp.replaceAll(""+c, "");
            s =  preString + temp;
            len = s.length();
        }
        return s;
    }

    public static String setNewKey(String s, int expectedLength){
        String x = "";
        int index = 0;
        int i = s.length()-1;
        
            while(index < expectedLength){
                char c = s.charAt(i);
                int j = (int) c;
                    if(j % 2 == 0){
                        x += s.charAt(i);
                        index++;
                    }
                    i--;
            }
        return x;
        
    }

    public static String setNewPlainText(String s, int expectedLength){
        String x = "";
        int index = 0;
        int i=0;
            while(index < expectedLength){
                char c = s.charAt(i);
                int j = (int) c;
                if(j % 2 == 1){
                    x += s.charAt(i);
                    index++;
                }
                i++;
            }
        return x;
    }  
    
    public static int[] encrypt(String str, String key) {
        int[] output = new int[str.length()];
        for(int i = 0; i < str.length(); i++) {
            int o = (Integer.valueOf(str.charAt(i)) ^ Integer.valueOf(key.charAt(i % (key.length()))));
            output[i] = o;
        }
        return output;        
    }

    
    public static String decrypt(int[] input, String key) {
        String output = "";        
        for(int i = 0; i < input.length; i++) {
            output += (char) ((input[i]) ^ (int) key.charAt(i % (key.length())));
        }
        return output;
    }
    
}
