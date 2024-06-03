import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        try {
            System.out.println(calc());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static String calc() throws Exception{
        System.out.println("Введите вашу операцию (к примеру, 2 + 3 или 3/1):");
        Scanner in = new Scanner(System.in);
        String ourOperation = in.nextLine();
        in.close();
        int myNum1;
        int myNum2;
        //погуглила - неограниченное кол-во элементов можно впихивать в ArrayList, а не в String[]
        //ArrayList&lt;String&gt; parts = new ArayList&lt;String&lt;
        String[] parts = ourOperation.replaceAll(" ", "").split("");
        if (parts.length != 3) {
            System.out.println("Вы ввели что-то не то. попытайтесь снова");
        }
        String operator = parts[1];
        int result;

        try {
            myNum1 = Integer.parseInt(parts[0]);
            myNum2 = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new Exception("Нужно вводить только целые числа");
        }

        if ((myNum1 < 1) || (myNum1 > 10) || (myNum2 < 1) || (myNum2 > 10)) {
            throw new Exception("Числа могут быть только в диапазоне [1,10]");
        }

        switch (operator) {
            case "+":
                result = myNum1 + myNum2;
                break;
            case "-":
                result = myNum1 - myNum2;
                break;
            case "*":
                result = myNum1 * myNum2;
                break;
            case "/":
                if (myNum2 == 0) {
                    throw new Exception("Деление на 0 невозможно");
                } else {
                    result = myNum1 / myNum2;
                    break;
                }
            default:
                throw new Exception("Что это за зверь?");
        }
        return String.valueOf(result);
    }
}