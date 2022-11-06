docker-up:
	docker-compose up -d

docker-down:
	docker-compose down

build:
	cd url-shortener-api && ./gradlew build && cd ..

start:
	@make build
	@make docker-up