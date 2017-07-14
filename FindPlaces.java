package jh.test;

import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Map;

import java.util.TreeMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import javax.xml.bind.JAXBContext;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.glassfish.jersey.client.ClientConfig;

public class FindPlaces {
    public FindPlaces() {
        super();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findTown());
        // testing();
    }
    
    public static String findTown()  {
        Client client = ClientBuilder.newClient(new ClientConfig()).register(GeoNames.class);
        WebTarget target = client.target("http://api.geonames.org").path("findNearbyPlaceName");
        
        Map<String, String> query = new TreeMap<String, String>();
        Form form = new Form();
        form.param("lat", "47.3");
        form.param("lng", "9.3");
        form.param("username", "john_hamer");
        
        
            /* GeoNames bean = 
            target.request(MediaType.APPLICATION_XML_TYPE)
            .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),
                  GeoNames.class); */
        Invocation.Builder invoker = target.request(MediaType.APPLICATION_XML_TYPE);
        invoker.buildPost(Entity.form(form));
        Response response = null;  StringBuffer place;
        try {
            response =  invoker.post(Entity.form(form));
        } catch (Exception e ) {
            System.out.println(e.toString());
        }
        try {
            //String theThing = response.readEntity(String.class);
            //System.out.println(theThing);
            GeoNames here = (GeoNames) response.readEntity(GeoNames.class);
            System.out.println("Array size = " + here.getGeonames().size());
            /* InputStream in = response.readEntity(InputStream.class);
            testing(in);
            byte[] buffer = new byte[1024];
            int n = 0;
            while (( n = in.read(buffer)) != -1 ) {
                System.out.println(new String(buffer));    
            }
            
            // place = response.readEntity(StringBuffer.class);
            
            in.close(); */
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    
        return "success";
    }       
    
    public static boolean testing(InputStream testPlaces ) { 
       /*  GeoName place1 = new GeoName();
        GeoName place2 = new GeoName();
        
        place1.setToponymName("Venice");
        place1.setName("Venice");
        place1.setLat(new BigDecimal(9.3));
        place1.setLng(new BigDecimal(45.3));
        place1.setCountryName("Italy");
        place1.setCountryCode("IT");
        
        place2.setToponymName("Venice");
        place2.setName("Venice");
        place2.setLat(new BigDecimal(9.3));
        place2.setLng(new BigDecimal(45.3));
        place2.setCountryName("Italy");
        place2.setCountryCode("IT");
        */
        GeoNames places = new GeoNames();
        /* ArrayList<GeoName> thePlaces = new ArrayList<GeoName>();
        thePlaces.add(place1);
        thePlaces.add(place2);
        places.setGeonames(thePlaces);
    */
        
        JAXBContext jcontext;
        try {
            jcontext = JAXBContext.newInstance(GeoNames.class);
        
            Unmarshaller unmarshaller = jcontext.createUnmarshaller();
            // unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            places = (GeoNames)unmarshaller.unmarshal(testPlaces);  
            
        } catch (JAXBException e) {
            System.out.println("JAXB Exception: " + e.toString());
        } /* catch (IOException e) {
            System.out.println("FileWriter Exception: " + e.toString());
        }  */


        return true;
    }
        
}