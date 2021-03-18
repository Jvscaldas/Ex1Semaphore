package view;

import java.util.concurrent.Semaphore;

import controller.ExSemaforo1;

public class MainEx1 {

	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);

		for (int idThread = 0; idThread < 21; idThread++) {
			Thread t = new ExSemaforo1(idThread, semaforo);
			t.start();
		}
	}

}
