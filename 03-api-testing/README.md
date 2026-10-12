# API Testing

Postman collection for the Platzi Fake Store API (`https://api.escuelajs.co/api/v1`).

## Requests

| Area | Requests |
| --- | --- |
| Products | List, get by ID, get by slug, create, update, delete |
| Filtering & paging | `?price=100`, `?offset=0&limit=10` |
| Related products | By ID, by slug |
| Categories | List |
| Auth | Login, then get profile |

## Scripting

- **Pre-request script:** `CreateProduct` generates a unique title (`Prasanga-<timestamp>`).
- **Chaining:** the ID returned by `CreateProduct` is saved as `productId` and used by `UpdateProduct`. The `access_token` from login is saved and sent to `GetProfile` as a Bearer token.
- **Assertions:** `GetProduct` checks for status 200 and a response time under 3500 ms. `SchemaGet` validates the `/products` response against a JSON Schema (draft-07).

## Run

```bash
npm install -g newman
newman run platzi-fake-store-api.postman_collection.json
```

For an HTML report, install `newman-reporter-htmlextra` and add `-r cli,htmlextra`.
