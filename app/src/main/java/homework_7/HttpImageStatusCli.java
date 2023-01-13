package homework_7;

import java.util.Scanner;

public class HttpImageStatusCli {
    public static void main(String[] args) {

        new HttpImageStatusCli().askStatus();

    }

    public void askStatus(){

        Scanner sc = new Scanner(System.in);
        int code=0;

        //перевіряю введений код на валідність
        System.out.println("Pleas Enter HTTP status code");
        while (true) {
                String line = sc.nextLine();
                if(isNumeric(line)){
                    sc.close();
                    code = Integer.parseInt(line);
                    break;
                }
        }

        try {
                //Пройшовши перевірку даю посилання на завантаження
                new HttpStatusImageDownloader().downLoadImage(code);
            } catch (Exception e) {
                System.out.println("There is not image for HTTP status "+code);
            }
    }

    public boolean isNumeric(String line){
        try {
            Integer.parseInt(line);
            return true;
        } catch (NumberFormatException e){
            System.out.println("Please enter valid number");
            return false;
        }
    }
}
