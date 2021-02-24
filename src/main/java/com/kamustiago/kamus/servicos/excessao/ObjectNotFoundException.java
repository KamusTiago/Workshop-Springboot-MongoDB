package com.kamustiago.kamus.servicos.excessao;



//a excessao runtimeexception faz com que o compilador nao exija que eu a trate
public class ObjectNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String msg) {
		super(msg);		
	}
}
