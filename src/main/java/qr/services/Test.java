package qr.services;

import qr.entities.User;

import java.util.HashMap;
import java.util.Map;

public class Test {

    // 1 - crear un metodo que reciba dos paramentros, un nombre y un apellido de tipo string y retorne el nombre y el apellido concatenados con un espacio entre los dos

//2 - crear un metodo que reciba el valor del metodo anterior y un numero y que retorne el valor anterior mas el numero

    //4 crear metodo que que no reciba parametros y retorne un objeto de tipo User con valores dummy

    //5 crear un metodo que llame a todos los metodos anteriores e imprima sus resultados



    public static String fullName(String name,String lastname){

        String concat = name + " " + lastname;

        return concat;

    }

    public static String getFull(String fullName, Integer number) {

        String getAll = fullName + " " + number;

        return getAll;


    }

    public static User ejercicioCuatro(){

        User user = new User();
        user.setName(user.getName());
        user.setLastname(user.getLastname());

        return user;

    }

    public static void callAll() {

    String fullName = fullName("Sofia", "Arevalo");
        System.out.println(fullName);

    String getFull = getFull(fullName,10);
        System.out.println(getFull);

    User ejercicioCuatro = ejercicioCuatro();
        System.out.println(ejercicioCuatro);


    }

    public static void main(String[] args) {

        testMap();

    }

    /*public static void main(String[] args) {
        Integer total = 1;

        for (int i = 0; i <= 20; i++) {
            total = total + (total * i);
            System.out.println(total);

        }

    }*/

    public static void testMap() {
        Map<String, Integer> edades = new HashMap<>(); // un mapa vacio de llave String y valor Integer

        edades.put("sofia", 33);
        edades.put("luna", 7);
        edades.put("maite", 4);
        edades.put("david", 34);

        System.out.println("la edad de sofia es: " + edades.get("sofia"));

        edades.forEach((key, value) -> {
            System.out.println("key: " + key + " valor:" + value);

        });




    }

}
