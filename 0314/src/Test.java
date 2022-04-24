/* Java 1.8 샘플 코드 */

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader rd = null;
		String line;
		HttpURLConnection conn = null;

		String[] arr = new String[277];

		BufferedReader reader = new BufferedReader(new FileReader("/Users/kit938639/Documents/DB/code.txt"));
		String str;
		int idx=0;
		while ((str = reader.readLine()) != null) {
			int tmp = (int)(Long.parseLong(str) / 100000);
//			int tmp = Integer.parseInt(str) / 100000;
			System.out.println(str+", "+tmp);
			arr[idx++] = Integer.toString(tmp);
		}
		reader.close();

		for (int i = 0; i < arr.length; i++) {

			StringBuilder urlBuilder = new StringBuilder(
					"http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev"); /*
																																 * URL
																																 */
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
					+ "=k14wUOt7Lbggkj0jwGMNOvVxBiYfEM9jijPYarQyOPdqRTLw0KYDeO%2FZ0uqhRzKbKBejCj2RPVm6p03qC0AB0w%3D%3D"); /*
																															 * Service
																															 * Key
																															 */
			urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("10", "UTF-8")); /* 한 페이지 결과 수 */
			urlBuilder.append(
					"&" + URLEncoder.encode("LAWD_CD", "UTF-8") + "=" + URLEncoder.encode(arr[i], "UTF-8")); /* 지역코드 */
			urlBuilder.append("&" + URLEncoder.encode("DEAL_YMD", "UTF-8") + "="
					+ URLEncoder.encode("202101", "UTF-8")); /* 계약월 */
			URL url = new URL(urlBuilder.toString());

			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			System.out.println("Response code: " + conn.getResponseCode());
//        BufferedReader rd;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			while ((line = rd.readLine()) != null) {
				sb.append(line);
			}

		}
		rd.close();
		conn.disconnect();
		System.out.println(sb.toString());
	}
}