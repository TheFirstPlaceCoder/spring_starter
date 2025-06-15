# 🚀 Spring Starter (Java + Spring JPA)

## ✨ Описание

Простой проект на Java с использованием Spring и Spring JPA, созданный для изучения основ фреймворка. Содержит примеры REST API и интеграцию с базой данных. Цель - углубить понимание принципов работы Spring JPA и REST-контроллеров. Местами shit-код, потому что не планировал заливать его куда-либо

## 🎯 Основные технологии

*   Java: Основной язык.
*   Spring: Dependency Injection, REST Controllers.
*   Spring JPA: Работа с базой данных (настраивается).
*   Gradle: Система сборки.
*   JUnit + Mockito: Тестирование.

## ⚙️ Как запустить

1.  Клонируйте репозиторий:

Bash

    git clone https://github.com/TheFirstPlaceCoder/spring-starter.git
    cd spring-starter
    

2.  Соберите проект:

Bash

    ./gradlew clean build
    

3.  Запустите приложение:

Bash

    ./gradlew bootRun
    

4.  Посетите приложение: Откройте [http://localhost:8080](http://localhost:8080) в вашем браузере.

Примечания:
*   Требуется Java 17+.
*   Перед запуском необходимо настроить подключение к базе данных в src/main/resources/application.properties.

## 📂 Структура проекта
```
spring-starter/
├── src/
│   ├── main/java/
│   │   └── by/thefirstplacecoder/spring
│   │       ├── bpp/
│   │       ├── config/
│   │       ├── database/
│   │       ├── dto/
│   │       └── ...
│   └── resources/ # application.properties
├── build.gradle # Gradle configuration
├── LICENSE
└── README.md
```
## 🤝 Вклад

Проект создан для личного обучения.

## 📄 Лицензия

[MIT License](LICENSE)

## ✉️ Контакты

*   Автор: Artik
*   GitHub: https://github.com/TheFirstPlaceCoder
