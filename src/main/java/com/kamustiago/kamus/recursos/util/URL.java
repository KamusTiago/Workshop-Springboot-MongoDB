package com.kamustiago.kamus.recursos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
	
	// CRIANDO METODO PARA TRATAR AS DATAS RECEBIDAS
	// CRIEI UMA DATA PADRAO CASO A CONVERSAO FALHE
	// PADRAO DE DATAS NO FORMATO DE Greenwich
	public static Date converterData(String textoData, Date valorPadrao) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return sdf.parse(textoData);
		} catch (ParseException e) {
			return valorPadrao;
		}
		
	}
}
