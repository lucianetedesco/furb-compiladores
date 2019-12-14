package br.furb.semantico;

import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;

public class Acao10 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		String tipo1 = pilhaDeTipos.pop();
		String tipo2 = pilhaDeTipos.pop();

		if (tipo1.equals("string") || tipo2.equals("string")) {
			if (tipo1.equalsIgnoreCase(tipo2)) {
				pilhaDeTipos.push("bool");
			} else {
				throw new SemanticError(Messages.ENCONPATIBLE_TYPES_RELATIONAL_EXPRESSION);
			}
		}
		switch (operadorRelacional) {
		case ">":
			codigo.add("cgt");
			break;
		case "<":
			codigo.add("clt");
			break;
		case "==":
			codigo.add("ceq");
			break;
		case "!=":
			codigo.add("ceq");
			codigo.add("ldc.i4 0");
			codigo.add("ceq");
			break;
		case "<=":
			codigo.add("cgt");
			codigo.add("ldc.i4 0");
			codigo.add("ceq");
			break;
		case ">=":
			codigo.add("clt");
			codigo.add("ldc.i4 0");
			codigo.add("ceq");
			break;
		}

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
