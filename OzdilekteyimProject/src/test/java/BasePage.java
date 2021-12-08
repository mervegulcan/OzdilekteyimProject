import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import  org.openqa.selenium.*;
import java.util.List;
import java.util.Random;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofSeconds;


public class BasePage extends BaseTest{


    @Step("<wait> saniye bekle")
    public void waitForsecond(int wait) throws InterruptedException {
        Thread.sleep(1000*wait);
        logger.info(wait + "saniye bekledi !!!!");
        //System.out.println();

    }
    @Step("<selectorid> id'li elemente tıkla")
    public  void clickById(String selectorid){

        appiumDriver.findElement(By.id(selectorid)).click();

    }
    @Step("<selectorxpath> xpath'li elemente tıkla")
    public void clickByxpath(String selectorxpath){
        appiumDriver.findElement(By.xpath(selectorxpath)).click();

    }
    @Step("sayfayı scroll et")
    public  void scrollPage(){
        logger.info("Sayfa sonuna gidilir.");
                new TouchAction<>(appiumDriver).press(PointOption.point(1048, 2021))
                .waitAction(waitOptions(ofSeconds(3))).moveTo(PointOption.point(1064, 291))
                .release().perform();
        //System.out.println("sayfanın sonuna gidildi");
    }

  @Step("ürün seç")
  public void selectRandomElement(){
        logger.info("Rasgele ürün seçilir.");
     List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
     Random random = new Random();
     int randomInt = random.nextInt(elements.size());
     elements.get(randomInt).click();
  }

  @Step("<id> id'li alana <text> bilgisini gir")
  public void sendKeysbyid(String id, String text){
    logger.info("");
     appiumDriver.findElement(By.id(id)).sendKeys(text);
     System.out.println(text + "Değeri yazıldı !!!");
    }

    @Step("<key> id'li element <keyword> text değerini içerdiğni kontrol et")
    public void textContol(String key,String keyword){
        Assert.assertTrue("Beklenen değer karşılandı",appiumDriver.findElement(By.id(key)).getText().contains(keyword));

    }
    @Step("<key> ve <keyword>  değerine göre uygulamanın çalıştığı kontrol edilir")
    public  void openApp(String key,String keyword){
        String openAppCheck = appiumDriver.findElement(By.id(key)).getText();
        Assert.assertEquals("uygulama doğru açıldı",keyword,openAppCheck);
        logger.info("Özdilekteyim uygulaması doğru açıldı.");
    }
    @Step("<key> ve <keyword>  değerine göre alışveriş sayfasında olunduğu kontrol edilir")
    public  void openShopping(String key,String keyword){
        String openShoppingCheck = appiumDriver.findElement(By.xpath(key)).getText();
        Assert.assertEquals("alışveriş sayfası doğrulandı",keyword,openShoppingCheck);
        logger.info("Alışveriş sayfasında olduğu doğrulandı.");
    }
    @Step("<key> ve <keyword>  değerine göre kategoriler sayfası doğrulanır")
    public  void checkCategory(String key,String keyword){
        String checkCategory = appiumDriver.findElement(By.xpath(key)).getText();
        Assert.assertEquals("alışveriş sayfası doğrulandı",keyword,checkCategory);
        logger.info("Kategoriler sayfasında olduğu doğrulandı.");
    }

  }





