package com.kamustiago.kamus.recursos.excecao;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kamustiago.kamus.servicos.excessao.ObjectNotFoundException;

//anotacao para indicar que essa classe é responsavel por tratar possiveis erros nas requisicoes
@ControllerAdvice
public class RecurcoExcecaoManipulador {
	
	//quando estourar uma excessao objectnotfoundexception vou gerar um objeto standard error e retornar ele
	//utilizo o objeto httpServletRequest para objter o caminho http
	
	//anotacao padrao do framework para identificar que quando ocorrer a excessao, executar o meu tratamento
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		//httpstatus para buscar os tipos de status de error em URl
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		//status.value() para converter para numero inteiro
		StandardError error = new StandardError(
				System.currentTimeMillis(),
				status.value(),
				"Não encontrado", 
				e.getMessage(), 
				request.getRequestURI());
		
		//retorna .status() para controlar manualmente qual o codigo de status que minha requisicao vai retornar
		return ResponseEntity.status(status).body(error);
		
	}
	
	
	

}
