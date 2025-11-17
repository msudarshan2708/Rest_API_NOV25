package RestapiPractice;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class jsonpathclass {
	@Test
	public void jsonpathclassmethod() {
		String json = "[\r\n" + "  {\r\n" + "    \"id\": 182259,\r\n" + "    \"user_id\": 7583030,\r\n"
				+ "    \"title\": \"Crepusculum testimonium suasoria acies talio alter studio adflicto itaque.\",\r\n"
				+ "    \"body\": \"Depereo studio libero. Temporibus facere ascisco. Ullus temeritas succedo. Cetera ab adamo. Candidus desparatus volva. Coadunatio ventus adipisci. Possimus sint curia. Et unde sonitus. Casus tero certe. Armarium pax abscido. Cimentarius carbo surculus.\"\r\n"
				+ "  }\r\n" + "]";

		JsonPath jp = new JsonPath(json);
		String title = jp.getString("[0].title");
		System.out.println(title);
		String body = jp.getString("[0].body");
		System.out.println(body);
		System.out.println("********************************************************");

	}

	@Test(priority = 2)
	public void jsonpathclass2() {
		String Json1 = "{\r\n" + "    \"bookingid\": 3257,\r\n" + "    \"booking\": {\r\n"
				+ "        \"firstname\": \"Jim\",\r\n" + "        \"lastname\": \"Brown\",\r\n"
				+ "        \"totalprice\": 111,\r\n" + "        \"depositpaid\": true,\r\n"
				+ "        \"bookingdates\": {\r\n" + "            \"checkin\": \"2018-01-01\",\r\n"
				+ "            \"checkout\": \"2019-01-01\"\r\n" + "        },\r\n"
				+ "        \"additionalneeds\": \"Breakfast\"\r\n" + "    }\r\n" + "}";
		JsonPath jpp = new JsonPath(Json1);
		int Bookingid = jpp.getInt("bookingid");
		System.out.println("Bookingid is :  " + Bookingid);
		Object checkindates = jpp.get("booking.bookingdates.checkin");
		System.out.println(checkindates);

	}

}
