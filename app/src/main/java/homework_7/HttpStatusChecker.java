package homework_7;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws Exception {
        StringBuilder sb = new StringBuilder();
            sb.append("https://http.cat/images/")
                .append(code)
                    .append(".jpg");

        String http = "https://http.cat/";

        try {
            Connection.Response response;
            response = Jsoup.connect(http)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .execute();
            System.out.println(http+" -> STATUS CODE: "+response.statusCode());

            Document doc = Jsoup.connect(http)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            Elements images = doc.getElementsByTag("a");

            for (Element image : images) {
                    String strImeg = image.attr("href");
                if(("/"+code).equals(strImeg)){
                    System.out.println("Picture found!");

                    return sb.toString();
//                    System.out.println(strImeg);
//                    System.out.println("***************************");
//
//                    System.out.println(image.getElementsByAttribute("style"));
//                    System.out.println("***************************");
//
//                    System.out.println(image.getElementsByAttribute("style"));
                }

            }
            throw new Exception("Picture "+code+" not found!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        return sb.toString();
    }
}
