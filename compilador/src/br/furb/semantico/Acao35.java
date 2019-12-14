package br.furb.semantico;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;
import br.furb.utils.Types64;

public class Acao35 implements Acao {

	@Override
	public SemanticVariables execute(String tipo, String operadorRelacional, List<String> codigo, Map<String, String> ts,
			List<String> listaID, Deque<String> pilhaDeTipos, Deque<String> pilhaDeRotulos, int ctLabel, Token token,
			String input) throws SemanticError {

		for (String idCase35 : listaID) {
			if (!ts.containsKey(idCase35)) {
				throw new SemanticError(idCase35 + Messages.NOT_DECLARED,
						StringManipulationUtil.getRowError(token.getPosition(), input));
			}

			String tipoIDCase35 = ts.get(idCase35);
			String classe = "";

			if (tipoIDCase35.equals(Types64.INT)) {
				classe = "Int64";
			} else if (tipoIDCase35.equals(Types64.FLOAT)) {
				classe = "Double";
			} else if (tipoIDCase35.equals("char")) {
				classe = "Char";
			} else if (tipoIDCase35.equals("bool")) {
				classe = "Boolean";
			}

			codigo.add("call string [mscorlib]System.Console::ReadLine()");
			
			if (!"string".equals(tipoIDCase35)) {
				codigo.add("call " + tipoIDCase35 + " [mscorlib]System." + classe + "::Parse(string)");
			}
			
			codigo.add("stloc " + idCase35);

		}

		listaID = new ArrayList<String>();

		SemanticVariables variables = new SemanticVariables();
		variables.setVariables(tipo, operadorRelacional, codigo, ts, listaID, pilhaDeTipos, pilhaDeRotulos, ctLabel);
		return variables;
	}

}
