# Fase de build
FROM maven:3.9.5-eclipse-temurin-21-alpine AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia apenas os arquivos necessários para a build
COPY pom.xml .
COPY src ./src

# Executa a build do projeto
RUN mvn clean package -DskipTests

# Fase final
FROM eclipse-temurin:21-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado na fase de build
COPY --from=build /app/target/testeMongodb-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Define um usuário não-root para executar a aplicação
RUN adduser -D myuser
USER myuser

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]