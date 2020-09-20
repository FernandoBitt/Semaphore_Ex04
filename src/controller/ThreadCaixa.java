package controller;

import java.util.concurrent.Semaphore;

public class ThreadCaixa extends Thread{

	private int op;
	private int cod;
	private int saldo;
	private int valor;
	Semaphore semaforo1, semaforo2;
	
	public ThreadCaixa(int op, int cod, int saldo, int valor, Semaphore semaforo1,Semaphore semaforo2) {
		this.op=op;
		this.cod=cod;
		this.saldo=saldo;
		this.valor=valor;
		this.semaforo1=semaforo1;
		this.semaforo2=semaforo2;
	}
	
	@Override
	public void run() {
		if (op==1) {
			try {
				semaforo1.acquire();
				deposito();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo1.release();
			}
			
		}else {
			try {
				semaforo2.acquire();
				saque();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo2.release();
			}
			
		}	
		
	}

	private void deposito() {
		try {
			sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		saldo+=valor;
		System.out.println("Deposito -> Código: "+cod+", valor depositado: " + valor + ", saldo: " + saldo);
	}

	private void saque() {
		try {
			sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		saldo-=valor;
		System.out.println("Saque -> Código: "+cod+", valor sacado: " + valor + ", saldo: " + saldo);
	}
}
