package com.newparse.jnews;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JnewsApplication {

	public JnewsApplication() throws IOException {
		Document doc = Jsoup.connect("https://lenta.ru/")
				.get();
		Elements news = doc.getElementsByClass("row b-top7-for-main js-top-seven");
		Elements titles = news.select("a[href^=/news/]");
		System.out.print(titles);
	}

	public static void main(String[] args) {
		SpringApplication.run(JnewsApplication.class, args);

	}

}
