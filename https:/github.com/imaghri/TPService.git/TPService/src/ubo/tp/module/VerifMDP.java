package ubo.tp.module;

public interface VerifMDP {
	/**
	 * Renvoi vrai si le mot de passe est valide, faux sinon.
	 * @param motDePasse le mot de passe à vérifier
	 * @return vrai si le mot de passe est valide, faux sinon.
	 */
	public boolean motDePasseValide(String motDePasse);
}
