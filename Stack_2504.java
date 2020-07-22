package backjoon;

//못함
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_2504 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strline = br.readLine().split("");
		int result = 0;
		Stack<String> stack = new Stack<>();
		
        stack.push(strline[0]);
        
        for(int i=1 ; i<strline.length ; i++){
            String str = strline[i];
        
            if(str.equals("(") || str.equals("[")){    // 여는 괄호일 때 스택에 넣음
                stack.push(str);
            }
            else if(str.equals(")")){    // 닫는 괄호가 ')' 일때
                if(stack.peek().equals("(")){ // 중첩된 괄호가 아니라면 스택에 '2'를 넣는다.
                    stack.pop();
                    stack.push("2");
                }
                else{
                    int temp = 0;
                    while (!stack.isEmpty()) { // 여는 괄호가 나올 때까지 더하고, 여는 괄호가 나오면 *2
                        String pop = stack.pop();
                        if(pop.equals(")") || pop.equals("[") || pop.equals("]")){
                            System.out.println(0);
                            return;
                        }
                        if(pop.equals("(")){
                            stack.push(String.valueOf(temp*2));
                            break;
                        }
                        temp += Integer.parseInt(pop);
                    }
                    if(stack.isEmpty()){
                        System.out.println(0);
                        return;
                    }
                }
            }
            else if(str.equals("]")){    // 닫는 괄호가 ']' 일때
                if(stack.peek().equals("[")){ // 중첩된 괄호가 아니라면 스택에 '3'를 넣는다.
                    stack.pop();
                    stack.push("3");
                }
                else{
                    int tmp = 0;
                    while (!stack.isEmpty()) {    // 여는 괄호가 나올 때까지 더하고, 여는 괄호가 나오면 *3
                        String pop = stack.pop();
                        if(pop.equals("(") || pop.equals(")") || pop.equals("]")){
                            System.out.println(0);
                            return;
                        }    
                        if(pop.equals("[")){
                            stack.push(String.valueOf(tmp*3));
                            break;
                        }
                        tmp += Integer.parseInt(pop);
                    }
                    if(stack.isEmpty()){    // 괄호 짝이 맞지 않음
                        System.out.println(0);
                        return;
                    }
                }
            }
            
        }
        
        while(!stack.isEmpty()){    // 스택의 있는 값을 모두 더한다.
            String str = stack.pop();
            if(str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]")){
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(str);
        }
        System.out.println(result);    // 결과 출력
    }
}
 
