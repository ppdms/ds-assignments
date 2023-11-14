import java.util.Scanner;

public class PrefixToInfix {
    public static void main(String[] args) {
        String prefix;
        // Request Prefix version
        Scanner s = new Scanner(System.in); 
        System.out.println("Enter the Prefix version of the expression");
        prefix = s.nextLine();

        char[] charArray = new char[prefix.length()];
        
        // Use a loop to place each character (after turning them into strings) into the array
        for (int i = 0; i < prefix.length(); i++) {
            charArray[i] = prefix.charAt(i);
        }

        // Function call ****
        prefixToInfix(charArray);      
    }

    static void prefixToInfix(char[] expression){
        try{
            // In this case the queue will be used as a stack, hence the name
            StringDoubleEndedQueueImpl<String> stack = new StringDoubleEndedQueueImpl<>();

            int i = expression.length - 1;
            while (i >= 0){ // We start from the back so that we can manage the data more easily
                // If a character is an integer
                if ('0' <= expression[i] && expression[i] <= '9'){
                    stack.addLast(Character.toString(expression[i]));
                    i -= 1;
                }
                // If a character is a valid operator
                else if (expression[i] == '+' || expression[i] == '-' || expression[i] == '*' || expression[i] == '/'){
                    String temp = "("+stack.removeLast()+" "+expression[i]+" "+stack.removeLast()+")"; 
                    stack.addLast(temp);
                    i -= 1;
                }
                // If a character neither an integer nor a valid operator
                else{
                    System.out.println("The expression you have entered is invalid...");
                    return;
                }
            }
            if (stack.size() > 1){
                System.out.println("The expression you have entered is invalid...");
            }
            else{
                System.out.println(stack.removeLast());
            }
        }
        // Just in case the user decides to give an expression that may lead to errors
        catch(Exception e){
            System.out.println("The expression you have entered is invalid...");
        }               
    }
}
