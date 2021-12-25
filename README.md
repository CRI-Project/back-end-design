# back-end-design

<pre>
.
├── HELP.md
├── climate-crud
│   ├── climate-crud.iml
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── lzz
│       │   │           └── climate
│       │   │               ├── ClimateApplication.java
│       │   │               ├── config
│       │   │               │   ├── InterceptorConfig.java
│       │   │               │   ├── MybatisPlusConfig.java
│       │   │               │   ├── RabbitmqConfig.java
│       │   │               │   └── SecurityConfig.java
│       │   │               ├── consumer
│       │   │               │   ├── ClimateDataConsumer.java
│       │   │               │   └── ClimateDataTestConsumer.java
│       │   │               ├── controller
│       │   │               │   ├── SensorController.java
│       │   │               │   ├── SensordataController.java
│       │   │               │   ├── SensordatatestController.java
│       │   │               │   └── UserInfoController.java
│       │   │               ├── dao
│       │   │               │   ├── SensorDao.java
│       │   │               │   ├── SensordataDao.java
│       │   │               │   ├── SensordatatestDao.java
│       │   │               │   └── UserInfoDao.java
│       │   │               ├── entity
│       │   │               │   ├── SecurityEntity.java
│       │   │               │   ├── SensorEntity.java
│       │   │               │   ├── SensordataEntity.java
│       │   │               │   ├── SensordatatestEntity.java
│       │   │               │   └── UserInfoEntity.java
│       │   │               ├── exception
│       │   │               │   ├── ApiExceptionCode.java
│       │   │               │   ├── GlobalExceptionHandler.java
│       │   │               │   └── RRException.java
│       │   │               ├── filter
│       │   │               │   └── filter.java
│       │   │               ├── interceptor
│       │   │               │   └── JWTInterceptor.java
│       │   │               ├── service
│       │   │               │   ├── SensorService.java
│       │   │               │   ├── SensordataService.java
│       │   │               │   ├── SensordatatestService.java
│       │   │               │   ├── UserInfoService.java
│       │   │               │   └── impl
│       │   │               │       ├── SensorServiceImpl.java
│       │   │               │       ├── SensordataServiceImpl.java
│       │   │               │       ├── SensordatatestServiceImpl.java
│       │   │               │       ├── SpringSecurityUserServiceImpl.java
│       │   │               │       └── UserInfoServiceImpl.java
│       │   │               ├── utils
│       │   │               │   ├── Constant.java
│       │   │               │   ├── CookieUtils.java
│       │   │               │   ├── GetCode.java
│       │   │               │   ├── ImgFontByte.java
│       │   │               │   ├── JWTUtils.java
│       │   │               │   ├── JsonReader.java
│       │   │               │   ├── PageUtils.java
│       │   │               │   ├── Query.java
│       │   │               │   ├── R.java
│       │   │               │   └── ValidateCode.java
│       │   │               └── xss
│       │   │                   └── SQLFilter.java
│       │   └── resources
│       │       ├── application.yml
│       │       └── mapper
│       │           ├── SensorDao.xml
│       │           ├── SensordataDao.xml
│       │           ├── SensordatatestDao.xml
│       │           └── UserinfoDao.xml
│       └── test
│           └── java
├── climate-observation.iml
├── climate-rabbitmq
│   ├── climate-rabbitmq.iml
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── lzz
│       │   │           ├── ClimateRabbitmqApplication.java
│       │   │           └── rabbitmq
│       │   │               ├── config
│       │   │               │   └── RabbitmqConfig.java
│       │   │               ├── controller
│       │   │               │   └── SentDataController.java
│       │   │               ├── entity
│       │   │               │   ├── SensordataEntity.java
│       │   │               │   ├── SensordatatestEntity.java
│       │   │               │   └── UserInfoEntity.java
│       │   │               ├── service
│       │   │               │   └── SentDataService.java
│       │   │               └── utils
│       │   │                   ├── JsonReader.java
│       │   │                   └── R.java
│       │   └── resources
│       │       └── application.yml
│       └── test
│           └── java
├── mvnw
├── mvnw.cmd
├── pom.xml
</pre>
