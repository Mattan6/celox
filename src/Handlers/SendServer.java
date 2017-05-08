
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
			e.printStackTrace();
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
			System.out.println("couldent write to socket -- insert" + e.getStackTrace() );
			e.printStackTrace();
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
			System.out.println("couldent write to socket -- sort" + e.getStackTrace());
			e.printStackTrace();
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
			System.out.println("couldent write to socket -- getGrowers" + e.getStackTrace());
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}


	public void updateGrower (Growers grower){
		Gson gson = new Gson();
		String data = gson.toJson(grower);
		
		JsonParser parser = new JsonParser();
		JsonObject json = (JsonObject)parser.parse(data);
		json.addProperty("action", "update");
		json.addProperty("collection", "growers");
		json.addProperty("machine_id", "Software");
		json.addProperty("what", "grower");
		String query = json.toString();
		
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
			System.out.println("couldnt write to socket -- updateGrower");
			e.printStackTrace();
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
			System.out.println("couldnt write to socket -- updatePlot");
			e.printStackTrace();
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
			System.out.println("couldnt write to socket -- addPlotToGrower");
			e.printStackTrace();
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
			System.out.println("couldent write to socket  --- getUsers" + e.getStackTrace());
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}


	public List<Sorts> getSorts() {
		List<String> sorts = new ArrayList<String>();
		List<Sorts> toReturn = new ArrayList<>();
		Gson gson = new Gson();
		String query = "{ 'machine_id' : 'Software' , 'action' : 'query' , 'collection' : 'userSortInfo' }";
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			sorts = (List<String>) in.readObject();
			for (String j: sorts){
				toReturn.add( gson.fromJson(j, Sorts.class));
			}
			out.close();
			in.close();
			return toReturn;
		}catch(IOException e){
			System.out.println("couldent write to socket --- getSorts"+ e.getStackTrace());
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}


	public List<ProductList> getPackets(String startDate, String endDate) {
		List<String> packets = new ArrayList<String>();
		List<ProductList> toReturn = new ArrayList<>();
		Gson gson = new Gson();
		String query = "{ 'machine_id' : 'Software' , 'action' : 'query', 'what':'packet' , 'collection' : 'sortsTry', 'startTime': ' "
		+ startDate + "', 'endTime' : '" + endDate +"'"+"}";
		System.out.println(query);
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			packets = (List<String>) in.readObject();
			for (String j: packets){
				toReturn.add( gson.fromJson(j, ProductList.class));
			}
			out.close();
			in.close();
			return toReturn;
		}catch(IOException e){
			System.out.println("couldent write to socket -- getPackets");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}


	public List<ProgramPacket> getProg( String startDate, String endDate) {
		List<String> program = new ArrayList<String>();
		List<ProgramPacket> toReturn = new ArrayList<>();
		Gson gson = new Gson();
		String query = "{ 'machine_id' : 'Software' , 'action' : 'query' , 'what':'program' , 'collection' : 'sortsTry', 'startTime': ' "
		+ startDate+ "', 'endTime' : '" + endDate +"'"+"}";
		try{

			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(query);
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			program = (List<String>) in.readObject();
			for (String j: program){
				toReturn.add( gson.fromJson(j, ProgramPacket.class));
			}
			out.close();
			in.close();
			return toReturn;
		}catch(IOException e){
			System.out.println("couldent write to socket -- getProg ");
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			System.out.println("reciving from server come up with a problem! ");
			e.printStackTrace();
		}
		return toReturn;
	}

}


