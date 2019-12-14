package br.furb.semantico;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.furb.common.Constants;
import br.furb.common.Token;
import br.furb.utils.Messages;
import br.furb.utils.StringManipulationUtil;
import br.furb.utils.Types64;

public class Semantico implements Constants {

	private String tipo = "";
	private String operadorRelacional = "";
	private List<String> codigo = new ArrayList<String>();
	private Map<String, String> ts = new HashMap<String, String>();
	private List<String> listaID = new ArrayList<String>();
	private Deque<String> pilhaDeTipos = new ArrayDeque<String>();
	private Deque<String> pilhaDeRotulos = new ArrayDeque<String>();
	private int ctLabel = 0;



	public void executeAction(int action, Token token, String input) throws SemanticError {
		
		AcoesFlyweight acoesFlyweight = new AcoesFlyweight();
		Acao acao = acoesFlyweight.get(Integer.toString(action));
		SemanticVariables variables = acao.execute(tipo,
					operadorRelacional, 
					codigo, 
					ts,
					listaID,
					pilhaDeTipos,
					pilhaDeRotulos,
					ctLabel,
					token,
					input);
		
		setVariables(variables);
	}
	
	@SuppressWarnings("unchecked")
	public void setVariables(SemanticVariables variables) {
		this.tipo = (String) variables.getVariable("tipo");
		this.operadorRelacional = (String) variables.getVariable("operadorRelacional");
		this.codigo = (List<String>) variables.getVariable("codigo");
		this.ts = (Map<String, String>) variables.getVariable("ts");
		this.listaID = (List<String>) variables.getVariable("listaID");
		this.pilhaDeTipos = (Deque<String>) variables.getVariable("pilhaDeTipos");
		this.pilhaDeRotulos = (Deque<String>) variables.getVariable("pilhaDeRotulos");
		this.ctLabel = (int) variables.getVariable("ctLabel");
	}

	public String retornaCodigoFormado() {
		StringBuilder sb = new StringBuilder();
		for (String linha : codigo) {
			sb.append(linha);
			sb.append("\n");
		}
		return sb.toString();
	}
}
