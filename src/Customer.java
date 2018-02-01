import java.util.ArrayList;

public class Customer {
	ArrayList<Article> articleList= new ArrayList<Article>();
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
 
		
	}

	public void addArticle(Article article) {
		articleList.add(article);
		
	
	}
	
	public void removeArticle(Article article) {
		articleList.remove(article);
	}
	
	
	
}
