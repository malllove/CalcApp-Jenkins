package Calculator;
import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calc c1 = new Calc();
        System.out.println("Введите первое число:");
        c1.x = scanner.nextInt();
        System.out.println("Введите знак операции:");
        c1.z = scanner.next().charAt(0);
        System.out.println("Введите второе число:");
        c1.y = scanner.nextInt();

        System.out.println(c1);
    }
}
