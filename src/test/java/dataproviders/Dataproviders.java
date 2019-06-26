package dataproviders;

import java.io.FileReader;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import entidades.TestData;

public class Dataproviders {
  @DataProvider
  public static Object[][] datos1() {
    try {

      JsonElement jsonData =
          new JsonParser().parse(new FileReader("src/test/resources/datos1.json"));
      JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
      List<TestData> testData =
          new Gson().fromJson(dataSet, new TypeToken<List<TestData>>() {}.getType());
      Object[][] returnValue = new Object[testData.size()][1];
      int index = 0;
      for (Object[] each : returnValue) {
        each[0] = testData.get(index++);
      }
      return returnValue;
    } catch (Exception e) {
      System.out.println("Error leyendo archivo json!");
      e.printStackTrace();
      return null;
    }
  }
}
