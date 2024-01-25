# ddd-template

## Target

Build a springboot project template based on DDD Pattern

### Given

- service name: ddd-template

### Module

- ddd-template-starter:
  - springboot main entry point.
- ddd-template-api:
  - RPC, REST, MQ access to the service.
- ddd-template-client:
  - client provided to the consumer.
  - DTO, timeout, retry, cache, etc.
- ddd-template-application:
    - application use cases
- ddd-template-domain:
    - aggregates, domain events, domain service, repository, etc
- ddd-template-infra:
    - persistence, mq, and other detail implementation bound with specific technique.
    - Injected by IOC
- ddd-template-common
  - common model definition following DDD pattern, such as AggregateRoot, DomainEvent, etc.

## Reference

- https://medium.com/airwallex-engineering/domain-driven-design-practice-modeling-payments-system-f7bc5cf64bb3


