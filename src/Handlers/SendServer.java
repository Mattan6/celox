
package Handlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Classes.*;


public class SendServer {


	private static Socket socket;
	private static String serverIP = "127.0.0.1";
	private static int serverPort = 9191;
	private DataOutputStream out;

	public SendServer(){
		try{
			socket = new Socket(serverIP, serverPort);
		}catch(IOException e){
			System.out.println("couldent open connection");
		}
	}


	public boolean insert(Growers grower){
		Gson gson = new Gson();
		String data = gson.toJson(grower);
		
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject)parser.parse(data);
		json.addProperty("action", "insert");
		json.addProperty("collection", "userSortInfo");
		json.addProperty("machine_id", "Software");
		String newData = json.toString();

		try{
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(newData);
			DataInputStream in = new DataInputStream(socket.getInputStream());

			String ack = in.readUTF();
			if (ack.equals("A"))
				System.out.println("recived ack in insert method");

			in.close();
			out.close();
			return true;
		}catch(IOException e){
			System.out.println("couldent write to socket");
		}

		return false;
	}
	
	public boolean insert(Sorts sort){
		Gson gson = new Gson();
		String data = gson.toJson(sort);
		
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject)parser.parse(data);
		json.addProperty("action", "insert");
		json.addProperty("collection", "userSortInfo");
		json.addProperty("machine_id", "Software");
		String newData = json.toString();
		
		System.out.println(newData);
		
		try{
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(newData);
			DataInputStream in = new DataInputStream(socket.getInputStream());

			String ack = in.readUTF();
			if (ack.equals("A"))
				System.out.println("recived ack in insert method");

			in.close();
			out.close();
			return true;
		}catch(IOException e){
			System.out.println("couldent write to socket");
		}

		return false;
	}



	public List<Growers> getGrowers(){
		List<String> growers = new ArrayList();
		List<Growers> toReturn = new ArrayList<>();
		Gson gson = new Gson();
		String query = "{ 'machine_id' : 'Software' , 'action' : 'query' , 'collection' : 'growers' }";
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			growers = (List<String>) in.readObject();
			for (String j: growers){
				toReturn.add( gson.fromJson(j, Growers.class));
			}
			out.close();
			in.close();
			return toReturn;
		}catch(IOException e){
			System.out.println("couldent write to socket");
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}


	public void updateGrower (Growers grower){

		String query = "{ 'machine_id' : 'Software' , 'action' : 'update' , 'collection' : 'growers' , 'what' : 'grower' , 'gID' :" +"'" + grower.getgID() +"'" + 
				", 'gName' : " +"'"+ grower.getgName()+"'" + ", 'gAddress' : " +"'" + grower.getgAddress()+"'" + ", 'gPhone' : " +"'"+ grower.getgPhone()+"'" 
				+", 'plots' : " + "[" +""+ "]" + "}";
		System.out.println(query);
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			DataInputStream in = new DataInputStream(socket.getInputStream());

			String ack = in.readUTF();
			if (ack.equals("A"))
				System.out.println("recived ack in update grower method ");

			in.close();
			out.close();

		}catch(IOException e){
			System.out.println("couldnt write to socket");
		}
	}

	public void UpdatePlot(String gID, String originName, Plots p){

		String query = "{ 'machine_id' : 'Software' , 'action' : 'update' , 'collection' : 'growers' , 'what' : 'plotUpdate', 'origin' : '"+originName+"' , 'gID' :" +"'" + gID +"'" + 
				", 'pName' : " +"'"+ p.getpName()+"'" + ", 'pSize' : " +"'" + p.getpSize()+"'" + ", 'pSpec' : " +"'"+ p.getpSpec() +"'" 
				+ "}";
		System.out.println(query);
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			DataInputStream in = new DataInputStream(socket.getInputStream());

			String ack = in.readUTF();
			if (ack.equals("A"))
				System.out.println("recived ack in update plot method ");

			in.close();
			out.close();

		}catch(IOException e){
			System.out.println("couldnt write to socket");
		}
	}

	public boolean AddPlotToGrower (Plots p, String gID){

		String query = "{ 'machine_id' : 'Software' , 'action' : 'update' , 'collection' : 'growers' , 'what' : 'AddPlot' , 'gID' :" +"'"+ gID +"'," + 
				"'pName':'" + p.getpName() + "', 'pSize':'" + p.getpSize() + "', 'pSpec':'" + p.getpSpec() + "'"+"}";
		System.out.println(query);
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			DataInputStream in = new DataInputStream(socket.getInputStream());

			String ack = in.readUTF();
			if (ack.equals("A"))
				System.out.println("recived ack in add plot to grower method ");

			in.close();
			out.close();

		}catch(IOException e){
			System.out.println("couldnt write to socket");
			return false;
		}
		return true;
	}


	public List<Users> getUsers() {
		List<String> users = new ArrayList();
		List<Users> toReturn = new ArrayList<>();
		Gson gson = new Gson();
		String query = "{ 'machine_id' : 'Software' , 'action' : 'query' , 'collection' : 'users' }";
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			users = (List<String>) in.readObject();
			for (String j: users){
				toReturn.add( gson.fromJson(j, Users.class));
			}
			out.close();
			in.close();
			return toReturn;
		}catch(IOException e){
			System.out.println("couldent write to socket");
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}

}


