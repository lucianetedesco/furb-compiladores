package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Types64;

public class Acao20 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String lexeme = token.getLexeme();
		pilhaDeTipos.push(Types64.STR);

		switch (lexeme) {
		case "\\s":
			codigo.add("ldstr " + "\" \"");
			break;
		case "\\n":
			codigo.add("ldstr " + "\"\\n\"");
			break;
		case "\\t":
			codigo.add("ldstr " + "\"\\t\"");
			break;
		default:
			break;
		}

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
