package ubo.tp.test;

import java.io.IOException;

import junit.framework.Assert;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.jdom.JDOMException;
import org.junit.Test;

import ubo.tp.module.Utilisateur;

public class UtilisateurTest {
	@Mocked
	Utilisateur uti=new Utilisateur();
	Utilisateur uti1=new Utilisateur("zakaria","hfhfhf");
    
    @Test
    public void motDePasseValideTest(){
        new NonStrictExpectations() {
            {
                uti.motDePasseValide("123dfsds554");returns(true);
                uti.motDePasseValide("123");returns(false);
                
            }
        };
        
        Assert.assertTrue(uti.motDePasseValide("123dfsds554"));
        Assert.assertFalse(uti.motDePasseValide("123"));
        
    }
    @Test
    public void enregisterUtilisateurTest() throws JDOMException, IOException {
  
    }
}
