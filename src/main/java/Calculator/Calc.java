package Calculator;

public class Calc {
    int x,y;
    char z;

    String result;

    public int summation(int x,int y){
        int sum = x + y;
        return sum;
    }

    public int multiplication(int x,int y){
        int sum = x * y;
        return sum;
    }

    public int subtraction(int x,int y){
        int sum = x - y;
        return sum;
    }

    public int division(int x,int y){
        int sum = x / y;
        return sum;
    }

    public String toString(){
        switch (z){
            case '+':
                result = Integer.toString(summation(x,y));
                break;
            case '*':
                result = Integer.toString(multiplication(x,y));
                break;
            case '-':
                result = Integer.toString(subtraction(x,y));
                break;
            case '/':
                result = Integer.toString(division(x,y));
                break;
            default:
                result = "Ошибка";
        }
        return "Ответ: " + result;
    }
}

