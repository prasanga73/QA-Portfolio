# ⚡ REST API Testing & Automation Framework

This module contains production-grade automated API testing collections built using **Postman**, featuring full CRUD lifecycle validation, pre-request dynamic scripting, chained JWT Bearer authentication, and JSON Schema assertion.

---

## 🎯 Target Application & Endpoints

- **Base URL:** `https://api.escuelajs.co/api/v1` (Platzi Fake Store REST API)
- **Collection File:** [`Platzi API.postman_collection.json`](./Platzi%20API.postman_collection.json)
- **Scope:** 14 automated API requests across products, categories, filters, schema validation, and authentication.

---

## 📋 Endpoint & Test Request Breakdown

| Request Name | Method | Path | Test Purpose & Assertions |
| :--- | :---: | :--- | :--- |
| **GetCategories** | `GET` | `/categories` | Verifies response code `200 OK`, validates list of available product categories. |
| **GetProducts (Filter)** | `GET` | `/products/?price=100` | Tests query parameter filtering, verifies all returned items match price criteria. |
| **SchemaGet** | `GET` | `/products` | **JSON Schema Validation (draft-07):** Validates array structure, property types (`id`, `title`, `price`, `description`, `images`), and required fields. |
| **GetProduct** | `GET` | `/products` | Status code `200 OK`, SLA response time check (`< 3500ms`), array non-empty assertion. |
| **CreateProduct** | `POST` | `/products/` | Dynamic title injection via pre-request script (`Prasanga-<timestamp>`), asserts `201 Created`, captures `responseBody.id` to collection variable `productId`. |
| **SingleGetProducts** | `GET` | `/products/:id` | Validates single product lookup using dynamically captured `{{productId}}` or randomized ID. |
| **GetSlug** | `GET` | `/products/slug/:slug` | Validates slug-based product routing and payload integrity. |
| **UpdateProduct** | `PUT` | `/products/:id` | Updates title/price of the newly created product; asserts HTTP status `200 OK` and updated fields. |
| **DeleteProduct** | `DELETE` | `/products/:id` | Tests product removal, asserts HTTP status `200 OK` or `204 No Content` and boolean return flag. |
| **Pagination** | `GET` | `/products?offset=0&limit=10` | Validates pagination limit, page boundaries, and response array length = 10. |
| **RelatedById** | `GET` | `/products/:id/related` | Validates recommendation engine endpoint returning related items by ID. |
| **RelatedSlug** | `GET` | `/products/slug/:slug/related` | Validates recommendation engine endpoint returning related items by product slug. |
| **AuthJWT (Login)** | `POST` | `/auth/login` | Authenticates with credentials, asserts status `201/200`, extracts `access_token` and saves to collection variable. |
| **GetProfile** | `GET` | `/auth/profile` | Injects extracted `{{access_token}}` into `Authorization: Bearer` header, asserts status `200 OK` and validates profile attributes. |

---

## 🛠️ Advanced Scripting Highlights

### 1. Dynamic Pre-Request Title Generation
```javascript
// Automatically executed before CreateProduct runs
pm.variables.set("randomTitle", "Prasanga-" + Date.now());
```

### 2. Variable Chaining (Dynamic ID & Auth Token Extraction)
```javascript
// Inside CreateProduct test script:
const responseBody = pm.response.json();
pm.collectionVariables.set("productId", responseBody.id);

// Inside AuthJWT test script:
const authBody = pm.response.json();
pm.collectionVariables.set("access_token", authBody.access_token);
```

### 3. Strict JSON Schema Validation
```javascript
const schema = {
  "$schema": "http://json-schema.org/draft-07/schema#",
  "title": "Products Schema",
  "type": "array",
  "items": {
    "type": "object",
    "required": ["id", "title", "price", "description", "images", "category"],
    "properties": {
      "id": { "type": "number" },
      "title": { "type": "string" },
      "price": { "type": "number" },
      "description": { "type": "string" },
      "images": { "type": "array" }
    }
  }
};

pm.test("Validate Product JSON Schema", function () {
  pm.expect(tv4.validate(pm.response.json(), schema)).to.be.true;
});
```

---

## 🚀 Execution via Newman CLI

Run the collection and generate a rich HTML report:

```bash
# Install newman if not already present:
npm install -g newman newman-reporter-htmlextra

# Run collection:
newman run "Platzi API.postman_collection.json" \
  --reporters cli,htmlextra \
  --reporter-htmlextra-export platzi-api-report.html
```
