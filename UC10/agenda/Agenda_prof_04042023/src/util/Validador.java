package util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class Validador extends PlainDocument {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limite;

	public Validador(int limite) {
		super();
		this.limite = limite;
	}
	
	public void insertString(int ofs, String str, AttributeSet a) throws BadLocationException {
		if ((getLength() + str.length()) <= limite) {
			super.insertString(ofs, str, a);
		}
	}

}
