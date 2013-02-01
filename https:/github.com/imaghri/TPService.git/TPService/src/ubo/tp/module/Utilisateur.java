package ubo.tp.module;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jdom.*;
import org.jdom.input.SAXBuilder;
import org.jdom.output.*;


public class Utilisateur {
	public Utilisateur(){}
	/** Le login. */
	private String login;
	/** Le mot de passe crypté. */
	private String motDePasse;
	public String getLogin() {
	return login;
	}
	public void setLogin(String login) {
	this.login = login;
	}
	public String getMotDePasse() {
	return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
	}
	public Utilisateur(String login,String motDePasse){
		this.login=login;
		this.motDePasse=motDePasse;
	}
	/**
	 * Création d'un nouvel utilisateur.
	 * 
	 * @param login
	 *            le login
	 * @param motDePasse
	 *            le mot de passe en clair
	 * @return le nouvel utilisateur ou <code>null</code> si la création a
	 *         échoué
	 */
	public Utilisateur nouvelUtilisateur(String login, String motDePasse) {
		return new Utilisateur(login, motDePasse);
	}
	/**
	 * Renvoi vrai si le mot de passe est valide, faux sinon.
	 * @param motDePasse le mot de passe à vérifier
	 * @return vrai si le mot de passe est valide, faux sinon.
	 */
	public boolean motDePasseValide(String motDePasse){
		return true;
	}
	public Boolean saveUser(Utilisateur uti) throws IOException, JDOMException {
		if(verifLogin(uti.login)){
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("utilisateur.xml");
		Document doc = (Document) builder.build(xmlFile);
		Element rootNode = doc.getRootElement();
		Element utilisateur = new Element("utilisateur");
		utilisateur.addContent(new Element("login").setText(uti.login));
		utilisateur.addContent(new Element("motDePasse").setText(uti.motDePasse));
		rootNode.addContent(utilisateur);
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(doc, new FileWriter("utilisateur.xml"));
		return true;
		}return false;
   }
	public Boolean verifLogin(String login) throws JDOMException, IOException{
		
	 SAXBuilder builder = new SAXBuilder();
	  File xmlFile = new File("utilisateur.xml");
	  Document document = (Document) builder.build(xmlFile);
		Element rootNode = document.getRootElement();
		List list = rootNode.getChildren("utilisateur");
		for (int i = 0; i < list.size(); i++) {
			 
			   Element node = (Element) list.get(i);
			 
			   if (node.getChildText("login").equals(login)){
				  
				   return false;
			   }
		}return true;
}
}