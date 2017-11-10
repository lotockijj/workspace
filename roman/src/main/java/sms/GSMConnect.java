package sms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import gnu.io.CommPortIdentifier;
import gnu.io.CommPortOwnershipListener;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

public class GSMConnect implements SerialPortEventListener, CommPortOwnershipListener {

	private static String comPort = "COM6"; // This COM Port must be connect with GSM Modem or your mobile phone
	@SuppressWarnings("unused")
	private String messageString = "";
	private CommPortIdentifier portId = null;
	@SuppressWarnings("rawtypes")
	private Enumeration portList;
	private InputStream inputStream = null;
	private OutputStream outputStream = null;
	private SerialPort serialPort;
	String readBufferTrial = "";
	
	/** Creates a new instance of GSMConnect */
	public GSMConnect(String comm) {
		comPort = comm;
	}

	public boolean init() {
		portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portId.getName().equals(comPort)) {
					System.out.println("Got PortName");
					return true;
				}
			}
		}
		return false;
	}

	public void checkStatus() {
		send("AT+CREG?\r\n");
	}

	public void send(String cmd) {
		try {
			outputStream.write(cmd.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMessage(String phoneNumber, String message) {
		char quotes ='"';
		send("AT+CMGS="+quotes + phoneNumber +quotes+ "\r\n");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//   send("AT+CMGS=\""+ phoneNumber +"\"\r\n");
		send(message + '\032');
		System.out.println("Message Sent");
	}

	public void hangup() {
		send("ATH\r\n");
	}

	public void connect() throws NullPointerException {
		if (portId != null) {
			try {
				portId.addPortOwnershipListener(this);
				serialPort = (SerialPort) portId.open("MobileGateWay", 2000);
				serialPort.setSerialPortParams(115200,SerialPort.DATABITS_8,SerialPort.STOPBITS_1,SerialPort.PARITY_NONE);
			} catch (PortInUseException | UnsupportedCommOperationException e) {
				e.printStackTrace();
			}

			try {
				inputStream = serialPort.getInputStream();
				outputStream = serialPort.getOutputStream();

			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				/** These are the events we want to know about*/
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				serialPort.notifyOnRingIndicator(true);
			} catch (TooManyListenersException e) {
				e.printStackTrace();
			}
			//Register to home network of sim card
			send("ATZ\r\n");
		} else {
			throw new NullPointerException("COM Port not found!!");
		}
	}

	public void serialEvent(SerialPortEvent serialPortEvent) {
		switch (serialPortEvent.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:     
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
		case SerialPortEvent.DATA_AVAILABLE:

			byte[] readBuffer = new byte[2048];
			try {
				while (inputStream.available() > 0) 
				{
					int numBytes = inputStream.read(readBuffer);

					System.out.print(numBytes);
					if((readBuffer.toString()).contains("RING")){
						System.out.println("Enter Inside if RING Loop");    
					}
				}
				System.out.print(new String(readBuffer));
			} catch (IOException e) {
			}
			break;
		}
	}
	public void outCommand(){
		System.out.print(readBufferTrial);
	}
	public void ownershipChange(int type) {
		switch (type) {
		case CommPortOwnershipListener.PORT_UNOWNED:
			System.out.println(portId.getName() + ": PORT_UNOWNED");
			break;
		case CommPortOwnershipListener.PORT_OWNED:
			System.out.println(portId.getName() + ": PORT_OWNED");
			break;
		case CommPortOwnershipListener.PORT_OWNERSHIP_REQUESTED:
			System.out.println(portId.getName() + ": PORT_INUSED");
			break;
		}

	}
	
	public void closePort(){
		serialPort.close(); 
	}

	public static void main(String args[]) {
		GSMConnect gsm = new GSMConnect(comPort);
		if (gsm.init()) {
			try {
				System.out.println("Initialization Success");
				gsm.connect();
				Thread.sleep(5000);
				gsm.checkStatus();
				Thread.sleep(5000);

				gsm.sendMessage("+380679538747", "Trial Success");

				Thread.sleep(1000);

				gsm.hangup();
				Thread.sleep(1000);
				gsm.closePort();
				gsm.outCommand();
				System.exit(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Can't init this card");
		}
	}

}