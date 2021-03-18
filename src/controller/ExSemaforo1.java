package controller;

import java.util.concurrent.Semaphore;

public class ExSemaforo1 extends Thread {

	private int idThread, min, max;

	private Semaphore semaforo;

	public ExSemaforo1(int idThread, Semaphore semaforo) {
		this.idThread = idThread;
		this.min = 0;
		this.max = 0;
		this.semaforo = semaforo;
	}

	@Override
	public void run() {
		calc();

		try {
			semaforo.acquire();
			trbd();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}

	}

	private void calc() {
		if (this.idThread % 3 == 1) {
			this.min = 200;
			this.max = 1000;
			int tempoCalc = 0;
			tempoCalc = (int) (Math.random() * (max - min) + min);
			System.out.println("Resto 1 - Calculando...");
		}
		if (this.idThread % 3 == 2) {
			this.min = 500;
			this.max = 1500;
			int tempoCalc = 0;
			tempoCalc = (int) (Math.random() * (max - min) + min);
			System.out.println("Resto 2 - Calculando...");
		}
		if (this.idThread % 3 == 0) {
			this.min = 1000;
			this.max = 2000;
			int tempoCalc = 0;
			tempoCalc = (int) (Math.random() * (max - min) + min);
			System.out.println("Resto 0 - Calculando...");
		}
	}

	private void trbd() {
		if (this.idThread % 3 == 1) {
			int tempoTRBD = 1000;

			try {
				sleep(tempoTRBD);
				System.out.println("Resto 1 - Transação BD...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if (this.idThread % 3 == 2) {

			int tempoTRBD = 1500;

			try {
				sleep(tempoTRBD);
				System.out.println("Resto 2 - Transação BD...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

		if (this.idThread % 3 == 0) {

			int tempoTRBD = 1500;

			try {
				sleep(tempoTRBD);
				System.out.println("Resto 0 - Transação BD...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}