package homework_7;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import java.io.*;

public class HttpStatusChecker {

    public String getStatusImage(int code) {
        StringBuilder sb = new StringBuilder();
            sb.append("https://http.cat/")
                .append(code)
                    .append(".jpg");

        try {
            Connection.Response response = Jsoup.connect(sb.toString())
                    .userAgent("Mozilla/5.0")
                    .timeout(10000).ignoreContentType(true)
                    .execute();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return sb.toString();
    }

}
