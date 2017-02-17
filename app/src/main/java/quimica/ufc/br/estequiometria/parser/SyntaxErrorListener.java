package quimica.ufc.br.estequiometria.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Listener for syntax errors.
 * @author vladymirbezerra
 *
 */
public class SyntaxErrorListener extends BaseErrorListener {
	
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		throw new SyntaxErrorException("Erro: Verifique a formula e tente novamente.");
	}
	
}
