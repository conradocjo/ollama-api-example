# Exemplo de uso do Ollama com Springboot.

Projeto gerado no https://start.spring.io/

docker-compose.yaml está no repositório resources.

Rodando o Ollama:

deixe o docker-compose.yaml como abaixo:

```yaml
version: '3.8'

services:
  ollama:
    image: ollama/ollama
    container_name: ollama
    ports:
      - "11434:11434"
    volumes:
      - ollama_data:/root/.ollama
    restart: unless-stopped
    runtime: nvidia  # Remova esta linha se não estiver usando GPU/NVIDIA

volumes:
  ollama_data:
```

Depois execute os comandos:

```bash
docker-compose up -d

curl http://localhost:11434

curl -X POST http://localhost:11434/api/pull -d '{"name": "llama3"}'

curl -X POST http://localhost:11434/api/generate -d '{
  "model": "llama3",
  "prompt": "Qual é a capital da França?"
}'
```


Agora suba a aplicação Java em uma IDE, ou gere o pacote com comando:

```bash
mvn clean package


