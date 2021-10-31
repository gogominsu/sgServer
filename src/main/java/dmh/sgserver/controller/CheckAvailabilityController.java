package dmh.sgserver.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Controller
public class CheckAvailabilityController {

    @GetMapping("/machine/availability")
    public String isAvailable(Model model)  {
        HashMap<String, Boolean> machineData = getMachineData();
        model.addAttribute("machineData",machineData);
        return "machineList";
    }

    HashMap<String, Boolean> getMachineData() {

        HashMap<String, Boolean> machineData = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try{
            HttpGet request = new HttpGet("http://127.0.0.1:5000/flask/machine");
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity);
            ObjectMapper mapper = new ObjectMapper();
            machineData = new HashMap<>(mapper.readValue(result, Map.class));
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return machineData;
    }
}
