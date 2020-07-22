package backjoon;

//����
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
        
            if(str.equals("(") || str.equals("[")){    // ���� ��ȣ�� �� ���ÿ� ����
                stack.push(str);
            }
            else if(str.equals(")")){    // �ݴ� ��ȣ�� ')' �϶�
                if(stack.peek().equals("(")){ // ��ø�� ��ȣ�� �ƴ϶�� ���ÿ� '2'�� �ִ´�.
                    stack.pop();
                    stack.push("2");
                }
                else{
                    int temp = 0;
                    while (!stack.isEmpty()) { // ���� ��ȣ�� ���� ������ ���ϰ�, ���� ��ȣ�� ������ *2
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
            else if(str.equals("]")){    // �ݴ� ��ȣ�� ']' �϶�
                if(stack.peek().equals("[")){ // ��ø�� ��ȣ�� �ƴ϶�� ���ÿ� '3'�� �ִ´�.
                    stack.pop();
                    stack.push("3");
                }
                else{
                    int tmp = 0;
                    while (!stack.isEmpty()) {    // ���� ��ȣ�� ���� ������ ���ϰ�, ���� ��ȣ�� ������ *3
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
                    if(stack.isEmpty()){    // ��ȣ ¦�� ���� ����
                        System.out.println(0);
                        return;
                    }
                }
            }
            
        }
        
        while(!stack.isEmpty()){    // ������ �ִ� ���� ��� ���Ѵ�.
            String str = stack.pop();
            if(str.equals("(") || str.equals(")") || str.equals("[") || str.equals("]")){
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(str);
        }
        System.out.println(result);    // ��� ���
    }
}
 
