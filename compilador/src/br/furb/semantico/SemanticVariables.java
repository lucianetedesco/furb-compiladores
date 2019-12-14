package br.furb.semantico;

import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.furb.common.Token;

public class SemanticVariables {
	
	private HashMap<String, Object> variables;
	
	

	public SemanticVariables() {
		this.variables = new HashMap<String, Object>();
	}

	public void setVariables(String tipo,
			String operadorRelacional,
			List<String> codigo,
			Map<String, String> ts,
			List<String> listaID,
			Deque<String> pilhaDeTipos,
			Deque<String> pilhaDeRotulos,
			int ctLabel) {
		variables.put("tipo", tipo);
		variables.put("operadorRelacional", operadorRelacional);
		variables.put("codigo", codigo);
		variables.put("ts", ts);
		variables.put("listaID", listaID);
		variables.put("pilhaDeTipos", pilhaDeTipos);
		variables.put("pilhaDeRotulos", pilhaDeRotulos);
		variables.put("ctLabel", ctLabel);
	}
	
	public Object getVariable(String key) {
		return variables.get(key);
	}
}
