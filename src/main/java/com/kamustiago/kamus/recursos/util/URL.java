package com.kamustiago.kamus.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {

	// METODO PARA DECODIFICAR A URL E TRANSFORMAR PARA STRING, UTILIZO O PADRAO DE DECODIFICACAO UTF-8
	// CASO OCORRA ALGUM ERRO DE CODIFICACAO, EU RETORNAREI A STRING VAZIA
	public static String decodificarParam(String texto) {
		try {
			return URLDecoder.decode(texto, "UTF-8");
		}
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
}
