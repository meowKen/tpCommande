package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Article;
import metier.Catalogue;
import metier.ConnectionC;
import metier.Interpreter;

public class Executeur {
	private Interpreter inter;
	
	public Executeur(){
		inter = new Interpreter();
	}
	
	public Article addArticleToArticles(String baseName) {
		ConnectionC c = new ConnectionC(baseName);
		Connection conn = c.getConnection();
		String[] s = inter.getArticle();
		Article a1 = new Article(s[1], Float.parseFloat(s[2]));
		if(Integer.parseInt(s[3]) == 1) {
			try {
				PreparedStatement ps = conn.prepareStatement("INSERT INTO article(nom_art, prix_art, ref_art) VALUES (?, ?, ?)");
				ps.setString(1, a1.getNom());
				ps.setFloat(2, a1.getPrix());
				ps.setString(3, a1.getRef());
				ps.executeUpdate();
				System.out.println("------AJOUT DANS LA TABLE-----");
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return a1;
	}
	
	public Article searchArticleByName(String baseName, Catalogue cat) throws SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.println("entrer le nom de l'article recherché : ");
		List<Article> a2 = new ArrayList<Article>();
		a2 = cat.searchByKey(sc.nextLine());
		if(a2.size() == 0) {
			System.out.println("aucun articles trouvé ");
			return new Article();
			}
		System.out.println(a2.size()+" article(s) trouvé(s) :");
		for(Article a : a2) {
			System.out.println(a);
		}
		System.out.println("entrez l'identifiant de l'article voulu ou -1 pour quitter la fonction :");
		int choix = Integer.parseInt(sc.nextLine());
		if(choix == -1) {
			return new Article();
		} else {
			ConnectionC c = new ConnectionC(baseName);
			Connection conn = c.getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM article WHERE id_art = ?");
			ps.setInt(1, choix);
			ResultSet rs = ps.executeQuery();
			Article a1 = new Article();
			if(rs.next()) {
				a1 = new Article(rs.getInt("id_art"), rs.getString("nom_art"), rs.getFloat("prix_art"), rs.getInt("qte_art"), rs.getString("ref_art"));
			}
			ps.close();
			conn.close();
			return a1;
		}		
	}
}
