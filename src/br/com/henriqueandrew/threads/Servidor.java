//Henrique Andrew da Silva
package br.com.henriqueandrew.threads;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
    
    private Socket socket;
    
    public Servidor(Socket conexao){
        this.socket = conexao;        
    }
    
    @Override
    public void run(){
        
        try{            
            DataInputStream entrada = new DataInputStream(socket.getInputStream());
            
            while(true){
            
            String nome = entrada.readUTF();
            String cpf = entrada.readUTF();
            String fone = entrada.readUTF();
            
            System.out.println("\n======LISTA DE CONTATOS======\n\n");
            System.out.println("Nome: " + nome + "\nCPF: " + cpf + "\nFone: " + fone);
            this.socket.close();  
            }
                      
            
        }
        
        catch(Exception e){
            e.printStackTrace();            
        }
        
    }
    
    public static void main(String[] args){
        
        try{
            ServerSocket server = new ServerSocket(30000);  
            
            while(true){
                Socket conexao = server.accept();
                Servidor sThread = new Servidor(conexao);
                System.out.println("Nova conexão foi realizada...");
                sThread.start();
            }
            
        }
        
        catch(Exception e){
            
        }
            
    }
    
}
    

