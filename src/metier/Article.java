package metier;

public class Article {
	private int id;
	private String ref;
	private String nom;
	private float prix;
	private int qte;
	
	public Article() {
	}
	
	public Article(String nom, float prix) {
		this.nom = nom;
		this.prix = prix;
		qte = 0;
		ref = "ref"+((int)id/7)+(int)prix*2+""+nom.substring(nom.length()/3)+"ACL";
	}
	
	public Article(int id, String nom, float prix) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		qte = 0;
		ref = "ref"+(int)prix/id+id*2+""+nom.substring(nom.length()/3)+"ACL";
	}
	
	public Article(int id, String nom, float prix, int qte) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.qte = qte;
		ref = nom.substring(nom.length()/3)+"ACL"+prix/id;
	}
	
	public Article(int id, String nom, float prix, int qte, String ref) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.qte = qte;
		this.ref = ref;
	}
	
	public void setQte(int amount, boolean add) {
		if(add && amount>0) {
			qte+=amount;
		} else if(!add && amount>0 && qte-amount>=0){
			qte-=amount;
		} else {
			System.out.println("montant negatif ou quantité insufisante");
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}
	
	public String getRef() {
		return ref;
	}
	
	public String toString() {
		return this.getClass().getSimpleName()+" NOM :"+nom+", ID : "+id+", PRIX : "+prix+", REF : "+ref+", QTE EN STOCK : "+qte;
	}
}
