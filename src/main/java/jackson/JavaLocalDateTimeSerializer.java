/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author matte
 */
public class JavaLocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        
       String localDateAsString = "";
       int year = localDateTime.getYear();
       int month = localDateTime.getMonthValue();
       int day = localDateTime.getDayOfMonth();
       
       int hour = localDateTime.getHour();
       int minute = localDateTime.getMinute();
       
       localDateAsString = year + "-" + month + "-" + day + " " + hour + ":" + minute;
       
       jsonGenerator.writeString(localDateAsString);
       
    }
}