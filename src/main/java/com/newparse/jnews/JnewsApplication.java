package com.newparse.jnews;

import com.newparse.jnews.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newparse.jnews.entity.News;
import com.newparse.jnews.repository.NewsRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class JnewsApplication {
	public JnewsApplication(@Autowired NewsRepository newsRepository) throws IOException {
		Document doc = Jsoup.connect("https://lenta.ru/")
				.get();
		Elements news = doc.getElementsByClass("row b-top7-for-main js-top-seven");
		Elements titles = news.select("a[href^=/news/]");
		int SaveCount = 0;
		for (int i = 0; i < 3; i++){
			try {
				Element element = titles.get(i);
				String text = element.text();
				if ("".equals(text)) continue;
				String dateTime = titles.get(1).children().get(0).attr("datetime");
				Date date = new SimpleDateFormat("HH:mm, dd MMMM yyyy").parse(dateTime.trim());
				News news1 = new News(date, text.substring(5));
				newsRepository.save(news1);
				SaveCount++;
				if (SaveCount == 3) return;
			} catch(Exception e){
				break;
			}
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(JnewsApplication.class, args);

	}
}
