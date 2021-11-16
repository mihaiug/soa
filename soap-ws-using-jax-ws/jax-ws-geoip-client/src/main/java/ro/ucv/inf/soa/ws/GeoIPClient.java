package ro.ucv.inf.soa.ws;

import java.net.URL;

import javax.xml.namespace.QName;

import ro.ucv.inf.soa.ws.geoip.GeoIPService;
import ro.ucv.inf.soa.ws.geoip.GeoIPServiceSoap;

public class GeoIPClient {
  public static void main(String[] args) {

    try {

      URL url = new URL("http://wsgeoip.lavasoft.com/ipservice.asmx?WSDL");

      QName qName = new QName("http://lavasoft.com/", "GeoIPService");

      GeoIPService service = new GeoIPService(url, qName);
      GeoIPServiceSoap geoIPServiceSoap = service.getGeoIPServiceSoap();

      // Invoke 'getIpLocation()' remote service operation.
      String ip = "193.231.40.254";
      System.out.println("Obtain location for: " + ip);
      String ipLocation = geoIPServiceSoap.getIpLocation(ip);
      System.out.println(ipLocation);

      // Invoke 'getCountryNameByISO2()' remote service operation.
      String countryISO2 = "RO";
      System.out.println("Obtain country full name for: " + countryISO2);
      String countryName = geoIPServiceSoap.getCountryNameByISO2(countryISO2);
      System.out.println(countryName);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
