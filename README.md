# Тестовый сервис для запуска приложения в Docker и k8s с подключением к Postgresql

Запуск dev БД в docker-compose.dev
```
$ docker-compose -f docker-compose.dev.yml up -d
```
Запуск prod БД и сборки самого приложения в docker-compose.prod
```
$ docker-compose -f docker-compose.prod.yml up -d
```

.env - хранит переменные окружения (docker-compose автоматически их подтягивает)

### Spring profiles
local - запускаем с этим профилем приложение локально


