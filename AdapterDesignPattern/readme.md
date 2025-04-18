# Adapter Design Pattern

The Adapter Design Pattern is a **structural design pattern** that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces by converting the interface of one class into another that a client expects.

## Explanation of the Code

This example demonstrates the Adapter Design Pattern by converting XML data into JSON format so that it can be analyzed using a JSON analytic tool.

### Components

1. **Target Interface (`AnalyticalTool`)**:
   - This is the interface expected by the client.
   - It defines the method `analyzeData()` that all concrete implementations must provide.

   ```java
   public interface AnalyticalTool {
       public void analyzeData();
   }
   ```

2. **Adaptee (`JSONAnalyticTool`)**:
   - This is the existing class with an incompatible interface.
   - It provides functionality to analyze JSON data.

   ```java
   public class JSONAnalyticTool {
       private String jsonData;

       public void setJsonString(String data) {
           this.jsonData = data;
       }

       public void analyzeData() {
           if (jsonData.contains("json")) {
               System.out.println("Valid JSON: Analyzing the data...");
           } else {
               System.out.println("Invalid JSON: please provide the data in correct format.");
           }
       }
   }
   ```

3. **Adapter (`XmlToJsonAdapter`)**:
   - This class adapts the interface of `JSONAnalyticTool` to the `AnalyticalTool` interface.
   - It converts XML data into JSON format and delegates the analysis to `JSONAnalyticTool`.

   ```java
   public class XmlToJsonAdapter implements AnalyticalTool {
       private JSONAnalyticTool jsonAnalyticTool;

       public XmlToJsonAdapter(String data) {
           System.out.println("Converting XML to JSON...");
           String newData = data + " json";
           jsonAnalyticTool = new JSONAnalyticTool();
           jsonAnalyticTool.setJsonString(newData);
       }

       @Override
       public void analyzeData() {
           jsonAnalyticTool.analyzeData();
       }
   }
   ```

4. **Client (`XmlToJsonMain`)**:
   - The client uses the `AnalyticalTool` interface to analyze data.
   - It demonstrates the use of both the `JSONAnalyticTool` directly and the `XmlToJsonAdapter`.

   ```java
   public class XmlToJsonMain {
       public static void main(String[] args) {
           String xmlData = "<data>Sample XML Data</data>";
           System.out.println("XML Data: " + xmlData);

           System.out.println("Analyzing XML Data using JSON Analytic Tool...");
           JSONAnalyticTool jsonAnalyticTool = new JSONAnalyticTool();
           jsonAnalyticTool.setJsonString(xmlData);
           jsonAnalyticTool.analyzeData();

           System.out.println("============================================");
           System.out.println("Analyzing XML Data using XML to JSON Adapter...");
           XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter(xmlData);
           xmlToJsonAdapter.analyzeData();
       }
   }
   ```

### How It Works

1. The `XmlToJsonMain` class demonstrates the problem of analyzing XML data using a tool designed for JSON data.
2. The `XmlToJsonAdapter` acts as a bridge by converting XML data into JSON format and delegating the analysis to the `JSONAnalyticTool`.
3. The client (`XmlToJsonMain`) interacts with the `XmlToJsonAdapter` through the `AnalyticalTool` interface, making the adapter transparent to the client.

### Output

When you run the `XmlToJsonMain` class, the output will be:

```

XML Data: <data>Sample XML Data</data>
Analyzing XML Data using JSON Analytic Tool...
Invalid JSON: please provide the data in correct format.
============================================
Analyzing XML Data using XML to JSON Adapter...
Converting XML to JSON...
Valid JSON: Analyzing the data...
```

### Benefits of the Adapter Design Pattern

- Allows incompatible interfaces to work together.
- Promotes reusability of existing code.
- Provides flexibility by decoupling the client from the implementation of the adaptee.

### Use Cases

- When you want to use an existing class but its interface does not match the one you need.
- When you need to create a reusable class that cooperates with unrelated or unforeseen classes.

This example demonstrates how the Adapter Design Pattern can be used to integrate incompatible systems seamlessly.
