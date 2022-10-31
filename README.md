# ddd-template

## Target

Build a springboot project template based on DDD Pattern

### Given

- service name: ddd-template

### Module

- ddd-template:
    - RPC, REST, MQ access to the service.
    - application use cases
    - springboot main entry point.
- ddd-template-client:
    - client provided to the consumer.
    - DTO, timeout, retry, cache, etc.
- ddd-template-domain:
    - aggregates, domain events, domain service, repository, etc
- ddd-template-infra:
    - persistence, mq, and other detail implementation bound with specific technique.
    - Injected by IOC

## Reference

- https://medium.com/airwallex-engineering/domain-driven-design-practice-modeling-payments-system-f7bc5cf64bb3


