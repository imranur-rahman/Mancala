package source1;

import java.util.Scanner;

public class Stdin {
        static Scanner scanner;
        public Stdin() {
                scanner = new Scanner(System.in);
        }

        public static int readIntInRange(int start, int end, String s) {
                System.out.println(s);
                while(true){
                        int ret = scanner.nextInt();
                        if(ret >= start  &&  ret <= end)
                                return ret;
                        System.out.println("Please insert valid input");
                }
        }

        public static int readInt(String s) {
                System.out.println(s);
                int ret = scanner.nextInt();
                return ret;
        }

        public static boolean readBoolean(String s) {
                System.out.println(s);
                return scanner.nextBoolean();
        }

        public static int readIntInRange(int start, int end) {
                while(true){
                        int ret = scanner.nextInt();
                        if(ret >= start  &&  ret <= end)
                                return ret;
                        System.out.println("Please insert valid input");
                }
        }
}
