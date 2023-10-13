package org.example.serializacion.model;

import com.google.gson.Gson;

import java.io.*;

public class SerializationExercises {
    /*
        Should define the class for the concepts Movie, Theater and Session.
        A session is a play of movie in a theater.
        Create 2 instances of each class and relate among them.
        Serialize to Json all objects and save then in different files.
     */
    public static class Exercise1 {
        public static void main(String[] args) {
            Theater theater1 = new Theater("Los Alisios", "Tamaraceite");
            Theater theater2 = new Theater("Cinema", "El Muelle");

            Movie movie1 = new Movie("Batman", 2);
            Movie movie2 = new Movie("Tiburon", 1);

            Session session1 = new Session(80,"14:00",movie1,theater1);
            Session session2 = new Session(80,"21:00",movie2,theater2);

// Serialization;
            Gson gson1 = new Gson();
            String json1 = gson1.toJson(session1);

            System.out.println(json1);

            Gson gson2 = new Gson();
            String json2 = gson2.toJson(session2);

            System.out.println(json2);

            try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.1.txt"))) {
                writer1.write(json1);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            try (BufferedWriter writer2 = new BufferedWriter(new FileWriter("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.2.txt"))) {
                writer2.write(json2);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    /*
        Deserialize the objects created in exercise 1.
        Now serialize them using ObjectOutputStream
     */
    public static class Exercise2 {
        public static void main(String[] args) {
            Theater theater1 = new Theater("Los Alisios", "Tamaraceite");
            Theater theater2 = new Theater("Cinema", "El Muelle");

            Movie movie1 = new Movie("Batman", 2);
            Movie movie2 = new Movie("Tiburon", 1);

            Session session1 = new Session(80,"14:00",movie1,theater1);
            Session session2 = new Session(80,"21:00",movie2,theater2);

            try {
                Gson newGson = new Gson();
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.1txt"));
                String sesionFile = reader.readLine();
                System.out.println(sesionFile);
                reader.close();

            } catch (Exception exception) {
                exception.printStackTrace();

            }

            try {
                Gson newGson = new Gson();
                BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.2txt"));
                String sesionFile2 = reader.readLine();
                System.out.println(sesionFile2);
                reader.close();

            } catch (Exception exception) {
                exception.printStackTrace();

            }

            try{
                ObjectOutputStream serialized_session = new ObjectOutputStream(new FileOutputStream("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.1txt"));
                serialized_session.writeObject(session1);
                serialized_session.close();

            }catch (Exception ex){
                ex.printStackTrace();
            }

            try{
                ObjectOutputStream serialized_session = new ObjectOutputStream(new FileOutputStream("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.2txt"));
                serialized_session.writeObject(session2);
                serialized_session.close();

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    /*
       Deserialize the objects from the binary files created in exercise 2.
    */
    public static class Exercise3 {
        public static void main(String[] args) {
            try {
                ObjectInputStream deserializedSession = new ObjectInputStream(new FileInputStream("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.1txt"));
                Session sessionDeserialized = (Session) deserializedSession.readObject();
                System.out.println(sessionDeserialized);
            } catch (IOException exc) {
                exc.printStackTrace();
            } catch (ClassNotFoundException exc) {
                throw new RuntimeException(exc);
            }

            try {
                ObjectInputStream deserializedSession = new ObjectInputStream(new FileInputStream("C:\\Users\\victo\\Documents\\DOCUMENTOS UNI\\CURSO2\\prueba1.2txt"));
                Session sessionDeserialized = (Session) deserializedSession.readObject();
                System.out.println(sessionDeserialized);
            } catch (IOException exc) {
                exc.printStackTrace();
            } catch (ClassNotFoundException exc) {
                throw new RuntimeException(exc);
            }
        }
    }
}
