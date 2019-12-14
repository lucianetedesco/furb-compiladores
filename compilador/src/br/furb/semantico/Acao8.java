package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;
import br.furb.utils.Types64;

public class Acao8 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String tipo1 = pilhaDeTipos.pop();

		if (Types64.FLOAT.equalsIgnoreCase(tipo1) || Types64.INT.equalsIgnoreCase(tipo1)) {
			pilhaDeTipos.push(tipo1);
		} else {
			throw new SemanticError(Messages.ENCONPATIBLE_TYPES_ARITHMETIC_EXPRESSION, StringManipulationUtil.getRowError(token.getPosition(), input));
		}
		codigo.add("ldc.i8 -1");
		codigo.add("mul");

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
