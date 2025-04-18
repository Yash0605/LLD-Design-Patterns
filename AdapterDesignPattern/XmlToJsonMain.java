public class XmlToJsonMain {
    public static void main(String[] args) {
        String xmlData = "<data>Sample XML Data</data>";
        System.out.println("XML Data: " + xmlData);

        System.out.println("Analyzing XML Data using JSON Analytic Tool...");
        JSONAnalyticTool jsonAnalyticTool = new JSONAnalyticTool();
        jsonAnalyticTool.setJsonString(xmlData);
        jsonAnalyticTool.analyzeData();

        System.out.println("============================================");
        System.out.println("============================================");

        System.out.println("Analyzing XML Data using XML to JSON Adapter...");
        // Create an adapter for XML to JSON conversion
        XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter(xmlData);

        // Analyze the data using the adapter
        xmlToJsonAdapter.analyzeData();
    }
}
