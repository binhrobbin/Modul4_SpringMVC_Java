import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> listEven = new ArrayList<>(n);
        List<Integer> listOdd = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            if (a%2 == 0) listEven.add(a);
            else listOdd.add(a);
        }
        Collections.sort(listEven);
        for (int i = 0; i < listEven.size(); i++) {
            if (i != listEven.size()-1) System.out.print(listEven.get(i)+" ");
            else System.out.print(listEven.get(i));
        }
//        Collections.sort(listOdd);
        System.out.println();
        Collections.reverse(listOdd);
        for (int i = 0; i < listOdd.size(); i++) {
            if (i != listOdd.size()-1) System.out.print(listOdd.get(i)+" ");
            else System.out.print(listOdd.get(i));
        }
    }
}