package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.Types64;

public class Acao2 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String tipo1 = pilhaDeTipos.pop();
		String tipo2 = pilhaDeTipos.pop();
		SemanticStaticUtils.throwSemanticException(tipo1, tipo2, Messages.ENCONPATIBLE_TYPES_ARITHMETIC_EXPRESSION, token, input);
		if (Types64.FLOAT.equalsIgnoreCase(tipo1) || Types64.FLOAT.equalsIgnoreCase(tipo2)) {
			pilhaDeTipos.push(Types64.FLOAT);
		} else {
			pilhaDeTipos.push(Types64.INT);
		}
		codigo.add("sub");

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
