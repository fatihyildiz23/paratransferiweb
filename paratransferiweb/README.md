# Para transferi otomasyon altyapısı

Bu proje, web uygulamalarının otomatik testlerini gerçekleştirmek için Selenium 4, Cucumber ve Java kullanılarak oluşturulmuş bir test otomasyon frameworkudur.

## 🛠 Teknolojiler & Araçlar

- Java 11
- Selenium 4.16.1
- Cucumber 7.14.0
- Maven
- Allure Reporting
- WebDriverManager
- SLF4J & Logback
- Jackson (JSON parsing)

## 🏗 Proje Yapısı
web-test-automation/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── testautomation/
│ │ │ ├── config/
│ │ │ ├── driver/
│ │ │ ├── pages/
│ │ │ └── utils/
│ └── test/
│ ├── java/
│ │ └── com/
│ │ └── testautomation/
│ │ ├── runners/
│ │ └── stepdefinitions/
│ └── resources/
│ ├── features/
│ └── selectors/

1. Gereksinimleri yükleyin:
   - Java 11 JDK
   - Maven
   - Chrome/Firefox tarayıcı

   ### Belirli Bir Tarayıcıda Çalıştırma
   mvn clean test -Dbrowser=chrome
   mvn clean test -Dbrowser=firefox


## 📝 Test Yazma Kılavuzu

### Feature Dosyası Örneği
Feature: Login Functionality
@smoke @regression
Scenario: Successful login with valid credentials
user is on login page
"loginPage.usernameInput" alanina "test@test.com" yazilir
"loginPage.passwordInput" alanina "Test123!" yazilir
"loginPage.loginButton" elementine tiklanir



### Selector Tanımlama
Selector'lar JSON formatında tanımlanır (`src/test/resources/selectors/all-selectors.json`):
{
"loginPage": {
"usernameInput": {
"type": "css",
"value": "input[placeholder='Username']"
}
}
}

## 📊 Raporlama

### Allure Raporu Oluşturma
bash
mvn allure:serve


Raporlar şu konumlarda oluşturulur:
- Allure raporu: `target/allure-results`
- Cucumber HTML raporu: `target/cucumber-reports`

## 🔍 Sorun Giderme

### Yaygın Hatalar ve Çözümleri

1. Element Bulunamadı Hatası
   - Selector'ların doğruluğunu kontrol edin
   - Bekleme sürelerini artırın
   - Sayfanın tamamen yüklendiğinden emin olun

2. Test Çalıştırma Hataları
   - Maven bağımlılıklarını temizleyin: `mvn clean`
   - IDE'yi yeniden başlatın
   - WebDriver'ı güncelleyin

3. Chrome Versiyonu Uyumsuzluğu
   - WebDriverManager versiyonunu güncelleyin
   - Chrome tarayıcınızı güncelleyin

