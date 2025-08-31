# Тестовый сервис для запуска приложения в Docker и k8s с подключением к Postgresql

Запуск dev БД в docker-compose.dev
```
$ docker-compose -f docker-compose.dev.yml up -d
```
Запуск prod приложения и БД средствами minikube
```
$ minikube start --driver=docker
- запуск minikube 
(если запускается с ошибками, то перед стартом выполнить $ minikube delete --all --purge)

$ minikube addons list
- проверяем в аддонах, что ingress выключен.

$ minikube addons disable ingress
- выключаем, если включен
------------------------------------------------------------------------------------------------------------------
# Создать ConfigMap и Secret
$ kubectl apply -f k8s/configmap.yaml
$ kubectl apply -f k8s/secret.yaml

# Применяем PostgreSQL
$ kubectl apply -f k8s/postgres/postgres-pv.yaml
$ kubectl apply -f k8s/postgres/postgres-statefulset.yaml
$ kubectl apply -f k8s/postgres/postgres-service.yaml

# Применяем приложение
$ kubectl apply -f k8s/app/app-deployment.yaml
$ kubectl apply -f k8s/app/app-service.yaml

# Применяем Ingress
$ kubectl apply -f k8s/ingress/ingress.yaml
---------------------------------------------------------
# проверка
$ kubectl get pods
$ kubectl get svc
$ kubectl get ingress
$ kubectl get configmap
$ kubectl get secret
------------------------------------------------------------------------------------------------------------------
# устанавливка ingress-контроллер через helm
$ helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
- добавить ingress-nginx репозиторий (если отсутствует)

$ helm install nginx-ingress ingress-nginx/ingress-nginx -f k8s/ingress/nginx-ingress.yaml --namespace ingress-nginx --create-namespace

---------------------------------------------------------
# проверки

# проверка, что контроллер запущен
$ kubectl get pods -n ingress-nginx

# проверка, что сервис контроллера запущен
$ kubectl get svc -n ingress-nginx
---------------------------------------------------------
$ helm delete nginx-ingress -n ingress-nginx
- если нужно удалить ингресс контроллер для дальнейшей переустановки
---------------------------------------------------------
$ minikube tunnel
- в отдельной вкладке терминала запускаем туннель
------------------------------------------------------------------------------------------------------------------
(для windows) добавь в etc\hosts
127.0.0.1 testkuber
```

### Spring profiles
local - запускаем с этим профилем приложение локально


### URL для доступа из браузера 
#### (хост указан в ingress.yaml)
http://testkuber/all