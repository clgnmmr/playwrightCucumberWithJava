# playwright - java - cucumber

<hr/>

birden fazla sitesinin testlerini gerçekleştirdiğimiz bu projemizde
Cucumber BDD framework ile çalışıldı
Cucumber Framework'ünde OOP(object oriented programming) konseptine uyarak  POM(page object model) dizayn modeli kullanılmıştır

<br/>

### pages dosyası <br/>
bu dosyamızda elimizde bulunan sitenin testlerini gerçekleştireceğimiz elemenlerin locatelerini sakladığımız sınıflrımız bulunmakta.İstediğimiz locate almak için oluşturduğumuz clasın adında constructar oluşturuyoruz ve içine <b> PageFactory </b> clasını çağırıp
içerisine oluşturduğumuz driver çağırıp burada olduğunu belli ettiğimiz <b> page </b> nesnesi kullanılır. locatelerimizinde çağırabilinmesi için de <b> Locator </b> sınıfı ile locatelerimizi oluşturabiliriz

### runner dosyası <br/>
runner sınıfımızda kullandığımız notasyonlar sayesinde burda çalıştırabildiğimiz <b>feature</b>  dosyalarının hem raporlarını alabiliyoruz hemde istenilen yöntemlerin oluşturulması sağlanabiliyor

### stepDefinitons dosyası <br/>
burda ise tüm kodlarımızın çalışmasını sağlayan yöntemlerimizin bulunduğu sınıflarımız vardır.Locatelerimizi , sürücümüzü buraya çağırarak yapmak istediğimiz adımların kodlarını burda yazıyoruz

### Utilities dosyası <br/>
yardımcı sınıflarımız bu dosyamızda bize sürekli lazım olan sınıflarımız ve yöntemlerimiz bulunmaktadır. İçerisinde  projemizi daha anlaşılır hale getirecek sınıflarımız ve yöntemleriiz vardır bunlar
<b> Driver.class </b> , <b> ConfigReader.class</b> , <b> ReusableMehod.class </b> vb.  dosyalarımız bulunmaktadır.

### resources dosyası <br/>
<b> feature </b> dosyalarımızın bulunduğu klasörümüzdür, burda <b>BDD</b> (behavior Driven Development) kullanılarak ve <b> Gherking </b> dili kullanılarak senaryolarımız oluşturuluyor. Oluşturduğumuz adımları direk 
yöntem olarak oluşturma fırsatı tanımakta bu sayede java dili yada yazılım ile alakası olmayan kişilerinde yapılanları daha anlaşılır bir hale getirilmesini sağlamaktadır 

### <b> Configuration.properties </b>
properties dosyamızda sürekli kullandığımız verilerimiz bulunmakta , bu verilerimizi kullanmak için properties dosyası <b> Key  =  value </b> olarak oluşturulmakta ,burdaki bilgileri başka sınıflara çağırabilmek için utilities dosyasından
<b> ConfigReader </b> sınıfını çağırırlarsa içindeki yöntem sayesinde bu dosyada bulunan bilgileri istediğimiz yerlere çağırabiliriz.

## pom.xml
tüm çalışmalarımızın ve kodlarımızın bilgilerinin bulunduğu bu dosyada aslında kullanmak istediğimiz kodların kütüphanesini  <b> dependencies </b> başlığı içerisine yerleştirip güncel bilgilerini sürekli olarak kendimizde tutabiliriz.
burası sayesinde tüm kodlara erişimi sağlayabiliriz.

<hr/>

# Playwright Test

<br/>

Cucumber BDD framework kullanılarak, Java21  ve Maven projesi oluşturulmuştur.

<br/>

<a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="50" height="50"/> </a>
<a href="https://git-scm.com/" target="_blank" rel="noreferrer"> <img src="https://www.vectorlogo.zone/logos/git-scm/git-scm-icon.svg" alt="git" width="40" height="40"/> </a>
<a href="https://www.playwright.com" target="_blank" rel="noreferrer"> <img src="https://playwright.dev/img/playwright-logo.svg" alt="Playwright" width="50" height="50"/> </a>
<a href="https://www.intelj.com" target="_blank" rel="noreferrer"> <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQak-N8W03mK25slV1lwM80i0y1obRPPJOaLA&usqp=CAU" alt="intelj" width="80" height="40"/> </a>
<a href="https://www.maven.com" target="_blank" rel="noreferrer"> <img src="https://koraypeker.com/wp-content/uploads/2018/06/1_xsrKVt69q3JsZzLD-ldekQ.jpeg" alt="git" width="100" height="40"/> </a>

<hr/>
