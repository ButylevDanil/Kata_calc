import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        //try {
            System.out.println(calc(s));
        /*}catch (Exception e){
            throw (new Exception());
        }*/
    }
    public static String calc(String input) throws Exception {
        HashMap<String, Integer> roman = new HashMap<String, Integer>();
        roman.put("I",1); roman.put("II",2); roman.put("III",3); roman.put("IV",4); roman.put("V",5);
        roman.put("VI",6); roman.put("VII",7); roman.put("VIII",8); roman.put("IX",9); roman.put("X",10);
        boolean flag = false;
        int a = 1;
        int b = 1;
        String result = "";
        int res = 0;
        String[] str = input.split(" ");

        if (str.length!=3){
            throw new Exception("ровно два значения");
        }
        if (roman.containsKey(str[0])){
            flag = true;
            try {
                a = roman.get(str[0]);
                b = roman.get(str[2]);
            }
            catch (Exception e){
                throw new Exception("оба числа должны быть в одной СС не меньше 1 и не больше 10");
            }
        }
        else{
            try {
                a = Integer.parseInt(str[0]);
                b = Integer.parseInt(str[2]);
            }
            catch (Exception e){
                throw new Exception("оба числа должны быть в одной СС не меньше 1 и не больше 10");
            }
        }
        /*a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[2]);*/
        if (a<1 || a>10 || b<1 || b>10){
            throw new Exception("числа должны быть не меньше 1 и не больше 10");
        }

        res = switch (str[1]) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("знак ну удовлетв. ни одному из +-*/");
        };

        HashMap<Integer, String> romanback = new HashMap<Integer, String>();
        romanback.put(1,"I"); romanback.put(2,"II"); romanback.put(3,"III"); romanback.put(4,"IV");
        romanback.put(5,"V"); romanback.put(6,"VI"); romanback.put(7,"VII"); romanback.put(8,"VIII");
        romanback.put(9,"IX"); romanback.put(10,"X"); romanback.put(11,"XI"); romanback.put(12,"XII");
        romanback.put(13,"XIII"); romanback.put(14,"XIV"); romanback.put(15,"XV"); romanback.put(16,"XVI");
        romanback.put(17,"XVII"); romanback.put(18,"XVIII"); romanback.put(19,"XIX"); romanback.put(20,"XX");
        romanback.put(21,"XXI"); romanback.put(24,"XXIV"); romanback.put(25,"XXV"); romanback.put(27,"XXVII");
        romanback.put(28,"XXVIII"); romanback.put(30,"XXX"); romanback.put(32,"XXXII"); romanback.put(35,"XXXV");
        romanback.put(36,"XXXVI"); romanback.put(40,"XL"); romanback.put(42,"XLII"); romanback.put(45,"XLV");
        romanback.put(48,"XLVIII"); romanback.put(49,"XLIX"); romanback.put(50,"L"); romanback.put(54,"LIV");
        romanback.put(56,"LVI"); romanback.put(60,"LX"); romanback.put(63,"LXIII"); romanback.put(64,"LXIV");
        romanback.put(70,"LXX"); romanback.put(72,"LXXII"); romanback.put(80,"LXXX"); romanback.put(81,"LXXXI");
        romanback.put(90,"XC"); romanback.put(100,"C");

        if (flag){
            result = romanback.get(res);
            if (result == null){
                throw new Exception("В римской системе нет отрицательных чисел");
            }
        }
        else {
            result = String.valueOf(res);
        }
        return result;
    }
}
