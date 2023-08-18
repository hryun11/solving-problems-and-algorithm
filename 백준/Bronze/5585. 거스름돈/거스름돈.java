import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;
        int coinNum = 0;
        if (change >= 500) {
            coinNum += change / 500;
            change = change % 500;
        }
        if (change >= 100) {
            coinNum += change / 100;
            change = change % 100;
        }
        if (change >= 50) {
            coinNum += change / 50;
            change = change % 50;
        }
        if (change >= 10) {
            coinNum += change / 10;
            change = change % 10;
        }
        if (change >= 5) {
            coinNum += change / 5;
            change = change % 5;
        }

        coinNum += change;

        System.out.println(coinNum);
    }
}
