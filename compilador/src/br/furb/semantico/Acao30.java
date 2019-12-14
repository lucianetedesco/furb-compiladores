package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Types64;

public class Acao30 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String lexeme = token.getLexeme();
		
		if ("int".equals(lexeme)) {
			tipo = Types64.INT;
		} else if ("float".equals(lexeme)) {
			tipo = Types64.FLOAT;
		} else if ("char".equals(lexeme)) {
			tipo = "char";
		} else if ("bool".equals(lexeme)) {
			tipo = "bool";
		} else if ("string".equals(lexeme)) {
			tipo = "string";
		}

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
