import java.util.Stack;

/*  Step1: First check the character is letter or digit. if it is, then directly add to postfix string
 *  Step2: if it is '(' open brackets then add it to stack
 *  Step3: if it is ')' closed brackets then we have to pop all the elements until you find '(' opening brackts
 *  and it to postfix expression.
 *  if you find the open brackets, then once check whether the top element is '(' and check stack is not empty,
 *  if this condition failed then it is not valid expression. 
 *  else pop the element out
 *  Step4: if it is operator then we have to check the precedence of the operator and make sure the stack is not empty.
 *  the precedence must be greater than. if it less than or equal to the operator in the stack then we have to pop
 *  and add it to the postfix expression
 *  Step5: and atlast, when we reach the end of the infix expression, then we have to pop all the elements out of the
 *  stack. if top of the stack contains '(' open brackets then again it is not valid expression
 * 
 * 
*/

class Convert
{
    public static String convertToPostfix(String str)
    {
        Stack<Character> st = new Stack<>();

        String str2 = "";
        
        // Go through the infix expression
        for(char ch: str.toCharArray())
        {
            // Check whether it is character or digit. If Yes, directly add to str2(postfix)
            if(Character.isLetterOrDigit(ch))
            {
                str2 += ch;
            }

            // if ch is '(', if yes, push to stack
            else if(ch=='(')
            {
                st.push(ch);
            }

            // pop all elements in the stack until you find '(' and upto stack is not empty
            else if(ch==')')
            {
                while(!st.isEmpty() && st.peek()!='(')
                {
                    str2 += st.pop();
                }
                // Here still the top element will be '(' character.
                if(!st.empty() && st.peek()!='(')
                {
                    return "Invalid Expression";
                }
                st.pop();
            }
            // if operator is found, we need to check the precedence
            else
            {
                while (!st.isEmpty() && precedence(ch)<=precedence(st.peek()))
                {
                    str2 +=st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            if(st.peek()=='(')
            {
                return "Invalid expression";
            }
            str2 +=st.pop();
        }

        return str2;
    }

    public static int precedence(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}
public class InfixToPostfix
{
    public static void main(String []args)
    {
        String str = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(Convert.convertToPostfix(str));
    }
}
