package quimica.ufc.br.estequiometria.parser;

import java.util.HashMap;

import quimica.ufc.br.estequiometria.interactions.Interaction1Activity;

import static quimica.ufc.br.estequiometria.InteractionAcitivity.ELEMENTS_HASH;

/**
 * Look up table. Stores information about the atoms.
 * @author vladymirbezerra
 *
 */
public class LookUpTable {
	private HashMap<String, Integer> table = new HashMap<>();	
	private static LookUpTable instance;
	
	private LookUpTable() {}
	

	public static LookUpTable getTable() {
		if (null == instance) {
			instance = new LookUpTable();
		}
		return instance;
	}
	

	
	/**
	 * Obs.: Throw null exception
	 */
	public Double lookAtom(String name) {
		return ELEMENTS_HASH.get(name);
	}
}
