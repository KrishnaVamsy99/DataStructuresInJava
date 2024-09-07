import java.util.Stack;

class ParanthesisMatching
{
    

    public static boolean paranthesisMatchingIsBalanced(String str)
    {
        Stack<Character> st = new Stack<>();

        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i)=='(')
            {
                st.push(str.charAt(i));
            }
            else if(str.charAt(i)=='}' || str.charAt(i)==')' || str.charAt(i)==']')
            {
                if(st.isEmpty())
                {
                    return false;
                }
                char top = st.pop();
                if(str.charAt(i)==')' && top!='(' || str.charAt(i)==']' && top!='[' || str.charAt(i)=='}' && top!='{')
                {
                    return false;
                }
            }
        }
        return st.empty();
    }
}
class ParanthesisMatchingProblem
{
    public static void main(String []args)
    {
        String str = "{[()]}";
        boolean isBalanced = ParanthesisMatching.paranthesisMatchingIsBalanced(str);
        System.out.println(isBalanced);
    }
}