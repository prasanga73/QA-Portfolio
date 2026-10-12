# Performance Testing

JMeter 5.6 load test of the RemoteAxle login and profile APIs (`devapi.remoteaxle.com`).

Files: [test plan](remoteaxle-auth-load-test.jmx) · [test data](data.csv) · [full report (PDF)](jmeter-performance-report.pdf)

## Test plan

1. **CSV Data Set Config** reads 10 email/password pairs from `data.csv`. One pair is deliberately invalid, so 10% of logins should fail.
2. **POST /login**, then a JSON Extractor saves `$.data.access_token` as `token`.
3. **GET /users/profile** with the header `Authorization: Bearer ${token}`.
4. **Uniform Random Timer** adds 2–3 s of think time between requests.
5. **Assertions** check the response code, response message and response size.

The plan also includes practice thread groups for JMeter's logic controllers (Simple, Loop, Random, Random Order, Module).

## Results

| Scenario | Threads | Ramp-up | Loops | Samples | Login avg | Profile avg | Login errors | Profile errors |
| --- | ---: | ---: | ---: | ---: | ---: | ---: | ---: | ---: |
| Baseline | 1 | 1 s | 1 | 2 | 754 ms | 212 ms | 0% | 0% |
| Light load | 10 | 10 s | 10 | 200 | 580 ms | 169 ms | 10% | 10% |
| Stress | 100 | 20 s | 5 | 1,000 | 681 ms | 69 ms | 10% | 93.4% |
| Peak stress | 200 | 20 s | 10 | 4,000 | 3,930 ms | 74 ms | 10% | 91.35% |
| Sustained | 100 | 100 s | 100 | 20,000 | 928 ms | 160 ms | 10% | 93.32% |

## Findings

- **Token handling fails under load.** Login errors stayed at 10% (the one invalid pair), but profile errors went above 90% from 100 threads up. If bad credentials were the only cause, profile errors would also stay at 10%, so the API stops accepting valid tokens under concurrent load.
- **Login slows down sharply at peak.** With 200 threads, average login time rose from 754 ms to 3,930 ms (99th percentile 5,905 ms, max 9,389 ms).

## Run

```bash
# GUI, for editing the plan
jmeter -t remoteaxle-auth-load-test.jmx

# CLI, for load runs (writes an HTML dashboard to report/)
jmeter -n -t remoteaxle-auth-load-test.jmx -l results.jtl -e -o report
```
