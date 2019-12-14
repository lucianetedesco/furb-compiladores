package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;

public class Acao13 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String tipo1 = pilhaDeTipos.pop();
		if (tipo1.equalsIgnoreCase("bool")) {
			pilhaDeTipos.push("bool");
		} else {
			throw new SemanticError(Messages.ENCONPATIBLE_TYPES_LOGIC_EXPRESSION, StringManipulationUtil.getRowError(token.getPosition(), input));
		}
		codigo.add("ldc.i4.1");
		codigo.add("xor");

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
