# ireport component

The ireport component provides facilities for integrating applications with the use of report generation components.

Its objective is to reduce the complexity for: reading, generating and viewing reports.

### Use Example

```
List<Object> objects = ... // your list of objects from database, etc

Map<String, Object> params = newHashMap();
params.put("ONE_PARAM", new Object());

Report report = new ReportImpl("report.jrxml");
byte[] relbytes = report.export(clockMirrors, params, TypeReport.PDF);
```