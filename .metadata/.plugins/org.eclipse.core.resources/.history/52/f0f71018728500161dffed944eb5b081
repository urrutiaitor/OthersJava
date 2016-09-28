package blancanieves;

import java.util.concurrent.Semaphore;

public class BuzonAsincrono {

	Object message[];
	
	Object sending;
	Object receiving;
	
	Semaphore sent;
	Semaphore received;
	
	int indiceEscritura;
	int indiceLectura;
	
	int limite;
	
	public BuzonAsincrono() {
		limite = 1;
		
		message = new Object[limite];
		message[0] = new Object();
		
		sending = new Object();
		receiving = new Object();
		
		sent = new Semaphore(0);
		received = new Semaphore(limite);
		
		indiceEscritura = 0;
		indiceLectura = 0;
	}
	
	public BuzonAsincrono(int cantidad) {
		limite = cantidad;
		
		message = new Object[cantidad];
		
		for (int i = 0; i < cantidad; i++) {
			message[i] = new Object();
		}
		
		sending = new Object();
		receiving = new Object();
		
		sent = new Semaphore(0);
		received = new Semaphore(limite);
	}
	
	public void send(Object message) {
		synchronized (sending) {
			try {
				received.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			this.message[indiceEscritura%limite] = message;
			indiceEscritura++;
			sent.release();
		}
	}
	
	public Object receive() {
		Object receivedMessage = null;
		
		synchronized (receiving) {
			try {
				sent.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			receivedMessage = this.message[indiceLectura%limite];
			indiceLectura++;
			received.release();
		}
		return receivedMessage;
	}
}
