package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;

public class Acao41 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		ctLabel++;
		String labelCase41 = createLabel(ctLabel);
		String tokenLexeme41 = token.getLexeme();

		if (tokenLexeme41.equals("whileTrueDo")) {
			codigo.add("brfalse " + labelCase41);
		} else if (tokenLexeme41.equals("whileFalseDo")) {
			codigo.add("brtrue " + labelCase41);
		}
		pilhaDeRotulos.push(labelCase41);

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}
	
	private String createLabel(int ctLabel) {
		return "label" + ctLabel;
	}

}
