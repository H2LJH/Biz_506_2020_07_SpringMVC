package dd;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class dd {

	public static void main(String[] args) 
	{
		String[] detailNews = null;
		String[] newsData = new String[3];
		String newsUrl = "/?pageIndex=0"; // 뉴스 페이지 인덱스 문자열
		String url = "https://mnews.sarangbang.com"; // 뉴스페이지 URL ( 디테일 붙이기 용도) 
		int index = 0;
		
		try 
		{
			Document doc = Jsoup.connect(url+newsUrl).get();
			Elements newsList = doc.select(".list_news.rank").select("li");
			detailNews = new String[newsList.size()];
			
			
			for(Element one : newsList)
			{
				detailNews[index] = url + one.select("a").attr("href");
				System.out.println(detailNews[index]);
				index++;
			}
			
			newsList.clear();
			index = 0;
			for(String one : detailNews)
			{
				doc = Jsoup.connect(detailNews[index]).get();
				newsData[0] = doc.select(".view_wrap > .article_head h3").text(); // Title
				newsData[1] = doc.select(".figcaption.text-center img").attr("src"); // img url
				newsData[2] = doc.select(".article_view p").text(); // content
			
				System.out.println(newsData[0]);
				System.out.println(newsData[1]);
				System.out.println(newsData[2]);					
				index++;
			}			
		}
					
		catch (IOException e) 
		{
			System.out.println("사랑방 뉴스 접속 실패 URL 확인");
			e.printStackTrace();
		}
	}
}
