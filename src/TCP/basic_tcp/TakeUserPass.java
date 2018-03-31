package TCP.basic_tcp;

import java.util.Scanner;

public class TakeUserPass {

    Scanner str = new Scanner(System.in);

    String get(String s) {
        System.out.print(s) ;
        String st = str.nextLine();
        return st ;
    }
}
