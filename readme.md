## Apresentação Quarkus

Falar sobre alguns pontos relevantes do Quarkus

1. Consumo de Memória
2. Tempo de Boot
3. Implementação Microprofile
4. Criado para Cloud Native
   1. Pensado para criação de Microservicos
   2. Deploy
5. Re-deploy
6. Migração facilitada
   1. Integrações e Extensões
7. Core HTTP utiliza Vert.x
8. OpenSource mantido Pela RedHat
9. Pode combinar Imperativa e Reativo
10. Comunidade forte

---

Criando Microserviço com Quarkus

- Faze demonstração

  - Criar Microserviço de Pedidos
    - Criar endpoint básico `index` printar `quarkus na invillia`
      - Redeploy :heavy_check_mark:
    - Criar Entidade
      - extend PanacheEntity :heavy_check_mark:
  - Criar End-point
      - POST
        - Criar exception handler informando que produto já está cadastrado :heavy_check_mark:
      - GET
        - paginação :heavy_check_mark:
        - Projections :heavy_check_mark:
  - Criar Microserviço de Confirmação de Pedido :heavy_check_mark:
  - Criando Profiles :heavy_check_mark:
  - fault-tolerance
    - Annotation `@Retry`, usando para quando der error retentar
    - Annotation `@Timeout`
    - Annotation `@Fallback`
  
