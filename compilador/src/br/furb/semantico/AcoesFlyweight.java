package br.furb.semantico;

import java.util.HashMap;
import java.util.Map;

public class AcoesFlyweight {
	
	private static Map<String, Acao> acoes  = new HashMap<String, Acao>();
	
	static {
		acoes.put("1", new Acao1());
		acoes.put("2", new Acao2());
		acoes.put("3", new Acao3());
		acoes.put("4", new Acao4());
		acoes.put("5", new Acao5());
		acoes.put("6", new Acao6());
		acoes.put("7", new Acao7());
		acoes.put("8", new Acao8());
		acoes.put("9", new Acao9());
		acoes.put("10", new Acao10());
		acoes.put("11", new Acao11());
		acoes.put("12", new Acao12());
		acoes.put("13", new Acao13());
		acoes.put("14", new Acao14());
		acoes.put("15", new Acao15());
		acoes.put("16", new Acao16());
		acoes.put("17", new Acao17());
		acoes.put("18", new Acao18());
		acoes.put("19", new Acao19());
		acoes.put("20", new Acao20());
		acoes.put("21", new Acao21());
		acoes.put("30", new Acao30());
		acoes.put("31", new Acao31());
		acoes.put("32", new Acao32());
		acoes.put("33", new Acao33());
		acoes.put("34", new Acao34());
		acoes.put("35", new Acao35());
		acoes.put("36", new Acao36());
		acoes.put("37", new Acao37());
		acoes.put("38", new Acao38());
		acoes.put("39", new Acao39());
		acoes.put("40", new Acao40());
		acoes.put("41", new Acao41());
		acoes.put("42", new Acao42());
	}
	
	public Acao get(String numero) {
		return acoes.get(numero);
	}

}
