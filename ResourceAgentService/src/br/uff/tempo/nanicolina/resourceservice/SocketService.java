/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.uff.tempo.nanicolina.resourceservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import 	java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.uff.tempo.nanicolina.resources.Device;

/**
 *
 * @author Mareli
 */
public class SocketService {

    private static final int SERVER_PORT = 10006;
    //private static final String SERVER_IP = "192.168.1.111";
    private static final String SERVER_IP = "192.168.1.27";


    private Socket socket;
    private ServerSocket serv;
    private PrintWriter out;
    private BufferedReader in;
    
    
    public Device getDevice(String format)
    {
    	return Device.convert(format);
    }
    
    String format;
    public SocketService()
    {
    	format = "";
    }
    
    public SocketService(String serverIP, int serverPort)
    {
        try {
            socket = new Socket(serverIP, serverPort);
            //serv = new ServerSocket(serverPort);
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Conectado...");
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: "+serverIP);
            System.exit(1);
        } catch (IOException e) {
            System.out.println("No I/O");
            try {
                //System.exit(1);
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
            }

            listenSocket(serverIP,serverPort);
        }
    }

    public SocketService(int serverPort)
    {
        try {
            //socket = new Socket(SERVER_IP, SERVER_PORT);
            serv = new ServerSocket(serverPort);
            System.out.println("Conectado...");
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void listenSocket(String serverIP, int serverPort)
    {    //Create socket connection
        try{
            socket = new Socket(serverIP, serverPort);
            out = new PrintWriter(socket.getOutputStream(),true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Conectado...");
        } catch (UnknownHostException e) {
            System.out.println("Unknown host: "+serverIP);
            System.exit(1);
        } catch  (IOException e) {
            System.out.println("No I/O");
            try {
                //System.exit(1);
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
            }

            listenSocket(serverIP,serverPort);
        }
    }

    public void send(String status)
    {
        try {
            DatagramSocket s = new DatagramSocket();
            InetAddress local = InetAddress.getByName(SERVER_IP);
            int msg_length = status.length();
            byte[] message = status.getBytes();
            DatagramPacket p = new DatagramPacket(message, msg_length, local, SERVER_PORT);
            s.send(p);
        } catch (SocketException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String receive()
    {
        String text = "";
        try {
            byte[] message = new byte[1500];
            DatagramPacket p = new DatagramPacket(message, message.length);
            DatagramSocket s = new DatagramSocket(SERVER_PORT);
            s.receive(p);
            text = new String(message, 0, p.getLength());
        } catch (SocketException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return text;
    }

    public void sendStatus(String status)
    {
        //Send data over socket
        String text = status;
        out.println(text);
        //Receive text from server
        /*try{
            String line = in.readLine();
            System.out.println("Text received: " + line);
        } catch (IOException e){
            System.out.println("Read failed");
            System.exit(1);
        }*/
    }

    public String receiveStatus()
    {
        try {
            System.out.println("Aguardando...");
            socket = serv.accept();
            System.out.println("Enviando..");
            //Cria um BufferedReader para o canal da stream de entrada de dados do socket s
            BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //Aguarda por algum dado e imprime a linha recebida quando recebe
            return entrada.readLine();
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void closeService()
    {
        try {
            socket.close();
            serv.close();
        } catch (IOException ex) {
            Logger.getLogger(SocketService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
