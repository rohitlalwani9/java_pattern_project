import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class pattern{
    void mainModule() {
        clear();
        System.out.println("\t\t\t   ---- PATTERN ---- \n");
        System.out.print(
                "\t\t1.Triangle \t    6.Up side Down Tringle\n\n\t\t2.Swastik \t    7.Hourglass Sand Timer\n\n\t\t3.Whole square \t    8.Diamond\n\n\t\t4.Spider Web \t    9.Real Arrow\n\n\t\t5.Exit....");
        Scanner sc = new Scanner(System.in);
        String c = JOptionPane.showInputDialog("Enter the choise -- ");
        int size;
        clear();
        switch (c) {
            case "1":
                size = input();
                Triangle(size);
                break;

            case "2":
                size = input();
                Swastik(size);
                break;

            case "3":
                size = input();
                whole_squre(size);
                break;

            case "6":
                size = input();
                Hollow_Hourglass(size);
                break;

            case "7":
                size = input();
                Hourglass_Sand_Timer(size);
                break;

            case "8":
                size = input();
                Diamond(size);
                break;

            case "9":
                size = input();
                web(size);
                break;

            case "10":
                size = input();
                Real_acrrow(size);
                break;

            case "5":
                break;
            default:
                break;
        }
        Continue();
    }


    // Continue Function
    void Continue() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n  Do you Want to Continue to print more patter.....(y/n)  ");
        String c = sc.nextLine();
        if (c.equals("y") || c.equals("Y"))
            mainModule();
        else if (c.equals("N") || c.equals("n")) {
            System.out.print(" ");
        } else {
            System.out.print("\n\n \t Sorry you Enter Wrong Choices....Press Enter (y) --- ");
            c = sc.nextLine();
            if (c.equals("y"))
                Continue();
        }
    }


    // Limite Function Or input Function
    static int input() {
        int limite = Integer.parseInt(JOptionPane.showInputDialog("Enter the Size of Pattern -- "));
        if (limite % 2 == 0)
            limite += 1;
        return limite;
    }

    // 1. Triangle........
    static void Triangle(int limite) {
        int i, j, N = limite;
        for (i = 1; i <= N; i++) {
            System.out.print(" ".repeat(N - i));
            for (j = 1; j <= i; j++) {
                System.out.print(((j == 1 || i == j) || (i == N && (j >= 1 && j <= N))) ? "x " : "  ");
            }
            System.out.println();
        }
    }

    // 2. Swastik........
    static void Swastik(int limite) {
        int i, j, n = limite;
        for (i = 1; i <= n + n - 1; i++) {
            for (j = 1; j <= n + n - 1; j++) {
                System.out.print((i == n || j == n) ||
                        (i < n && j == 1) ||
                        ((i >= n && i <= n + n - 1) && j == n + n - 1) ||
                        (i == 1 && j > n) ||
                        (n % 2 == 1 && ((i == n / 2 + 1 && j == n / 2 + 1) ||
                                (i == n / 2 + 1 && j == n / 2 + n) ||
                                (i == n / 2 + n && j == n / 2 + 1) ||
                                (i == n / 2 + n && j == n / 2 + n)))
                        ||
                        (n % 2 == 0 && ((i == n / 2 && j == n / 2) ||
                                (i == n / 2 && j == (n + n + n) / 2 - 1) ||
                                (i == (n + n + n) / 2 - 1 && j == n / 2) ||
                                (i == (n + n + n) / 2 - 1 && j == (n + n + n) / 2 - 1)))
                        ||
                        (i == n + n - 1 && j < n) ? "X " : "  ");
            }
            System.out.println();
        }
    }

    // 3. Whole Square......
    static void whole_squre(int limite) {
        int i, j, N = limite, x = 1, s;
        for (i = 1; i <= N; i++) {
            x = i;
            s = N;
            for (j = 1; j <= N; j++, x++) {
                System.out.print((i >= 2 && i <= N - 1 && (j == 1 || j == N) || (i == 1 || i == N)) ? "X " : "  ");
                if (x == s) {
                    x = x - 2;
                    s--;
                }
            }
            System.out.println();
        }
    }

    // 6. Hollow_Hourglas......
    static void Hollow_Hourglass(int limite) {

        int i, j, N = limite, x, s = 0;
        x = N;
        for (i = 1; i <= N; i++) {
            System.out.print(" ".repeat(s));
            for (j = 1; j <= x; j++) {
                System.out.print("X ");
            }
            x = (i < N / 2 + 1) ? x - 2 : x + 2;
            s = (i < N / 2 + 1) ? s + 2 : s - 2;
            System.out.println();
        }

    }

    // 7. Hourglass_Sand_Timer.... 
    static void Hourglass_Sand_Timer(int limite) {
        int i, j, N = limite, x, s, k = 0;
        x = N;
        s = 0;
        i = N;
        //Count odd Number
        while (i >= 1) {
            i = i - 2;
            k++;
        }
        for (i = 1; i <= N + N + 1; i++) {
            System.out.print(" ".repeat(s));
            for (j = 1; j <= x; j++) {
                System.out.print(
                        ((i == 1 || i == N + N + 1) || ((i >= 2 && i <= N + N) && (j == 1 || j == x))) ? "* " : "  ");
            }
            if (i >= k + 1 && i < N + 1) {
                x = x - 2;
                s += 2;
            }
            if (i >= N + 1 && i < N + k) {
                x = x + 2;
                s -= 2;
            }
            System.out.println();
        }

    }

    // 8. Diamond......
    static void Diamond(int limite) {
        int i, j, N = limite, x, s;
        s = N;
        x = 1;
        for (i = 1; i <= N + N - 1; i++) {
            System.out.print("  ".repeat(s));
            for (j = 1; j <= x; j++) {
                System.out.print(((j == 1 || j == x)) ? "* " : "  ");
            }
            if (i < N) {
                s--;
                x += 2;
            } else if (i >= N) {
                x -= 2;
                s++;
            }
            System.out.println();
        }
    }

    // 9. Spider Web......
    static void web(int limite) {
        int i, j, N = limite;
        for (i = 1; i <= N + N - 1; i++) {
            for (j = 1; j <= N + N - 1; j++) {
                System.out.print(((i == j) || (i == N || j == N) || (j == N + N - i)) ? "X " : "  ");
            }
            System.out.println();
        }

    }

    // 10. Real Arrow...... 
    static void Real_acrrow(int limite) {
        int i, j, N = limite, odd = 0;
        for (i = 1; i <= N; i++) {
            System.out.print(" ".repeat(N - i));
            for (j = 1; j <= i; j++) {
                System.out.print( "* ");   
            }
            System.out.println();
            if(i % 2 == 1)odd++;
        }
        
        int tot = N+N, x = N /2 + 1, y, z;
        y = x;
        z = x;
        for(i = 1; i <= tot; i++)
        {
            for(j = 1; j <= N; j++)
            {
                System.out.print((
                    ((i <= tot / 2 && j == N/2 + 1) || 
                ((i >= tot / 2 + 1 && i <= tot - (odd - 1)) && (j >= z && j <= x))||
                (((i >= tot - (odd - 1)) && ((j >= 1 && j <= (tot - i) + 1 ) || (j >= y  && j <= N))))
                ))?  "* " : "  ");
            }
            if((i >= tot / 2 + 1 && i <= tot - (odd - 1))){
                x++;
                z--;
            }
            if((i >= tot - (odd - 1)))y++;
            System.out.println();
        }
    }

    void clear() {
        try {
          
            if (System.getProperty("os.name").contains("Windows")) {
               
                System.out.print("kjdfhksdhf0");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
              
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error clearing screen: " + ex);
        }
    }

    //  -----   MAIN FUCTION ------ 
        public static void main(String args[]) {
        pattern p = new pattern();
        p.mainModule();
    }
}