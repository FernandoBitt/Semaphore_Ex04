package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCaixa;

public class Main {

	public static void main(String[] args) {
		
		int saldo=1000;
		Semaphore semaforo1 = new Semaphore(1);
		Semaphore semaforo2 = new Semaphore(1);

		for(int cod=0; cod<20; cod++) {
			int op = (int) (Math.random()+1.5);
			int valor = (int) ((Math.random()*901)+100);
			Thread tCaixa = new ThreadCaixa(op, cod, saldo, valor, semaforo1, semaforo2);
			tCaixa.start();
		}
	}

}
