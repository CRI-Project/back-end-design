# back-end-design
## Project structure
## how to start the project in linux
## first you need to install jdk1.8 or above
## then execute the command "nohup java -jar xxx.jar" to run this project on the background
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
│       │   │               ├── ClimateApplication.java (start project as a consumer in rabbitmq)
│       │   │               ├── config
│       │   │               │   ├── InterceptorConfig.java (intercept some request we need to check the precondition)
│       │   │               │   ├── MybatisPlusConfig.java
│       │   │               │   ├── RabbitmqConfig.java (create exchanges and queues when we first request the method but find that there do not exist some)
│       │   │               │   └── SecurityConfig.java
│       │   │               ├── consumer
│       │   │               │   ├── ClimateDataConsumer.java (consume the messages)
│       │   │               │   └── ClimateDataTestConsumer.java (consume the messages)
│       │   │               ├── controller
│       │   │               │   ├── SensorController.java (crud of sensor)
│       │   │               │   ├── SensordataController.java (crud of message)
│       │   │               │   ├── SensordatatestController.java (crud of message)
│       │   │               │   └── UserInfoController.java (crud of users login register)
│       │   │               ├── dao
│       │   │               │   ├── SensorDao.java (database operation)
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
│       │   │               │   └── JWTInterceptor.java (intercept some request we need to check the precondition)
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
│       │   │           ├── ClimateRabbitmqApplication.java (start project as a producer in rabbitmq)
│       │   │           └── rabbitmq
│       │   │               ├── config
│       │   │               │   └── RabbitmqConfig.java (create exchanges and queues when we first request the method but find that there do not exist some)
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
