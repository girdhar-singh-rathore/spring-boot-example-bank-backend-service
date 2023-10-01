create package and build docker image

```shell

mvn clean package

build docker image

docker build  -t com.example/examplebank .
```

run the app in a container

```shell
docker run -d -p 8080:80 --name examplebank com.example/examplebank
```

run the app via docker compose

```shell
docker-compose build
docker-compose up
```


