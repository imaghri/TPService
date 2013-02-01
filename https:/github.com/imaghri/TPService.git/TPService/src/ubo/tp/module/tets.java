package ubo.tp.module;

import java.io.IOException;

import org.jdom.JDOMException;

public class tets {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JDOMException 
	 */
	public static void main(String[] args) throws IOException, JDOMException {
		// TODO Auto-generated method stub
Utilisateur uti=new Utilisateur();
uti.saveUser(new Utilisateur("ljqdfskjnqdsfkj","dfvhdfj"));
System.out.println("jsdb");
	}

}
