# 📊 Performance & Load Testing Suite (Apache JMeter)

This module contains complete performance test plans, test data parameterizations, and performance evaluation reports executing concurrent stress tests against **RemoteAxle API** services.

---

## 📂 Key Artifacts

- **JMeter Test Plan:** [`QA TechAxis.jmx`](./QA%20TechAxis.jmx)
- **Parameterized Test Data:** [`data.csv`](./data.csv) (10 User Credentials)
- **Formal Engineering Report:** [`JmeterReportEdited.pdf`](./JmeterReportEdited.pdf)

---

## 🏗️ Test Plan Architecture & Design

### 1. Data Parameterization (`CSV Data Set Config`)
- Sourced 10 user credential records (`email`, `password`) from `data.csv`.
- **Deliberate Negative Injection:** Exactly 1 out of the 10 rows contained invalid credentials (`created@gmail.com`). This established a controlled, expected baseline failure rate of **10.00%** on the Login API to evaluate how credential failures propagate downstream.

### 2. Request Chaining & Token Injection
1. **Sampler 1: Login API (POST)**
   - Target: `https://devapi.remoteaxle.com/login`
   - Content-Type: `application/json; charset=utf-8`
   - Request Body: JSON payload sourcing `${Email}` and `${Password}` from CSV.
2. **JSON Extractor (Post-Processor on Login)**
   - Target Variable Name: `token`
   - JSON Path Expression: `$.data.access_token`
   - Match No.: `1`, Default: `NOT FOUND`
3. **Sampler 2: Profile API (GET)**
   - Target: `https://devapi.remoteaxle.com/users/profile`
   - Chained Header: `Authorization: Bearer ${token}`

### 3. Realistic User Think Time (`Uniform Random Timer`)
Applied between request executions to simulate human interaction intervals:
- Constant Delay Offset: `2000 ms`
- Random Delay Maximum: `1000 ms`
- Formula: $\text{Delay} = (0.1 \times \text{Random Delay}) + 2000\,\text{ms}$

### 4. Applied Assertions & Listeners
- **Response Code Assertion:** Confirms HTTP `200 OK`.
- **Response Assertion:** Validates response body message strings.
- **Size Assertion:** Validates byte size thresholds.
- **Listeners:** Summary Report, Aggregate Report, and View Results Tree.

---

## 📈 Multi-Scenario Load Testing Results

Five distinct load scenarios were executed by varying the Thread Group configuration (Concurrency, Ramp-up, and Loop Count).

| Scenario | Threads | Ramp-Up | Loop Count | Total Samples | Login Avg (ms) | Profile Avg (ms) | Login Err % | Profile Err % | Total Err % | 90% Line (Total) | 99% Line (Total) |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **1: Baseline** | 1 | 1s | 1 | 2 | 754 ms | 212 ms | 0.00% | 0.00% | 0.00% | 754 ms | 754 ms |
| **2: Light Load** | 10 | 10s | 10 | 200 | 580 ms | 169 ms | 10.00% | 10.00% | 10.00% | 715 ms | 821 ms |
| **3: Stress** | 100 | 20s | 5 | 1,000 | 681 ms | 69 ms | 10.00% | **93.40%** | 51.70% | 1018 ms | 1291 ms |
| **4: Peak Stress**| 200 | 20s | 10 | 4,000 | 3,930 ms | 74 ms | 10.00% | **91.35%** | 50.68% | 5446 ms | 5837 ms |
| **5: Sustained** | 100 | 100s | 100 | 20,000 | 928 ms | 160 ms | 10.00% | **93.32%** | 51.66% | 1217 ms | 2178 ms |

---

## 🔍 Critical Performance Engineering Analysis

### 1. Root-Cause Analysis: The Token / Auth Bottleneck Under Concurrency
- **Observation:** Notice that from Scenario 2 through Scenario 5, the Login API error rate remained **exactly 10.00%** (matching the 1 bad row in the 10-row dataset). 
- **The Bottleneck:** However, starting from Scenario 3 (100 concurrent threads) to Scenario 5 (100 threads / 20k samples), the Profile API error rate exploded to **91.35% – 93.40%**.
- **Engineering Verdict:** If failures were due to bad credentials, the Profile error rate would equal the Login error rate (10%). Because Profile errors exceeded 90%, this conclusively revealed that the backend authentication microservice or token cache failed to validate/propagate bearer tokens under steep concurrent request bursts.

### 2. Latency Degradation Under Peak Concurrency (Scenario 4)
- When ramping up 200 threads in 20 seconds, the Login API average response time spiked to **3,930 ms**, with:
  - **90th Percentile:** 5,621 ms
  - **99th Percentile:** 5,905 ms
  - **Max Latency:** 9,389 ms
- This represents a **421% increase** in average response time compared to baseline, indicating severe thread queueing at the web server layer.

### 3. Ramp-Up Rate Optimization
- Comparing Scenario 3 (100 threads, 20s ramp-up) vs. Scenario 5 (100 threads, 100s ramp-up):
  - In Scenario 5, extending the ramp-up period to 100 seconds allowed the server to absorb 20,000 requests with an average response time of only 544 ms, demonstrating that gradual connection ramping significantly mitigates initial load contention.

---

## 🚀 Execution Guide

### GUI Mode (for debugging / script modification)
```bash
jmeter -t "QA TechAxis.jmx"
```

### CLI Non-GUI Mode (Recommended for test execution)
```bash
jmeter -n -t "QA TechAxis.jmx" -l "results.jtl" -e -o "./dashboard-report"
```
