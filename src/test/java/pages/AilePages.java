package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

public class AilePages {


    public AilePages(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(),Duration.ofSeconds(15)),this);
    }

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private MobileElement emailBox;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private MobileElement passwordBox;

    @FindBy(id = "text2")
    public MobileElement basariliGirisText;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement  email;

    @FindBy(xpath = "//*[@text='Hesabım']")
    public MobileElement hesabımText;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isim;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisim;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehir;

    @FindBy(xpath = "(//*[@class='android.view.ViewGroup'])[10]")
    public MobileElement cinsiyet;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[1]")
    public MobileElement erkek;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    public MobileElement kadın;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement yas;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[6]")
    public MobileElement mevkiTanımı;






    public void ilkEkranAyarlari(int xPress,int yPress, int bekleme,int xMove,int yMove,String girisYap) throws InterruptedException {
        Driver.getAndroidDriver();
        Thread.sleep(2000);
        for (int i = 0; i < 6; i++) {
            ReusableMethods.ekranKaydirmaMethodu(xPress,yPress,bekleme,xMove,yMove);
        }
        ReusableMethods.scrollWithUiScrollableAndClick(girisYap);
    }

    public void loginMethodu(String email,String password){
        Driver.getAndroidDriver();
        emailBox.sendKeys(ConfigReader.getProperty(email));
        passwordBox.sendKeys(ConfigReader.getProperty(password));
        ReusableMethods.scrollWithUiScrollableAndClick("Giriş Yap");
    }

    public void girisDogrulama(int xPress,int yPress, int bekleme,int xMove,int yMove) throws InterruptedException {
        Driver.getAndroidDriver();
        Thread.sleep(2000);
        ReusableMethods.ekranKaydirmaMethodu(xPress,yPress,bekleme,xMove,yMove);
        Assert.assertEquals(email,ConfigReader.getProperty("email"));

    }

    public void clickHesabım(){
        Driver.getAndroidDriver();
        hesabımText.click();

    }

    public void hesapBilgileriniDegistir(String isimX,String soyisimX, String sehirX,String cinsiyetX,String yasX,String rolX) throws InterruptedException {
        Driver.getAndroidDriver();
        Thread.sleep(2000);
        isim.sendKeys(isimX);
        soyisim.sendKeys(soyisimX);
        sehir.sendKeys(sehirX);
        cinsiyet.click();
        if(cinsiyetX.equalsIgnoreCase("Erkek")){
            erkek.click();
        }
        if(cinsiyetX.equalsIgnoreCase("Kadın")){
            kadın.click();
        }
        yas.sendKeys(yasX);
        mevkiTanımı.sendKeys(rolX);

    }



}
