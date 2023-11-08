/**
 * @author      : Vasileios Papadimas (papadimas@protonmail.com)
 * @file        : DNAPalindrome.java
 * @created     : Tuesday Nov 07, 2023 17:38:24 EET
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DNAPalindrome
{
        public static void main(String[] args) {
            StringDoubleEndedQueueImpl<Character> q = new StringDoubleEndedQueueImpl<Character>(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            try {
                while (br.ready()) {
                    char c = (char) br.read();
                    if (c == 10) break; // EOF
                    if (!(c=='A' || c=='T' || c=='C' || c=='G')) {
                        System.out.println("Invalid sequence!");
                        return;
                    }
                    q.addLast(c);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
           
            if ((q.size() & 1) == 1) { // odd size
                    System.out.println("Invalid sequence!");
                    return;
            }

            while (!q.isEmpty()) {
                    int sum = (int) (q.removeFirst() + q.removeLast());
                    if (!(sum == 149 || sum == 138)) { // A+T, C+G
                        System.out.println("Invalid sequence!");
                        return;
                    }
            }
            
            System.out.println("Valid sequence!");
        }
}


