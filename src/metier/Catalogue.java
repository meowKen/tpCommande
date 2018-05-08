package metier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Catalogue {
	private List<Article> inventaire;
	
	
	public Catalogue() throws SQLException {
		ConnectionC c = new ConnectionC("tpcomm");
		Connection conn = c.getConnection();
		this.inventaire = new ArrayList<Article>();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM article");
		while(rs.next()) {
			inventaire.add(new Article(rs.getInt("id_art"), rs.getString("nom_art"), rs.getFloat("prix_art"), rs.getInt("qte_art"), rs.getString("ref_art")));
		}
		st.close();
		rs.close();
		conn.close();
	}
	
	public List<Article> getCat(){
		return inventaire;
	}
	
	public void add(Article a) {
		inventaire.add(a);
	}
	
	public void searchAndAdd(String ref) throws SQLException {
		ConnectionC c = new ConnectionC("tpcomm");
		Connection conn = c.getConnection();
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM article WHERE ref_art = ?");
		ps.setString(1, ref);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			inventaire.add(new Article(rs.getInt("id_art"), rs.getString("nom_art"), rs.getFloat("prix_art"), rs.getInt("qte_art"), rs.getString("ref_art")));
		}
	}
	
	public List<Article> searchByRef(String ref){
		List<Article> ret = new ArrayList<Article>();
		for(Article a : inventaire) {
			if(a.getRef().contains(ref)) {
				ret.add(a);
			}
		}
		return ret;
	}
	
	public List<Article> searchByKey(String key){
		List<Article> ret = new ArrayList<Article>();
		for(Article a : inventaire) {
			if(a.getNom().contains(key)) {
				ret.add(a);
			}
		}
		return ret;
	}
	
	public String toString() {
		String str = "nombre d'articles dans le catalogue : "+inventaire.size();
		for(Article a : inventaire) {
			str += "\n"+a.toString();
		}
		return str;
	}
	
	
}
