/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activity1;

import java.time.Instant;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import net.sf.json.JSONObject;

/**
 * REST Web Service
 *
 * @author 1895268
 */
@Path("mobile")
public class ClassActivity {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ClassActivity
     */
    public ClassActivity() {
    }
    
    @GET
    @Path("shapesList")
    @Produces(MediaType.TEXT_PLAIN)
    public String getText() {
        return "[{\"name\":\"Circle\",\"NumberofParam\":1},\n" +
"{\"name\" : \"Square\",\"NumberofParam\":1},\n" +
"{\"name\":\"Rectangle\", \"NumberofParam\":2},\n" +
"{\"name\":\"Triangle\", \"NumberofParam\":2},\n" +
"{\"name\":\"Ellipse\", \"NumberofParam\":2},\n" +
"{\"name\":\"Sector\", \"NumberofParam\":2},\n" +
"{\"name\":\"Trapezoid\",\"NumberofParam\":3},\n";
    }

  
    
    @GET
    @Path("shapeOne&{value1}&{value2}")
    @Produces(MediaType.TEXT_PLAIN)
    public String shapeTwo(@PathParam("value1") String v1,
            @PathParam("value2") double v2) {
        
        double area=0.0;
        String status;
        Instant instant = Instant.now();
        long time = instant.getEpochSecond();
        JSONObject mainobject=new JSONObject();
        
        if(v1.equalsIgnoreCase("Circle")){
            area=(double)3.14*v2*v2;
            status="ok";

            mainobject.accumulate("Status :", status);
            mainobject.accumulate("Timestamp :", time);
            mainobject.accumulate("Shape", v1);
            mainobject.accumulate("radius", v2);
            mainobject.accumulate("area", area);
         }
        else if(v1.equalsIgnoreCase("square")){
            area=(double)v2*v2;
            status="ok";

            mainobject.accumulate("Status :", status);
            mainobject.accumulate("Timestamp :", time);
            mainobject.accumulate("Shape", v1);
            mainobject.accumulate("side", v2);
            mainobject.accumulate("area", area);
        }
        else{
            status="Error";
            mainobject.accumulate("Status :", status);
            mainobject.accumulate("Timestamp :", time);
            mainobject.accumulate("Shape", v1);
            mainobject.accumulate("Message", "Not the good shape");
        }
         return mainobject.toString();
    }
    
    
    @GET
    @Path("shapeTwo&{value1}&{value2}&{value3}")
    @Produces(MediaType.TEXT_PLAIN)
    public String shapeTwo(@PathParam("value1") String v1,
            @PathParam("value2") double v2,
            @PathParam("value3") double v3) {
        
        double result=0.0;
        String status;
        JSONObject mainObject= new JSONObject();
        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();
        if(v1.equalsIgnoreCase("Triangle")){
            result=(double)0.5*v2*v3;
            status="OK";
            

            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Triangle");
            mainObject.accumulate("Base", v2);
            mainObject.accumulate("Vertical Height", v3);
            mainObject.accumulate("Area", result);
        }
        else if (v1.equalsIgnoreCase("Rectangle")){
            result=(double)v2*v3;
            status="OK";
            
            

            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Rectangle");
            mainObject.accumulate("Width", v2);
            mainObject.accumulate("Height", v3);
            mainObject.accumulate("Area", result);
        }
        else if (v1.equalsIgnoreCase("Parallelogram")){
            result=(double)v2*v3;
            status="OK";
            

            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Parallelogram");
            mainObject.accumulate("Base", v2);
            mainObject.accumulate("Vertical Height", v3);
            mainObject.accumulate("Area", result);
        }
        else if (v1.equalsIgnoreCase("Ellipse")){
            result=(double)3.14*v2*v3;
            status="OK";
            

            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Ellipse");
            mainObject.accumulate("a Axis", v2);
            mainObject.accumulate("b Axis", v3);
            mainObject.accumulate("Area", result);
        }
        else
        {
            status="Error";
            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", v1);
            mainObject.accumulate("Message","Not the good Shape");
            
        }
            
            
                
                
        return mainObject.toString();
        //TODO return proper representation object
        
    }
    
    
    @GET
    @Path("shapeThree&{value1}&{value2}&{value3}&{value4}")
    @Produces(MediaType.TEXT_PLAIN)
    public String shapeThree(@PathParam("value1") String v1,
            @PathParam("value2") double v2,
            @PathParam("value3") double v3,
            @PathParam("value4") double v4) {
        double result=0.0;
        String status;
        JSONObject mainObject= new JSONObject();
        Instant instant = Instant.now();
        long timeStampSeconds = instant.getEpochSecond();
        if(v1.equalsIgnoreCase("Trapezoid")){
            result=(double)0.5*(v2+v3)*v4;
            status="OK";
            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Trapezoid");
            mainObject.accumulate("Base1", v2);
            mainObject.accumulate("Base2", v3);
            mainObject.accumulate("Height", v4);
            mainObject.accumulate("Area", result);
        }
        else{
        status="Error";
            mainObject.accumulate("Status", status);
            mainObject.accumulate("Timestamp",timeStampSeconds );
            mainObject.accumulate("shape", "Trapezoid");
            mainObject.accumulate("Base1", v2);
            mainObject.accumulate("Base2", v3);
            mainObject.accumulate("Height", v4);
            mainObject.accumulate("Area", result);
        }
         
        return mainObject.toString();
        //TODO return proper representation object
        
    }
    
    
    
  
}
