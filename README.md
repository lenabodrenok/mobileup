# Проект по тестированию сайта [MobileUp](https://mobileup.ru/)


## :ledger: Содержание
- [Технологический стек](#технологический-стек)
- [Реализованные проверки](#реализованные-проверки)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Запуск тестов из терминала](#запуск-тестов-из-терминала)
- [Allure отчет](#allure-отчет)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Пример запуска теста в Selenoid](#пример-запуска-теста-в-selenoid)



## :heavy_check_mark: Технологический стек <a name="технологический-стек"></a>
<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="/images/Intelij_IDEA.svg" width="50" height="50"  alt="IDEA"/></a>
<a href="https://www.java.com/"><img src="/images/Java.svg" width="50" height="50"  alt="Java"/></a>
<a href="https://github.com/"><img src="/images/Github.svg" width="50" height="50"  alt="Github"/></a>
<a href="https://junit.org/junit5/"><img src="/images/JUnit5.svg" width="50" height="50"  alt="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="/images/Gradle.svg" width="50" height="50"  alt="Gradle"/></a>
<a href="https://selenide.org/"><img src="/images/Selenide.svg" width="50" height="50"  alt="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="/images/Selenoid.svg" width="50" height="50"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="/images/Allure_EE.svg" width="50" height="50"  alt="Allure"/></a>
<a href="https://www.jenkins.io/"><img src="/images/Jenkins.svg" width="50" height="50"  alt="Jenkins"/></a>
</p>

## :heavy_check_mark: Реализованные проверки <a name="реализованные-проверки"></a>
- Проверка работы основного меню страницы
- Проверка наличия вакансии QA auto
- Проверка заполнения формы обратной связи
- Проверка работы ссылки на Телеграм-канал
- Проверка скачивания файла с презентацией

## :heavy_check_mark: Сборка в [Jenkins](https://jenkins.autotests.cloud/job/012-lenabodrenok-mobileup_tests/) <a name="сборка-в-jenkins"></a>

## :heavy_check_mark: Запуск тестов из терминала <a name="запуск-тестов-из-терминала"></a>
- [x] Локальный запуск тестов:
```
gradle clean test
```
- [x] Удаленный запуск тестов:
```
clean
test
-Dbrowser=${BROWSER}
-Dbrowser=${BROWSER_VERSION}
-DbrowserSize=${BROWSER_SIZE}
-Dselenoid_url=${SELENOID_URL}
```

## :heavy_check_mark: Allure отчет <a name="allure-отчет"></a>
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Главный экран отчета  
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Страница с проведенными тестами  
#### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Основной дашборд  

## :heavy_check_mark: Уведомления в Telegram с использованием бота <a name="уведомления-в-telegram-с-использованием-бота"></a>

## :heavy_check_mark: Пример запуска теста в Selenoid <a name="пример-запуска-теста-в-selenoid"></a>

