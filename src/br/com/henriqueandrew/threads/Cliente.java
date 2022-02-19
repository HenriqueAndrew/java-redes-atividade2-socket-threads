//Henrique Andrew da Silva

package br.com.henriqueandrew.threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Cliente {
    
    private static Socket socket;
    private static DataOutputStream saida;
    
    public static void main(String[]args){
        
        try{
            socket = new Socket("127.0.0.1", 30000);            
            saida = new DataOutputStream(socket.getOutputStream());
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("DIGITE OS DADOS PARA ADICIONAR UMA NOVA PESSOA À LISTA DE CONTATOS\n");
            System.out.println("PARA ENCERRAR O SISTEMA DIGITE 'SAIR'\n");
            
            while(true){
            System.out.println("Informe o nome do contato: ");
            String nome = buf.readLine();
            if(nome.equalsIgnoreCase("sair"))
                break;
            saida.writeUTF(nome);
            System.out.println("Informe o CPF do contato: ");
            String cpf = buf.readLine();
            saida.writeUTF(cpf);
            System.out.println("Informe o Telefone do contato: ");
            String fone = buf.readLine();
            saida.writeUTF(fone);
            }
            
            socket.close();
        }
        
        catch(Exception e){
            
        }
        
    }
    
}
