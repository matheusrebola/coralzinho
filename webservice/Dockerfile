 ========== Dockerfile (Multi-stage build) ==========
# Estágio 1: Build
FROM maven:3.8.6-openjdk-11-slim AS builder

WORKDIR /app

# Copiar arquivos de dependências primeiro (cache de camadas Docker)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copiar código fonte
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests

# Estágio 2: Runtime
FROM openjdk:17-jre-slim

WORKDIR /app

# Criar usuário não-root para segurança
RUN groupadd -r spring && useradd -r -g spring spring

# Instalar ferramentas úteis
RUN apt-get update && apt-get install -y \
    curl \
    netcat \
    && rm -rf /var/lib/apt/lists/*

# Copiar JAR do estágio de build
COPY --from=builder /app/target/*.jar app.jar

# Criar diretórios necessários
RUN mkdir -p /app/logs /app/uploads && \
    chown -R spring:spring /app

# Script de entrada
COPY docker-entrypoint.sh /app/
RUN chmod +x /app/docker-entrypoint.sh

USER spring

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=40s --retries=3 \
    CMD curl -f http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["/app/docker-entrypoint.sh"]

# ========== Dockerfile.dev (para desenvolvimento) ==========
FROM maven:3.8.6-openjdk-11

WORKDIR /app

# Instalar ferramentas de desenvolvimento
RUN apt-get update && apt-get install -y \
    git \
    vim \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Manter container rodando para desenvolvimento
CMD ["tail", "-f", "/dev/null"]