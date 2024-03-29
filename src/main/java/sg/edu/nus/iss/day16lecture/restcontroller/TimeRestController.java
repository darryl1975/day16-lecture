package sg.edu.nus.iss.day16lecture.restcontroller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.Json;

import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/api/time", produces = MediaType.APPLICATION_JSON_VALUE)
public class TimeRestController {

    @GetMapping("")
    public ResponseEntity<String> getTimeAsJson() throws ParseException {
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        String currDate = sdf.format(currentDate);

        JsonObject obj = Json.createObjectBuilder()
                .add("time", currDate)
                .build();

        return ResponseEntity.ok(obj.toString());
    }

    // payload string comes from the above API function
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> postTimeAsJsonString(@RequestBody String payload) {
        JsonReader jReader = Json.createReader(new StringReader(payload));
        JsonObject jObject = jReader.readObject();
        System.out.println("jObject payload: " + jObject.toString());

        JsonObject responsePayload = Json.createObjectBuilder()
                .add("time", jObject.get("time").toString())
                .add("status", "unchanged")
                .add("updatedBy", "Darryl")
                .build();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Darryl", (new Date()).toString());
        headers.add("POSTTIMEJSON", "Testing only");

        return new ResponseEntity<String>(responsePayload.toString(), headers, HttpStatus.ACCEPTED);
    }

}
