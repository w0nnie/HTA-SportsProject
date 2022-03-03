package com.project.sports.task;
import java.util.HashMap;
import org.json.simple.JSONObject;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

/**
 * @class ExampleSend
 * @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
 */
public class SendSms{
    String api_key = "NCSHGGRTLNYPFPMW";
    String api_secret = "UQCQB9WKCRTH3YQMILDYAITZMOG9IVRU";
    Message coolsms = new Message(api_key, api_secret);

    public void sendSmsData(String toTel,String message) {
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", toTel);
        params.put("from", "01083110541");
        params.put("type", "SMS");
        params.put("text", message);
        params.put("app_version", "test app 1.2"); // application name and version

        try {
          JSONObject obj = (JSONObject) coolsms.send(params);
          System.out.println(obj.toString());
        } catch (CoolsmsException e) {
          System.out.println(e.getMessage());
          System.out.println(e.getCode());
        }
    }
}