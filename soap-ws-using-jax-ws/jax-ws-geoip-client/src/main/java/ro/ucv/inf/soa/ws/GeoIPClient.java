package ro.ucv.inf.soa.ws;

import java.net.URL;

import javax.xml.namespace.QName;

import ro.ucv.inf.soa.ws.geoip.GeoIP;
import ro.ucv.inf.soa.ws.geoip.GeoIPService;
import ro.ucv.inf.soa.ws.geoip.GeoIPServiceSoap;

public class GeoIPClient {
	public static void main(String[] args) {

		try {

			URL url = new URL("http://www.webservicex.net/geoipservice.asmx?WSDL");

			QName qName = new QName("http://www.webservicex.net/", "GeoIPService");

			GeoIPService service = new GeoIPService(url, qName);
			GeoIPServiceSoap geoIPServiceSoap = service.getGeoIPServiceSoap();
			GeoIP geoIP = geoIPServiceSoap.getGeoIP("193.231.40.254");
			System.out.println("IP:\t\t" + geoIP.getIP());
			System.out.println("Country code: \t" + geoIP.getCountryCode());
			System.out.println("Country name: \t" + geoIP.getCountryName());
			geoIP = geoIPServiceSoap.getGeoIPContext();
			System.out.println("IP:\t\t" + geoIP.getIP());
			System.out.println("Country code: \t" + geoIP.getCountryCode());
			System.out.println("Country name: \t" + geoIP.getCountryName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
