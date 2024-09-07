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
    public static boolean isOpeningBracket(char ch)
    {
        if(ch=='{' || ch=='[' || ch=='(')
        {
            return true;
        }
        return false;
    }

    public static boolean isClosingBracket(char ch)
    {
        if(ch=='}' ||  ch==']' || ch==')')
        {
            return true;
        }
        return false;
    }

    public static boolean isMatchingPair(char opening, char closing)
    {
        if(opening=='{' && closing=='}')
        {
            return true;
        }
        if(opening=='[' && closing==']')
        {
            return true;
        }
        if(opening=='(' && closing==')')
        {
            return true;
        }
        return false;
    }
    public static String convertToPostfix(String str)
    {
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for(char ch: str.toCharArray())
        {
            if(Character.isLetterOrDigit(ch))
            {
                postfix.append(ch);
            }
            else if(isOpeningBracket(ch))
            {
                st.push(ch);
            }
            else if(isClosingBracket(ch))
            {
                while(!st.isEmpty() && !isMatchingPair(st.peek(), ch))
                {
                    postfix.append(st.pop());
                }
                if(!st.isEmpty() && !isMatchingPair(st.peek(), ch))
                {
                    return "Invalid expression";
                }
                st.pop();
            }
            else
            {
                while(!st.isEmpty() && precedence(ch) <= precedence(st.peek()))
                {
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty())
        {
            if(st.peek()=='(')
            {
                return "Invalid expession";
            }
            postfix.append(st.pop());
        }
        return postfix.toString();
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
